package cn.itcast.demo2_DBCP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Demo03 {
	public static void main(String[] args) throws Exception {
		Properties ps = new Properties();
		ps.load(Demo03.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
		DataSource ds = BasicDataSourceFactory.createDataSource(ps);
		Connection conn = ds.getConnection();
		// PreparedStatement ps = conn.prepareStatement("select * from
		// products");
		String sql = "select * from products";
		PreparedStatement pre = conn.prepareStatement(sql);

		// ÷¥––sql”Ôæ‰
		ResultSet rs = pre.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname"));

		}
		rs.close();
		conn.close();
		pre.close();
	}

}
