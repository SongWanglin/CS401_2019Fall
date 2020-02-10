package CS401;

public class SortedLinkedList extends MyList{
	public SortedLinkedList(int capacity) {
		super(capacity);
	}
	@Override
	public void add(Employee data) throws Exception {
		if(isFull()) {
			throw new Exception("List is full");
		}
		ListNode newNode = new ListNode(data);
		size += 1;
		if(head==null || head.val.getId()>=data.getId()) {
			newNode.next = head;
			head = newNode;
			return;
		}
		ListNode temp = head;
		while( temp.next!=null && temp.next.val.getId() < newNode.val.getId() ) { 
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return;
	}
	public Employee remove(int index) {
		if (index < 0 && index >= size)
			return null;
		if(index==0) {
			Employee res = (Employee) pollFirst();
			return res;
		}
		size--;
		ListNode temp = head;
		for(int i = 0; i<index-1; ++i) {
			temp = temp.next;
		}
		Employee res = (Employee) temp.next.val;
		temp.next = temp.next.next;
		return res;
	}
	public Employee findIDAndRemove(int id) {
		if(size==0) return null;
		if(head.val.getId()==id) {
			Employee res = (Employee) pollFirst();
			return res;
		}
		ListNode temp = head;
		while(temp.next!=null && temp.next.val.getId()!=id) {
			temp = temp.next;
		}
		Employee res = (Employee) temp.next.val;
		temp.next = temp.next.next;
		return res;
	}
}
