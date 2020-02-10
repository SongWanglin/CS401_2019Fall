
public class DLLNode<E> {
	protected E info;
	protected DLLNode<E> link;
	protected DLLNode back;
	public DLLNode(E info) {
		this.info = info;
		link = null;
		back = null;
	}
	public void setInfo(E info) {this.info = info;}
	public E getInfo() {return info;}
	public void setLink(DLLNode<E> link) {this.link = link;}
	public DLLNode<E> getLink(){return link;}
	public void setBack(DLLNode back) {this.back = back;}
	public DLLNode getBack() {return back;}
}
