package cs401;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	// read file data into a MyList object
	public static MyList readFileToList() throws FileNotFoundException{
		File file = new File("emp.txt");
		MyList res = new MyList();
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String[] s= scanner.nextLine().split(" ");
			res.addLast(new Employee(s[0], Integer.parseInt(s[1])));
		}
		scanner.close();
		return res;
	}
	// read file data and push it onto the stack
	public static MyStack readFileToStack() throws FileNotFoundException{
		File file = new File("emp.txt");
		MyStack res = new MyStack();
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String[] s= scanner.nextLine().split(" ");
			res.push(new Employee(s[0], Integer.parseInt(s[1])));
		}
		scanner.close();
		return res;
	}
	// read file data and enqueue it into the queue
	public static MyQueue readFileToQueue() throws FileNotFoundException{
		File file = new File("emp.txt");
		MyQueue res = new MyQueue();
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String[] s= scanner.nextLine().split(" ");
			res.enqueue(new Employee(s[0], Integer.parseInt(s[1])));
		}
		scanner.close();
		return res;
	}
	public static void main(String[] args) {
		MyList dataset = new MyList();
		try {
			dataset = readFileToList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int len = dataset.length();
		System.out.println("\nPart I: stack pop\n");
		MyStack stack = new MyStack();
		try {
			stack = readFileToStack();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(stack.peek().toString());
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().toString());
		}
		
		System.out.println("\nPart II: queue deque\n");
		MyQueue queue = new MyQueue();
		try {
			queue = readFileToQueue();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue().toString());
		}
		
		System.out.println("\nPart III-1: fixed front array queue deque\n");
		MyArrayQueue queue2 = new MyArrayQueue(len+1);
		ListNode temp = dataset.head;
		while(temp!=null) {
			queue2.enqueue(temp.val);
			temp = temp.next;
		}
		while(!queue2.isEmpty()) {
			System.out.println( queue2.dequeue().toString() );
		}
		
		System.out.println("\nPart III-2: floating front array queue deque\n");
		MyCircularQueue queue3 = new MyCircularQueue(len);
		temp = dataset.head;
		while(temp!=null) {
			queue3.enQueue(temp.val);
			temp = temp.next;
		}
		while(!queue3.isEmpty()) System.out.println( queue3.deQueue().toString() );
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nPart IV: Jacobsthal number");
		System.out.println("Please enter n:");
		long n = -1;
		while(n < 0) {
			n = scanner.nextInt();
		}
		Jacobsthal tester = new Jacobsthal();
		long start = System.currentTimeMillis();
		String res = "Recursive version: 0, 1";
		for(int i = 2; i<n; ++i)
			res += ", "+tester.Jacobsthal_recursive(i);
		long end = System.currentTimeMillis()-start;
		System.out.println(res);
		System.out.println("Time taken to execute iterative version: "+end+" ms");
		
		start = System.currentTimeMillis();
		System.out.println(tester.Jacobsthal_iterative(n-1));
		end = System.currentTimeMillis()-start;
		System.out.println("Time taken to execute iterative version: "+end+" ms");
		scanner.close();
	}
}
