package cn.itcast.demo3_C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo03 {
	public static void main(String[] args) throws SQLException {
		//1.����һ��C3P0���ӳض���
		//ComboPooledDataSource ds = new ComboPooledDataSource()
		ComboPooledDataSource ds = new ComboPooledDataSource();
		//2.�������
		Connection conn = ds.getConnection();
		//3.����ִ��sql���ƽ̨
		Statement stat = conn.createStatement();
		//4.ִ��sql���
		ResultSet rs = stat.executeQuery("select * from products");
		//��������
		while(rs.next()){
			System.out.println(rs.getInt("pid")+"\t"+rs.getString("pname"));
		}
		rs.close();
		conn.close();
		stat.close();
	}

}
