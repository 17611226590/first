package cn.itcast.demo4_DBUtiles;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

public class Demo04 {
	@Test
	public void add() throws SQLException {
		// 1.创建一个DBUtils工具包的核心类的对象：QueryRunner
		// 1.创建一个DBUtils工具包的核心类的对象：QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 2.直接执行sql语句
		String sql = "insert into products values(null,?,?,?,?)";
		int row = qr.update(sql, "三轮车", 200, 1, 1);
		System.out.println("受影响的行数是：" + row);

	}

	@Test
	public void updata() throws SQLException {
		// 1.创建一个DBUtils工具包的核心类的对象：QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 2.直接执行sql语句
		String sql = "update products set price = ? where pid = ?";
		int row = qr.update(sql, 6666, 12);
		System.out.println("受影响的行数是：" + row);
	}

	@Test
	public void delete() throws SQLException {
		// 1.创建一个DBUtils工具包的核心类对象：QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 直接执行sql语句
		String sql = "delete from products where pid = ?";
		int row = qr.update(sql, 12);
		System.out.println("受影响的行数是：" + row);
	}

	@Test
	public void select() throws Exception {
		// 创建一个DBUtils的核心工具类QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 直接执行sql语句
		// 1).ArrayHandler:用于查询一条记录，将一条记录封装到一个Object[]数组中
		//
		// String sql = "select * from products where pid = ?";
		// Object[] obj = qr.query(sql, new ArrayHandler(), 6);
		// System.out.println(Arrays.toString(obj));

		// 2.ArrayListHandler将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。
		/*
		 * String sql = "select * from products "; List<Object[]> list =
		 * qr.query(sql, new ArrayListHandler()); for (Object[] obj : list) {
		 * System.out.println(Arrays.toString(obj)); }
		 */
		// 3.BeanHandler 将结果集中第一条记录封装到一个指定的javaBean中。
		/*
		 * String sql = "select * from products where pid = 6"; Product pro =
		 * qr.query(sql, new BeanHandler<Product>(Product.class));
		 * System.out.println(pro);
		 */
		// 4.BeanListHandler 将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中
		/*
		 * String sql = "select * from products "; List<Product> list =
		 * qr.query(sql, new BeanListHandler<Product>(Product.class)); for
		 * (Product p : list) { System.out.println(p); }
		 */
		// 5.ColumnListHandler 将结果集中指定的列的字段值，封装到一个List集合中

		// String sql = "select pname from products";
		// List<Object> list = qr.query(sql, new ColumnListHandler());
		// for (Object object : list) {
		// System.out.println(object);
		// }

		// MapHandler 将结果集中第一条记录封装到了Map<String,Object>集合中，key就是字段名称，value就是字段值

		// String sql = "select * from products where pid = 6 ";
		// Map<String, Object> map = qr.query(sql, new MapHandler());
		// Set<String> set = map.keySet();
		// for (String s : set) {
		//
		// System.out.println(s + " \t" + map.get(s));
		// }

		// 7MapListHandler将结果集中每一条记录封装到了Map<String,Object>集合中，
		// key就是字段名称，value就是字段值，在将这些Map封装到List集合中。

		String sql = "select * from products";
		List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				System.out.println(key + "                " + map.get(key));
			}
			System.out.println("***************************");
		}

		// 8).ScalarHandler:查询一个数据
		// String sql = "select count(*) from products ";
		// Object obj = qr.query(sql, new ScalarHandler());
		// System.out.println(obj);

	}

}
