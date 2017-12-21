package cn.itcast.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class PropertiesDemo1 {
	public static void main(String[] args) throws Exception {
		// 使用类加载器
		InputStream in = PropertiesDemo1.class.getClassLoader().getResourceAsStream("database.properties");
		// 创建properties对象
		Properties ps = new Properties();
		// 加载文件
		ps.load(in);
		// 获取集合中的键值对

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
