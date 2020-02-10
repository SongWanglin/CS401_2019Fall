package cs401;

public class Employee {
	private String name;
	private int id;
	public Employee(String n, int num) {
		this.setName(n);
		this.setId(num);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "The employee name is:\t"+name+"\t\tid is:\t"+id;
	}
}
