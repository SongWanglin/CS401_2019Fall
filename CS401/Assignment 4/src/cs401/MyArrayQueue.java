package cs401;

public class MyArrayQueue {
	Object[] queue;
	int currentSize;				// current number of objects in the queue
	public MyArrayQueue(int size) {
		queue = new Object[size];
		currentSize = 0;			
	}
	public boolean isEmpty() {
		return currentSize==0;
	}
	public boolean isFull() {
		return currentSize==queue.length;
	}
	public boolean enqueue(Object data) {
		if(isFull())
			return false;
		queue[currentSize] = data;
		currentSize++;
		return true;
	}
	public Object dequeue() {
		if(isEmpty())
			return null;
		Object res = queue[0];
		for(int i = 1; i<queue.length; ++i)
			queue[i-1] = queue[i];
		currentSize--;
		return res;
	}
}
