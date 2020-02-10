package CS401;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	// read file data into a SortedList object
	public static SortedLinkedList readFileToList2() throws NumberFormatException, Exception{
		File file = new File("emp.txt");
		SortedLinkedList res = new SortedLinkedList(29);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String[] s= scanner.nextLine().split(" ");
			Employee temp = new Employee(s[0], Integer.parseInt(s[1]));
			res.add(temp);
		}
		scanner.close();
		return res;
	}
	public static CS401ArrayImpl<Employee> readFileToList3() throws FileNotFoundException{
		File file = new File("emp.txt");
		CS401ArrayImpl<Employee> res = new  CS401ArrayImpl<Employee>();
		Scanner scanner = new Scanner(file);
		//while(scanner.hasNext()) {
		for(int i = 0; i<5; ++i) {
			String[] s= scanner.nextLine().split(" ");
			Employee temp = new Employee(s[0], Integer.parseInt(s[1]));
			res.add(Where.BACK, temp);
		}
		for(int i = 0; i<1; ++i) {
			String[] s= scanner.nextLine().split(" ");
			Employee temp = new Employee(s[0], Integer.parseInt(s[1]));
			res.add(Where.BACK, temp);
		}

		scanner.close();
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, Exception {
		System.out.println("\nPart I: SortedLinkedList:\n");
		SortedLinkedList dataset = null;
		try {
			dataset = readFileToList2();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Check if the list is full: "+dataset.isFull());
		ListNode temp = dataset.head;

		System.out.println("Remove the first and the third elements");
		System.out.println(dataset.remove(2));
		System.out.println(dataset.findIDAndRemove(244679508));
		System.out.println("Check if the list is full again: "+dataset.isFull());
		System.out.println("Print the sorted list:");
		while(temp!=null) {
			System.out.println(temp.val.toString());
			temp = temp.next;
		}
		
		System.out.println("\nPart II: ArrayList Insertion:\n");
		CS401ArrayImpl<Employee> list = null;
		try {
			list = readFileToList3();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i<list.size(); ++i) {
			System.out.println(list.get(i).toString());
		}
	}

}
