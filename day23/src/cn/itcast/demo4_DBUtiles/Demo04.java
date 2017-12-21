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
		// 1.����һ��DBUtils���߰��ĺ�����Ķ���QueryRunner
		// 1.����һ��DBUtils���߰��ĺ�����Ķ���QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 2.ֱ��ִ��sql���
		String sql = "insert into products values(null,?,?,?,?)";
		int row = qr.update(sql, "���ֳ�", 200, 1, 1);
		System.out.println("��Ӱ��������ǣ�" + row);

	}

	@Test
	public void updata() throws SQLException {
		// 1.����һ��DBUtils���߰��ĺ�����Ķ���QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// 2.ֱ��ִ��sql���
		String sql = "update products set price = ? where pid = ?";
		int row = qr.update(sql, 6666, 12);
		System.out.println("��Ӱ��������ǣ�" + row);
	}

	@Test
	public void delete() throws SQLException {
		// 1.����һ��DBUtils���߰��ĺ��������QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// ֱ��ִ��sql���
		String sql = "delete from products where pid = ?";
		int row = qr.update(sql, 12);
		System.out.println("��Ӱ��������ǣ�" + row);
	}

	@Test
	public void select() throws Exception {
		// ����һ��DBUtils�ĺ��Ĺ�����QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		// ֱ��ִ��sql���
		// 1).ArrayHandler:���ڲ�ѯһ����¼����һ����¼��װ��һ��Object[]������
		//
		// String sql = "select * from products where pid = ?";
		// Object[] obj = qr.query(sql, new ArrayHandler(), 6);
		// System.out.println(Arrays.toString(obj));

		// 2.ArrayListHandler��������е�ÿһ����¼����װ��һ��Object[]�����У�����Щ�����ڷ�װ��List�����С�
		/*
		 * String sql = "select * from products "; List<Object[]> list =
		 * qr.query(sql, new ArrayListHandler()); for (Object[] obj : list) {
		 * System.out.println(Arrays.toString(obj)); }
		 */
		// 3.BeanHandler ��������е�һ����¼��װ��һ��ָ����javaBean�С�
		/*
		 * String sql = "select * from products where pid = 6"; Product pro =
		 * qr.query(sql, new BeanHandler<Product>(Product.class));
		 * System.out.println(pro);
		 */
		// 4.BeanListHandler ���������ÿһ����¼��װ��ָ����javaBean�У�����ЩjavaBean�ڷ�װ��List������
		/*
		 * String sql = "select * from products "; List<Product> list =
		 * qr.query(sql, new BeanListHandler<Product>(Product.class)); for
		 * (Product p : list) { System.out.println(p); }
		 */
		// 5.ColumnListHandler ���������ָ�����е��ֶ�ֵ����װ��һ��List������

		// String sql = "select pname from products";
		// List<Object> list = qr.query(sql, new ColumnListHandler());
		// for (Object object : list) {
		// System.out.println(object);
		// }

		// MapHandler ��������е�һ����¼��װ����Map<String,Object>�����У�key�����ֶ����ƣ�value�����ֶ�ֵ

		// String sql = "select * from products where pid = 6 ";
		// Map<String, Object> map = qr.query(sql, new MapHandler());
		// Set<String> set = map.keySet();
		// for (String s : set) {
		//
		// System.out.println(s + " \t" + map.get(s));
		// }

		// 7MapListHandler���������ÿһ����¼��װ����Map<String,Object>�����У�
		// key�����ֶ����ƣ�value�����ֶ�ֵ���ڽ���ЩMap��װ��List�����С�

		String sql = "select * from products";
		List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
		for (Map<String, Object> map : list) {
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				System.out.println(key + "                " + map.get(key));
			}
			System.out.println("***************************");
		}

		// 8).ScalarHandler:��ѯһ������
		// String sql = "select count(*) from products ";
		// Object obj = qr.query(sql, new ScalarHandler());
		// System.out.println(obj);

	}

}
