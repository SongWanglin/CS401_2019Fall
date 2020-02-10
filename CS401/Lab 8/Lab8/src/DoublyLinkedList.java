
public class DoublyLinkedList<E> {
	protected DLLNode<E> dummyHead;
	public DoublyLinkedList() {
		dummyHead = new DLLNode<E>(null);
	}
	public boolean contains(E e) {
		DLLNode<E> temp = dummyHead.getLink();
		while(temp!=null) {
			if(temp.info.equals(e)) {
				return true;
			}
			temp = (DLLNode<E>) temp.getLink();
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public boolean add(E e) {
		DLLNode<E> temp = dummyHead;
		while(temp.getLink()!=null) {
			temp = temp.getLink();
		}
		DLLNode<E> newNode = new DLLNode(e);
		temp.setLink(newNode);
		newNode.setBack(temp);
		return true;	
	}
	@SuppressWarnings("unchecked")
	public boolean add(Where where, E e) {
		if(where == Where.FRONT) {
			DLLNode<E> newNode = new DLLNode<E>(e);
			DLLNode<E> next = dummyHead.getLink();
			newNode.setBack(dummyHead);
			newNode.setLink(next);
			dummyHead.setLink(newNode);
			if(next!=null)
				next.setBack(newNode);
		}else if(where == Where.REAR) {
			add(e);
		}
		return true;
	}
	public boolean add(Where where, int index, E e) {
		if(index<0)
			return false;
		DLLNode<E> temp = dummyHead.getLink();
		while(temp!=null) {
			if(index==0) {
				DLLNode<E> newNode = new DLLNode<E>(e);
				DLLNode<E> back = temp.getBack();
				newNode.setBack(back);
				newNode.setLink(temp);
				back.setLink(newNode);
				temp.setBack(newNode);
				return true;
			}
			temp = temp.getLink();
			index--;
		}
		return false;
	}
	public E remove(int i) {
		DLLNode<E> temp = (DLLNode<E>) dummyHead.getLink();
		while(temp!=null) {
			if(i==0) {
				DLLNode<E> back = temp.getBack();
				DLLNode<E> next = temp.getLink();
				back.setLink(next);
				if(next!=null)
					next.setBack(back);
				return temp.info;
			}
			temp = temp.getLink();
			i -= 1;
		}
		return null;
	}
	public void print_all() {
		DLLNode<E> temp = dummyHead.getLink();
		String res = "[Head <-> ";
		while(temp!=null) {
			res += temp.info+" <-> ";
			temp = temp.getLink();
		}
		res += "None]";
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList lst = new DoublyLinkedList();
		lst.add(1.1);
		lst.add(Where.FRONT, "hi");
		lst.add(Where.MIDDLE, 1, 1);
		System.out.println(lst.contains(1.1));
		System.out.println(lst.contains("hi"));
		System.out.println(lst.contains(1));
		lst.print_all();
		lst.remove(1);
		lst.print_all();
		System.out.println(lst.contains(1));
	}
}
