package cn.itcast.demo4_DBUtiles;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * ��ȡ���ӳض���Ĺ�����
 */
public class DSUtiles {
	private static DataSource ds = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return ds;
	}

}
