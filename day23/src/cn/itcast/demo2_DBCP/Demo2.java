package cn.itcast.demo2_DBCP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/*
 * ע�⣺�����ļ��еļ��ǲ��ܸĵģ�������ʦ�����Ǹ������ļ�����
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		// 1.��ȡ�����ļ�
		Properties pro = new Properties();
		pro.load(Demo2.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		// 2.����DBCP���ӳض���
		// DataSource ds = BasicDataSourceFactory.createDataSource(pro);
		DataSource ds = BasicDataSourceFactory.createDataSource(pro);
		// 3.�����ӳػ�ȡһ�����Ӷ���
		Connection conn = ds.getConnection();
		// 4.��ȡsqlִ��ƽ̨
		Statement stat = conn.createStatement();
		// 5.ִ��sql���
		String sql = "select * from products";
		ResultSet rs = stat.executeQuery(sql);
		// ��������
		while (rs.next()) {
			System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname"));
		}
		// �ر���Դ
		stat.close();
		rs.close();
		conn.close();

	}

}
