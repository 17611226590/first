package cn.itcast.domain;

public class Model {
	private String outUser;
	private String inUser;
	private int money;
	
	private String a;
	private String b;
	private String c;
	
	
	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model(String outUser, String inUser, int money) {
		super();
		this.outUser = outUser;
		this.inUser = inUser;
		this.money = money;
	}
	public String getOutUser() {
		return outUser;
	}
	public void setOutUser(String outUser) {
		this.outUser = outUser;
	}
	public String getInUser() {
		return inUser;
	}
	public void setInUser(String inUser) {
		this.inUser = inUser;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Model [outUser=" + outUser + ", inUser=" + inUser + ", money=" + money + "]";
	}
	

}
