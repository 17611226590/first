package cn.itcast.demo3_C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo3 {
	public static void main(String[] args) throws SQLException {
		//ֱ�Ӵ���c3p0 ���ӳض���
		ComboPooledDataSource pd = new ComboPooledDataSource();
		//��������
		Connection conn = pd.getConnection();
		
		Statement stat = conn.createStatement();
		/*
		 * ע�⣺�����values������ֻ��ʹ�õ����ţ�����������������
		 */
		//String sql = "INSERT INTO products VALUES (NULL,'�µ����ֳ�',666,1,1)";
//		int row = stat.executeUpdate(sql);
	//	ResultSet rs = stat.executeQuery("select * from products");
		
		//int row = stat.executeUpdate("insert into products values(NULL,'�µ����ֳ�',666,1,1)");

	}

}
