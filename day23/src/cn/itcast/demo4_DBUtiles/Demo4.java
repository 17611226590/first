package cn.itcast.demo4_DBUtiles;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo4 {
	// ����DBUtiles�ĺ�����QueryRunner
	@Test
	public void add() throws Exception {
		/*
		 * �����update�ײ�϶��õ���prepareStatemen ���Դ�����ҪԤ����
		 */
		QueryRunner qr = new QueryRunner(DSUtiles.getDataSource());
		String sql = "insert into products values(null,?,?,?,?)";
		int row = qr.update(sql, "����", 10, 1, 1);
		System.out.println("��Ӱ��������ǣ�" + row);

	}

	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner(DSUtiles.getDataSource());
		String sql = "update products set pname = ? where pid =?";
		int row = qr.update(sql, "ѩ��", 10);
		System.out.println("��Ӱ��������ǣ�" + row);

	}

	@Test
	public void delete() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String sql = "delete from products where pid = ?";
		int row = qr.update(sql, 10);
		System.out.println("��Ӱ��ĺ����ǣ�" + row);
	}

	@Test
	public void select() throws SQLException {
		QueryRunner qr = new QueryRunner(DSUtiles.getDataSource());
		//String sql = "select * from products";
		//1.�Ѳ�ѯ�����װ�������У����ü��Ͻ��б���
		/*List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		for (Product product : list) {

			System.out.println(product);
		}*/
		
		//2.�Ѳ�ѯ�����һ����װ��������
		/*String sql = "select * from products where pid  = 9";
		Product p = qr.query(sql, new BeanHandler<Product>(Product.class));
		System.out.println(p);*/
		//3.ScalarHandler�������ڵ������ݡ�����select count(*) from �������
		
		String sql = "select count(*) from products where category_id = 1";
		Object obj = qr.query(sql, new ScalarHandler());
		System.out.println(obj);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
