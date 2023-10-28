package gui_Assignment;

public class user {

	String name;
	int money;

	public user(String name) {
		this.name = name;
		this.money = 0;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
