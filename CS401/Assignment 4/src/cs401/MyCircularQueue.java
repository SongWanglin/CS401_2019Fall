package cs401;

public class MyCircularQueue {
	Object[] queue;
	int currentSize, front, rear;
	public MyCircularQueue(int size) {
		queue = new Object[size];
		currentSize = 0;
		front = -1;
		rear = -1;
	}
	// enqueue and dequeue
    public boolean enQueue(Object value) {
        if(isFull())
            return false;
        rear = (rear+1)%(queue.length);
        queue[rear] = value;
        currentSize += 1;
        if(front==-1)
            front = rear;
        return true;
    }

    public Object deQueue() {
        if(isEmpty())
            return null;
        Object res = queue[front];
        front = (front+1)%(queue.length);
        currentSize -= 1;
        return res;
    }
    //get first  and last elements from the queue
    public Object Front() {
        return (isEmpty())? -1: queue[front];
    }

    public Object Rear() {
        return (isEmpty())? -1: queue[rear];
    }
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return currentSize==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return currentSize==queue.length;
    }
}
