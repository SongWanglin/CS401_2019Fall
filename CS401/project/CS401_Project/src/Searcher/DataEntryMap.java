
package Searcher;

import ADTs.ArrayBasedList;

public class DataEntryMap {
	public ArrayBasedList dataEntry;
	public DataEntryMap() {
		this.dataEntry = new ArrayBasedList();
	}
	// add data list and return the corresponding key
	public int addDataList(ArrayBasedList newEntry) {
		dataEntry.add(newEntry);
		int res = dataEntry.size();
		if(dataEntry.size() >= 0.75*dataEntry.capacity)
			rehashing();
		return res;
	}
	// rehashing when it reaches a critical load
	public void rehashing() {
		int size = dataEntry.capacity;
		ArrayBasedList newList = new ArrayBasedList(2*size);
		for(int i = 0; i<dataEntry.size(); ++i) {
			newList.add(dataEntry.get(i));
		}
		this.dataEntry = newList;
	}
}
