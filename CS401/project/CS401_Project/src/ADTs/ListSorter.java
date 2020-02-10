package ADTs;

public class ListSorter {
	public ListSorter() {
		
	}
	/* bubble sort */
	// bubble sort with O(n^2) complexity, print execution time and the number of comparisons at the end
	@SuppressWarnings("unchecked")
	public void bubbleSort(ArrayBasedList list) {
		long startTime = System.nanoTime();
		int numberOfComparison = 0, length = list.size();
		for(int i = 0; i<length-1; ++i) {
			for(int j = 0; j<length-i-1; ++j) {
				int comp = compareListElements(list, j, j+1);
				numberOfComparison += 1;
				if(comp>0) {
					swap(list.elements, j, j+1);
				}
			}
		}
		list.sorted = true;
		long elapsedTime = System.nanoTime() - startTime;
		System.out.printf("\nIt takes %d nano seconds,  %d times of comparison to sort the list with bubble sort.\n", elapsedTime, numberOfComparison);
	}
	@SuppressWarnings("rawtypes")
	// compare the 2 elements in the array based list (whether floating point number or not)
	private int compareListElements(ArrayBasedList list, int i, int j) {
		int compare = 0;
		if(list.allFloat) {
			compare = Float.compare((float)list.get(i), (float)list.get(j));
		}else {
			compare = ((Comparable)list.get(i)).compareTo(list.get(j));
		}
		return compare;
	}
	private void swap(Object[] xs, int i, int j) {
		Object temp = xs[i];
		xs[i] = xs[j];
		xs[j] = temp;
	}
	/* merge sort with O(NlogN) time complexity */
	@SuppressWarnings("rawtypes")
	// main method of merge sort
	public void mergeSort(ArrayBasedList list) {
		long startTime = System.nanoTime();
		int numberOfComparison = sort(list, 0, list.size()-1);
		long elapsedTime = System.nanoTime() - startTime;
		list.sorted = true;
		System.out.printf("\nIt takes %d nano seconds,  %d times of comparison to sort the list with merge sort.\n", elapsedTime, numberOfComparison);
	}
	// merge sort with O(Nlog(N)) complexity, print execution time and the number of comparisons at the end
	public int sort(ArrayBasedList list, int left, int right) {
		if(left>=right)
			return 0;
		int mid = (left+right)/2, numberOfComparison = 0;
		numberOfComparison += sort(list, left, mid);
		numberOfComparison += sort(list, mid+1, right);
		numberOfComparison += merge(list, left, mid, right);
		return numberOfComparison;
	}
	@SuppressWarnings("rawtypes")
	private int merge(ArrayBasedList list, int left, int mid, int right) {
		int n1 = mid-left+1, n2 =right-mid, numberOfComparison = 0;
		ArrayBasedList L = new ArrayBasedList(), R = new ArrayBasedList();
		if(list.allFloat) {
			L.allFloat = true; R.allFloat = true;
		}
		for(int i = 0; i<n1; ++i)
			L.add(list.get(left+i));
		for(int j = 0; j<n2; ++j)
			R.add(list.get(mid+1+j));
		int i1 = 0, i2 = 0;
		while(i1<n1 && i2<n2) {
			int comp = compareWithTarget(L, i1, R.get(i2));
			numberOfComparison += 1;
			if(comp < 0) {
				list.elements[left] = L.get(i1);
				++i1;
			}else {
				list.elements[left] = R.get(i2);
				++i2;
			}
			++left;
		}
		while(i1<n1) {
			list.elements[left] = L.get(i1);
			i1+=1; left+=1;
		}
		while(i2<n2) {
			list.elements[left] = R.get(i2);
			i2+=1; left+=1;
		}
		return numberOfComparison;
	}
	@SuppressWarnings("rawtypes")
	// compare list element with a certain target
	private int compareWithTarget(ArrayBasedList list, int i, Object target) {
		int compare = 0;
		if(list.allFloat) {
			compare = Float.compare((float)list.get(i), (float)target);
		}else {
			compare = ((Comparable)list.get(i)).compareTo(target);
		}
		return compare;
	}
	/* heap sort with O(NlogN) time complexity */
	// main method of heap sort
	public void heapSort(ArrayBasedList list) {
		int length = list.size(), numberOfComparison = 0;
		long startTime = System.nanoTime();
		// heapify the list
		for(int i = length/2-1; i>=0; --i)
			numberOfComparison += heapify(list, length, i);
		// Extract minimum element from the heap one by one
		for(int i = length-1; i>=0; --i) {
			swap(list.elements, 0, i);
			// call max heapify on the 
			numberOfComparison += heapify(list, i, 0);
		}
		long elapsedTime = System.nanoTime() - startTime;
		list.sorted = true;
		System.out.printf("\nIt takes %d nano seconds,  %d times of comparison to sort the list with heap sort.\n", elapsedTime, numberOfComparison);
	}
	// make the given part (from rootIndex to rootIndex+length) of the list a maximum heap
	private int heapify(ArrayBasedList list, int length, int rootIndex) {
		int largest = rootIndex, left = 2*rootIndex+1, 
			right = 2*rootIndex+2, numberOfComparison = 0;
		// check if left child is larger than root
		if(left<length && compareListElements(list, left, largest)>0) {
			numberOfComparison += 1;
			largest = left;
		}
		// check if right child is larger than root
		if(right<length && compareListElements(list, right, largest)>0) {
			numberOfComparison += 1;
			largest = right;
		}
		// if largest is not root
		if(largest!=rootIndex) {
			swap(list.elements, rootIndex, largest);
			numberOfComparison += heapify(list, length, largest);
		}
		return numberOfComparison;
	}
	/* quick sort with O(NlogN) time complexity on average, O(N^2) time complexity at worst */
	public void quickSort(ArrayBasedList list) {
		if(list==null || list.size()==0)
			return;
		long startTime = System.nanoTime();
		int numberOfComparison = qsort(list, 0, list.size()-1);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.printf("\nIt takes %d times of comparison, %d nano seconds to sort the list with quick sort.\n", numberOfComparison, elapsedTime);
	}
	// partition the list with the first element
	public int qsort(ArrayBasedList list, int start, int end) {
		int left = start, right = end, numberOfComparison = 0;
		// get the pivot element from the left of the list
		Object pivot = list.get(left);
		while(left <= right) {
			while(compareWithTarget(list, left, pivot) < 0) {
				left += 1; numberOfComparison += 1;
			}
			while(compareWithTarget(list, right, pivot) > 0) {
				right -= 1; numberOfComparison += 1;
			}
			if(left <= right) {
				swap(list.elements, left, right);
				left +=1 ; right-=1 ;
			}
		}
		int idx = left;
		// recursively call quick sort on the left part of the partitioned array
		if(start < idx-1) {
			numberOfComparison += qsort(list, start, idx-1);
		}
		// recursively call quick sort on the right part of the partitioned array
		if(idx<end) {
			numberOfComparison += qsort(list, idx, end);
		}
		return numberOfComparison;
	}
}
