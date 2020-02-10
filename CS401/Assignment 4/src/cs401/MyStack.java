package cs401;

public class MyStack {
	public MyList stack;
	public MyStack() {
		stack = new MyList();
	}
	public MyStack(MyList dataset) {
		stack = dataset;
	}
	public void push(Object data) {
		stack.addFirst(data);
	}
	public Object pop() {
		return stack.pollFirst();
	}
	public Object peek() {
		return stack.getFirst();
	}
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
