package InputParser;

import ADTs.ArrayBasedList;

public class MainMenu {
	String msg = null;
	ConsolePrompter cp = null;
	public MainMenu() {
		this.msg = "IIT CS401 final project -- Main Menu:\n"
				+"\t1 Create a list from a input file and print the list\n"
				+"\t2 Search data from exist lists\n"
				+"\t3 Show a given list\n"
				+"\t4 Sort a given list\n"
				+"\t5 Modify data to an exist list from an input file, sort again and print the list\n"
				+"\t6 exit\n";
		this.cp = new ConsolePrompter();
	}
	/* a set of commonly used operations*/
	public int mainMenuOption() {
		System.out.println(this.msg);
		int option = cp.promptInt(1, 6);
		return option;
	}
	public String inputFileName() {
		String res = "Please place the file under project directory and enter its name.";
		String fileName = cp.promptString(res);
		return fileName;
	}
	public int chooseList(ArrayBasedList dataEntry) {
		System.out.println("Please enter the id of the list.");
		int res = cp.promptInt(0, dataEntry.size());
		return res;
	}
	public int chooseDataType() {
		System.out.println("Please choose the data type of the list:\n"
				+ "\t1 Integer\n"
				+ "\t2 String\n"
				+ "\t3 Float\n");
		int option = cp.promptInt(1, 3);
		return option;
	}
	public int chooseSortOption() {
		System.out.println("Please choose the sorting algorithm:\n"
				+ "\t1 BubbleSort\n"
				+ "\t2 MergeSort\n"
				+ "\t3 HeapSort\n"
				+ "\t4 QuickSort\n");
		int option = cp.promptInt(1, 4);
		return option;
	}
	public int chooseListOperation() {
		System.out.println("Please choose the sorting algorithm:\n"
				+ "\t1 Add data from existing file\n"
				+ "\t2 Modify data\n"
				+ "\t3 Remove data\n");
		int option = cp.promptInt(1, 3);
		return option;
	}
}
