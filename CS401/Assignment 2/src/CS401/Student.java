package CS401;

import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student>{
	private int id;
	private String name;
	public Student(int ID, String Name) {
		this.id = ID;
		this.name = Name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	public String toString() {
		return "The student name is: "+name+", id is: "+id;
	}
	@Override
	public int compareTo(Student other) {
		int n = name.compareToIgnoreCase(other.getName());
		if(n!=0) return n;
		return Integer.compare(id, other.getId());
	}
	public  int compare(Student s1,  Student s2) {
		return s1.compareTo(s2);
	}
}
