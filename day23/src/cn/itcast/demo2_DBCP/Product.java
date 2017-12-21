package cn.itcast.demo2_DBCP;

public class Product {
	private int pid;
	private String pname;
	private int price;
	private int flag;
	private int category_id;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, int price, int flag, int category_id) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.flag = flag;
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", flag=" + flag + ", category_id="
				+ category_id + "]";
	}
	

}
