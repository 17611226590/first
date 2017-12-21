package cn.itcast.demo4_DBUtiles;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 获取连接池对象的工具类
 */
public class DSUtiles {
	private static DataSource ds = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return ds;
	}

}
