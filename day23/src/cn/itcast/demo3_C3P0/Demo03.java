package cn.itcast.demo3_C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo03 {
	public static void main(String[] args) throws SQLException {
		//1.创建一个C3P0连接池对象
		//ComboPooledDataSource ds = new ComboPooledDataSource()
		ComboPooledDataSource ds = new ComboPooledDataSource();
		//2.获得连接
		Connection conn = ds.getConnection();
		//3.创建执行sql语句平台
		Statement stat = conn.createStatement();
		//4.执行sql语句
		ResultSet rs = stat.executeQuery("select * from products");
		//处理结果集
		while(rs.next()){
			System.out.println(rs.getInt("pid")+"\t"+rs.getString("pname"));
		}
		rs.close();
		conn.close();
		stat.close();
	}

}
