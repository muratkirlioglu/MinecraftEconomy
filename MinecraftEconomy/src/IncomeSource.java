
public class IncomeSource {

	private String name;
	private int money_to_add;
	private int income_source_id;
	private static int id_counter = 0;
	
	public IncomeSource(String name, int money_to_add) {
		super();
		this.name = name;
		this.money_to_add = money_to_add;
		this.income_source_id = id_counter;
		id_counter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney_to_add() {
		return money_to_add;
	}

	public void setMoney_to_add(int money_to_add) {
		this.money_to_add = money_to_add;
	}
	

	public int getId() {
		return income_source_id;
	}

	public void PrintIncomeSource() {
		System.out.print(getName() + " - " + getMoney_to_add());
	}
	
}
