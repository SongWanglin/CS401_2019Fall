package CS401;

public class Employee implements Comparable<Employee>{
	private String name;
	private long id;
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
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "The employee id is:\t"+id+"\tname is:\t"+name;
	}
	@Override
	public int compareTo(Employee other) {
		return (int)(id-other.getId());
	}
}
