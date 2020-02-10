import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import ADTs.*;
import InputParser.ConsolePrompter;
import InputParser.InputParser;
import InputParser.MainMenu;
import Searcher.DataEntryMap;
import Searcher.DataSearcher;

public class main {
	// map of data entries
	public static DataEntryMap data = new DataEntryMap();
	// object for searching data from data map
	public static final DataSearcher searcher = new DataSearcher();
	// some commonly used operations
	public static final MainMenu ops = new MainMenu();
	// object for parsing input data
	public static final InputParser parser = new InputParser(null);
	// object for sorting lists in the data map
	public static final ListSorter sorter = new ListSorter();
	// object to prompt user input
	public static final ConsolePrompter promp = new ConsolePrompter();
	
	/* read data from a file into a list*/
	public static ArrayBasedList createListFromFile() {
		String filePath = ops.inputFileName();
		parser.setFildPath(filePath);
		int listType = ops.chooseDataType();
		ArrayBasedList list = null;
		if(listType==1) {
			list = parser.getIntegerList();
		}else if(listType==2) {
			list = parser.getStringList();
		}else {
			list = parser.getFloatList();
		}
		System.out.println("The data list from input file is printed as below:\n");
		return list;
	}
	/* search data from a given entry of the data map */
	public static int searchFromDataList(int index) {
		ArrayBasedList list = (ArrayBasedList)data.dataEntry.get(index);
		System.out.println("choose 1 for searching integers, 2 for searching floats, 3 for searching strings");
		int targetType = promp.promptInt(1, 3);
		Object target = null;
		if(targetType==1) {
			target = promp.promptInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}else if(targetType==2) {
			target = promp.promptFloat("");
		}else {
			target = promp.promptString("");
		}
		System.out.println("choose 1 for linear search, 2 for binary search");
		int searchType = promp.promptInt(1, 2), res = -1;
		if(searchType==1) {
			res = searcher.linearSearch(list, target);
		}else {
			res = searcher.binarySearch(list, target);
		}
		return res;
	}
	/* sort a given entry of the data map */
	public static void sortGivenList(ArrayBasedList list) {
		int option = ops.chooseSortOption();
		if(option==1) {
			sorter.bubbleSort(list);
		}else if(option==2) {
			sorter.mergeSort(list);
		}else if(option==3) {
			sorter.heapSort(list);
		}else {
			sorter.quickSort(list);
		}
	}
	/* extend a given entry of the data map */
	public static void extendGivenList(ArrayBasedList list) {
		int option = ops.chooseDataType();
		String fileName = promp.promptString("please enter the new file name");
		parser.setFildPath(fileName);
		if(option==1) {
			parser.addMoreIntegers(list);
		}else if(option==2) {
			parser.addMoreStrings(list);
		}else if(option==3) {
			parser.addMoreFloats(list);
		}else {
			return;
		}
	}
	/* create a new element from keyboard input*/
	public static Object getObject() {
		int option = ops.chooseDataType();
		Object res = null;
		if(option==1) {
			res = promp.promptInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}else if(option==2){
			res = promp.promptString("");
		}else {
			res = promp.promptFloat("");
		}
		return res;
	}
	/*get the data entry from data hash-table at a given index*/
	public static ArrayBasedList getEntry() {
		if(data.dataEntry.size()==0) {
			System.out.println("No data list in the system. Please add a new one to begin!\n");
			return null;
		}
		System.out.println("please enter the id of the list you want to print");
		int id = promp.promptInt(0, data.dataEntry.size()-1);
		ArrayBasedList list = (ArrayBasedList) data.dataEntry.get(id);
		return list;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		while(true) {
			int option = ops.mainMenuOption(), id = -1;
			ArrayBasedList list = null;
			switch(option) {
				// create unsorted list
				case 1:
					list = createListFromFile();
					list.printAll();
					data.addDataList(list);
					break;
				// search data from lists
				case 2:
					if(data.dataEntry.size()==0) {
						System.out.println("No data list in the system. Please add a new one to begin!\n");
						break;
					}
					System.out.println("please enter the id of the list you want to search");
					id = promp.promptInt(0, data.dataEntry.size());
					int res = searchFromDataList(id);
					if(res == -1) {
						System.out.println("target not found");
						break;
					}
					System.out.printf("\nThe target element is at index %d of the list\n\n", res);
					break;
				// print an existing list
				case 3:
					list = getEntry();
					if(list==null)
						break;
					list.printAll();
					break;
				// sort an existing list
				case 4:
					list = getEntry();
					if(list==null)
						break;
					sortGivenList(list);
					list.printAll();
					break;
				// modify an existing list
				case 5:
					list = getEntry();
					if(list==null)
						break;
					// choose whether add more elements, remove an element or replace an existing one
					int op = ops.chooseListOperation();
					if(op==1) {
						extendGivenList(list);
					}else if(op==3){
						System.out.println("Please enter the index of element to remove.\n");
						id = promp.promptInt(0, list.size()-1);
						list.remove(id);
					}else {
						System.out.println("Please enter the index of element to replace.\n");
						id = promp.promptInt(0, list.size()-1);
						Object newObj = getObject();
						try {
							list.set(id, newObj);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					sortGivenList(list);
					break;
				// exit the main program
				case 6:
					System.out.println("Bye!");
					return;
			}
		}
	}
}
