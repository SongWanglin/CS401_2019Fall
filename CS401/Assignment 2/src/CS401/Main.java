package CS401;
import java.io.*;
import java.util.*;
/* A20354898 Wanglin Song */
public class Main {
	public static void main(String[] args) {
		//System.out.print("Please Enter the number of students to create:");
		Scanner scan = new Scanner(System.in);
		System.out.print("Please Enter the number of students:");
		int n = 0;
		while(n<=0) {
			n = scan.nextInt();
		}
		ArrayList<Student> students = new ArrayList<>();
		for(int i = 0; i<n; ++i) {
			Student temp = createStudent();
			students.add(temp);
		}
		Collections.sort(students, new Student(-1, "Comparator"));
		System.out.println("The sorted list of students are:");
		for(int i = 0; i<n; ++i) {
			Student temp = students.get(i);
			System.out.println(temp.toString());
		}
		scan.close();
	}
	// method to parse integers from input stream
    public static int readInteger() {
        try {
        	InputStreamReader input = new InputStreamReader(System.in);
        	BufferedReader reader = new BufferedReader(input);
        	return Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static String readString() {
        try {
        	StringBuilder sb = new StringBuilder();
        	InputStreamReader input = new InputStreamReader(System.in);
        	BufferedReader reader = new BufferedReader(input);
        	sb.append(reader.readLine());
        	return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Student createStudent() {
		int ID = -1;
		while(ID<=0) {
			System.out.println("Enter ID of a student:");
			ID = readInteger();
		}
		String name = null;
		while(name==null) {
			System.out.println("Enter name of a student:");
			name = readString();
		}
		Student student = new Student(ID, name);
		return student;
    }
}


