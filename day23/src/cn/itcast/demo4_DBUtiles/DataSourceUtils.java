package cn.itcast.demo4_DBUtiles;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	/*
	 * 这是定义一个获取C3P0连接池工具类
	 */
	private static DataSource datasource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return datasource;
	}

}
