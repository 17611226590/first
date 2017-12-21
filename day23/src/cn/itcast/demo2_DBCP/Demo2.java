package cn.itcast.demo2_DBCP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/*
 * 注意：配置文件中的键是不能改的，就用老师发的那个配置文件就行
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		// 1.读取配置文件
		Properties pro = new Properties();
		pro.load(Demo2.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		// 2.创建DBCP连接池对象
		// DataSource ds = BasicDataSourceFactory.createDataSource(pro);
		DataSource ds = BasicDataSourceFactory.createDataSource(pro);
		// 3.从连接池获取一个连接对象
		Connection conn = ds.getConnection();
		// 4.获取sql执行平台
		Statement stat = conn.createStatement();
		// 5.执行sql语句
		String sql = "select * from products";
		ResultSet rs = stat.executeQuery(sql);
		// 处理结果集
		while (rs.next()) {
			System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname"));
		}
		// 关闭资源
		stat.close();
		rs.close();
		conn.close();

	}

}
