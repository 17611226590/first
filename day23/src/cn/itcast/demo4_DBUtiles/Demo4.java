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
	// 创建DBUtiles的核心类QueryRunner
	@Test
	public void add() throws Exception {
		/*
		 * 这里的update底层肯定用的是prepareStatemen 所以传参数要预处理
		 */
		QueryRunner qr = new QueryRunner(DSUtiles.getDataSource());
		String sql = "insert into products values(null,?,?,?,?)";
		int row = qr.update(sql, "奔驰", 10, 1, 1);
		System.out.println("受影响的行数是：" + row);

	}

	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner(DSUtiles.getDataSource());
		String sql = "update products set pname = ? where pid =?";
		int row = qr.update(sql, "雪茄", 10);
		System.out.println("受影响的行数是：" + row);

	}

	@Test
	public void delete() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String sql = "delete from products where pid = ?";
		int row = qr.update(sql, 10);
		System.out.println("受影响的函数是：" + row);
	}

	@Test
	public void select() throws SQLException {
		QueryRunner qr = new QueryRunner(DSUtiles.getDataSource());
		//String sql = "select * from products";
		//1.把查询结果封装到对象中，并用集合进行保存
		/*List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		for (Product product : list) {

			System.out.println(product);
		}*/
		
		//2.把查询结果的一个封装到对象中
		/*String sql = "select * from products where pid  = 9";
		Product p = qr.query(sql, new BeanHandler<Product>(Product.class));
		System.out.println(p);*/
		//3.ScalarHandler它是用于单个数据。例如select count(*) from 表操作。
		
		String sql = "select count(*) from products where category_id = 1";
		Object obj = qr.query(sql, new ScalarHandler());
		System.out.println(obj);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
