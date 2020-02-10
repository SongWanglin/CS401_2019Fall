/* ----------------------------------------------
 * "ABList.java" - Array-Based List, An unbounded array list.
 * Refer to Textbook "Object-Oriented Data Structures Using Java" - Ch.6.2 Array-Based implementation of List
 * ----------------------------------------------
 */

package ADTs;
import java.util.Iterator;
public class ArrayBasedList<T> {
	public final static int DEFCAP = 100;
	public int capacity;
	public T[] elements;
	public int numberOfElements;
	public boolean sorted;
	public boolean allFloat;
	// initialize the arraylist with specific capacity
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int cap) {
		this.elements = (T[]) new Object[cap];
		this.capacity = cap;
		this.numberOfElements = 0;
		this.sorted = false;
		this.allFloat = false;
	}
	// initialize the arraylist with default capacity
	public ArrayBasedList() {
		this(DEFCAP);
	}
	// enlarger the arraylist when needed
	@SuppressWarnings("unchecked")
	public void enlarge() {
		T[] larger = (T[]) new Object[elements.length*2];
		for(int i = 0; i<numberOfElements; ++i) {
			larger[i] = elements[i];
		}
		elements = larger;
	}
	// return the index of a specific element
	public int indexOf(T target) {
		int location = 0;
		while(location < numberOfElements) {
			if(elements[location].equals(target))
				return location;
			location += 1;
		}
		return -1;
	}
	// return the index of a floating point number element
	public int indexOfFloat(float target) {
		int location = 0;
		while(location < numberOfElements) {
			try {
				if(Float.compare((float)elements[location], target)==0)
					return location;
			}catch(Exception e){
				System.out.println("not a floating point number element");
			}
			location += 1;
		}
		return -1;
	}
	// return the element at a given index
	public T get(int index) {
		if(index<0||index>numberOfElements)
			return null;
		return elements[index];
	}
	// add new element to the arraylist
	public boolean add(T element) {
		if(numberOfElements==elements.length)
			enlarge();
		elements[numberOfElements] = element;
		numberOfElements += 1;
		this.sorted = false;
		return true;
	}
	// add a new element to the arraylist at a given index
	public void add(int index, T element) {
		if(index<0||index>=size())
			throw new IndexOutOfBoundsException("Invalid index!");
		if(numberOfElements==elements.length)
			enlarge();
		for(int i = numberOfElements; i>index; --i) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		numberOfElements += 1;
		this.sorted = false;
	}
	// check if the arraylist contains a certain element
	public boolean contains(T target) {
		return indexOf(target)!=-1;
	}
	// return the size of the arraylist
	public int size() {
		return numberOfElements;
	}
	// remove a specific element from the arraylist
	public boolean remove(T target) {
		int index = indexOf(target);
		if(index!=-1)
			return false;
		for(int i = index; i<numberOfElements-1; ++i) {
			elements[i] = elements[i+1];
		}
		elements[numberOfElements-1] = null;
		numberOfElements -= 1;
		return true;
	}
	// remove the element at a given index
	public T remove(int index) {
		if(index<0||index>=size())
			throw new IndexOutOfBoundsException("Invalid index!");
		T res = elements[index];
		for(int i = index; i<numberOfElements-1; ++i) {
			elements[i] = elements[i+1];
		}
		elements[numberOfElements-1] = null;
		numberOfElements -= 1;
		return res;
	}
	// set the element at a given index to a new one
	public T set(int index, T newObj) throws Exception {
		if(index<0||index>=size())
			throw new IndexOutOfBoundsException("Invalid index!");
		if(newObj==null)
			throw new Exception("The new Object can't be null!");
		T res = elements[index];
		elements[index] = newObj;
		this.sorted = false;
		return res;
	}
	// check if the arraylist is full or not
	public boolean isFull() {
		return false;
	}
	// check if the arraylist is empty or not
	public boolean isEmpty() {
		return numberOfElements==0;
	}
	// print all elements in the array
	public void printAll() {
		for(int i = 0; i<this.size(); ++i) {
			System.out.println(this.get(i));
		}
		System.out.println();
	}
	// return an iterator of the list
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			private int pos = -1;
			public boolean hasNext() {
				return pos < size()-1;
			}
			public T next() {
				if(!hasNext())
					throw new IndexOutOfBoundsException("no next element");
				pos -= 1;
				return elements[pos];
			}
		};
	}
}
