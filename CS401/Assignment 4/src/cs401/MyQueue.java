package cs401;

public class MyQueue {
	public MyList queue;
	public MyQueue() {
		queue = new MyList();
	}
	public MyQueue(MyList dataset) {
		queue = dataset;
	}
	public void enqueue(Object data) {
		queue.addFirst(data);
	}
	public Object dequeue() {
		return queue.pollLast();
	}
	public Object peekFirst() {
		return queue.getFirst();
	}
	public Object peekLast() {
		return queue.getLast();
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
