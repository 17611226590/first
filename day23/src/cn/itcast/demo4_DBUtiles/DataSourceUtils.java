package cn.itcast.demo4_DBUtiles;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	/*
	 * ���Ƕ���һ����ȡC3P0���ӳع�����
	 */
	private static DataSource datasource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return datasource;
	}

}
