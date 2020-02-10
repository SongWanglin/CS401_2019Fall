package Searcher;

import ADTs.ArrayBasedList;

public class DataSearcher {
	public DataSearcher() {
		
	}
	// use the inbuild linear search method of the list to do the linear search
	public <T> int linearSearch(ArrayBasedList<T> list, T target) {
		if(list.allFloat==true) {
			return list.indexOfFloat((float)target);
		}
		return list.indexOf(target);
	}
	// compare the 2 elements in the array based list (whether floating point number or not)
	private int compareListElements(ArrayBasedList list, int i, Object target) {
		int compare = 0;
		if(list.allFloat) {
			compare = Float.compare((float)list.get(i), (float)target);
		}else {
			compare = ((Comparable)list.get(i)).compareTo(target);
		}
		return compare;
	}
	// binary search with O(1) get method of the array based list
	public <T> int binarySearch(ArrayBasedList<T> list, T target) {
		if(list.sorted==false) {
			System.out.println("please sort the list first before running the binary search!");
			return -1;
		}
		int start = 0, end = list.size()-1, numberOfComparison = 0;
		while(start<=end) {
			int mid = start + (end-start)/2;
			numberOfComparison += 1;
			int comparison = compareListElements(list, mid, target);
			if(comparison==0) {
				System.out.printf("It took %d times of comparison.", numberOfComparison);
				return mid;
			}
			if(comparison > 0) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.printf("It took %d times of comparison.", numberOfComparison);
		return -1;
	}
}
