package CS401;

public class MyList {
	public ListNode head = null;
	public int size;
	public MyList() {
		size = 0;
	}
	public boolean isEmpty() {
		return head==null;
	}
	// add, get and poll elements at the head
	public void addFirst(Object data) {
		ListNode newNode = new ListNode(data);
		size += 1;
		if(head==null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	public Object getFirst() {
		if(head==null)
			return null;
		Object res = head.val;
		return res;
	}
	public Object pollFirst() {
		if(head==null)
			return null;
		size -= 1;
		Object res = head.val;
		head = head.next;
		return res;
	}
	// add, get and poll elements at the tail
	public void addLast(Object data) {
		ListNode newNode = new ListNode(data);
		size += 1;
		if(head==null) {
			head = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.next!=null) temp = temp.next;
		temp.next = newNode;
	}
	public Object getLast() {
		if(head==null)
			return null;
		if(head.next==null) {
			Object res = head.val;
			return res;
		}
		ListNode temp = head;
		while(temp.next.next!=null) temp = temp.next;
		Object res = temp.next.val;
		return res;
	}
	public Object pollLast() {
		if(head==null)
			return null;
		size -= 1;
		if(head.next==null) {
			Object res = head.val;
			head = null;
			return res;
		}
		ListNode temp = head;
		while(temp.next.next!=null) temp = temp.next;
		Object res = temp.next.val;
		temp.next = null;
		return res;
	}
	// length of the list
	public int length() {
		return size;
	}
	public void print_all() {
		String res = "";
		ListNode temp = head;
		while(temp!=null) {
			res += (Character)temp.val;
			temp = temp.next;
		}
		System.out.println(res);
	}
}
