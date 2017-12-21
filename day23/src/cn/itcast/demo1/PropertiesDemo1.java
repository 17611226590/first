package cn.itcast.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PropertiesDemo1 {
	public static void main(String[] args) throws Exception {
		// ʹ���������
		InputStream in = PropertiesDemo1.class.getClassLoader().getResourceAsStream("database.properties");
		// ����properties����
		Properties ps = new Properties();
		// �����ļ�
		ps.load(in);
		// ��ȡ�����еļ�ֵ��

		String driverClass = ps.getProperty("driverManager");
		String url = ps.getProperty("url");
		String root = ps.getProperty("user");
		String password = ps.getProperty("password");
		System.out.println(driverClass);
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url, root, password);
		System.out.println(conn);

	}

}
