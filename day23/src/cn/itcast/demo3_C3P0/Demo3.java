package cn.itcast.demo3_C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo3 {
	public static void main(String[] args) throws SQLException {
		//直接创建c3p0 连接池对象
		ComboPooledDataSource pd = new ComboPooledDataSource();
		//创建连接
		Connection conn = pd.getConnection();
		
		Statement stat = conn.createStatement();
		/*
		 * 注意：这里的values的内容只能使用单引号！！！！！！！！！
		 */
		//String sql = "INSERT INTO products VALUES (NULL,'奥迪三轮车',666,1,1)";
//		int row = stat.executeUpdate(sql);
	//	ResultSet rs = stat.executeQuery("select * from products");
		
		//int row = stat.executeUpdate("insert into products values(NULL,'奥迪三轮车',666,1,1)");

	}

}
