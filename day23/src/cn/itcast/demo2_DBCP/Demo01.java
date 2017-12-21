package cn.itcast.demo2_DBCP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Demo01 {
	public static void main(String[] args) throws Exception {
		//1.��ȡ�����ļ�
		Properties ps = new Properties();
		ps.load(Demo01.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		//2.�������ӳض���
		DataSource ds = BasicDataSourceFactory.createDataSource(ps);
		//3.��������
		Connection conn = ds.getConnection();
		//4.��ȡִ��sql���ƽ̨
		Statement stat = conn.createStatement();
		//5.ִ��sql���
		String sql = "select * from products";
		ResultSet rs = stat.executeQuery(sql);
		
		//6.��������
		ArrayList<Product> list = new ArrayList<>();
		while(rs.next()){
			Product p = new Product(rs.getInt("pid"),rs.getString("pname"),
					rs.getInt("price"),rs.getInt("flag"),rs.getInt("category_id"));
			list.add(p);
		}
		//�ر���Դ
		rs.close();
		conn.close();
		stat.close();
		for (Product product : list) {
			System.out.println(product);
		}
		
		
		
		
		
		
		
	}

}
