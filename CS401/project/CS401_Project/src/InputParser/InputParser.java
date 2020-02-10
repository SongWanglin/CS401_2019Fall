/* ----------------------------------------------
 * an file parser for parsing data from files into a list
 * 
 * ----------------------------------------------
 */
package InputParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ADTs.ArrayBasedList;

public class InputParser {
	public String filePath = null;
	public ArrayBasedList<Object> lst;
	public InputParser(String path) {
		this.filePath = path;
		this.lst = new ArrayBasedList<Object>();
	}
	public void setFildPath(String path) {
		this.filePath = path;
	}
	// parse integers from input file and return a list 
	public ArrayBasedList<Object> getIntegerList(){
		this.parseIntegers();
		return this.lst;
	}
	public void parseIntegers() {
		System.out.println("Read integers from input file: "+this.filePath);
		File file = new File(this.filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing Integers ...");
		ArrayBasedList<Object> tempList = new ArrayBasedList<>();
		Object temp = null;
		while(sc.hasNext()) {
			try {
				String[] line = sc.nextLine().split(" ");
				temp = Integer.parseInt(line[0]);
			}catch(Exception e) {
				System.out.println("Can't obtain info from file.");
			}
			tempList.add(temp);
		}
		this.lst = tempList;
		System.out.printf("Parse. %d lines of data from the file.", this.lst.size());
	}
	// extend the integer list
	public void addMoreIntegers(ArrayBasedList list) {
		if(list.allFloat==true) {
			System.out.println("The list is not for integers, try another.");
			return;
		}
		System.out.println("Read integers from input file: "+this.filePath);
		File file = new File(this.filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing Integers ...");
		Object temp = null;
		while(sc.hasNext()) {
			try {
				String[] line = sc.nextLine().split(" ");
				temp = Integer.parseInt(line[0]);
			}catch(Exception e) {
				System.out.println("Can't obtain info from file.");
			}
			list.add(temp);
		}
		list.sorted = false;
		System.out.printf("Parse. %d lines of data from the file.", this.lst.size());
	}
	// parse strings from input file and return a list 
	public ArrayBasedList<Object> getStringList(){
		this.parseStrings();
		return this.lst;
	}
	public void parseStrings() {
		System.out.println("Read strings from input file: "+this.filePath);
		File file = new File(this.filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing Strings ...");
		ArrayBasedList<Object> tempList = new ArrayBasedList<>();
		Object temp = null;
		while(sc.hasNext()) {
			try {
				String[] line = sc.nextLine().split(" ");
				temp = line[0];
			}catch(Exception e) {
				System.out.println("Can't obtain info from file.");
			}
			tempList.add(temp);
		}
		this.lst = tempList;
		System.out.printf("Parse. %d lines of data from the file.", this.lst.size());
	}
	// extend string list
	public void addMoreStrings(ArrayBasedList list) {
		if(list.allFloat==true) {
			System.out.println("The list is not for strings, try another.");
			return;
		}
		System.out.println("Read strings from input file: "+this.filePath);
		File file = new File(this.filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing Strings ...");
		Object temp = null;
		while(sc.hasNext()) {
			try {
				String[] line = sc.nextLine().split(" ");
				temp = line[0];
			}catch(Exception e) {
				System.out.println("Can't obtain info from file.");
			}
			list.add(temp);
		}
		list.sorted = false;
		System.out.printf("Parse. %d lines of data from the file.", this.lst.size());
	}
	// parse floats from input file and return a list 
	public ArrayBasedList<Object> getFloatList(){
		this.parseFloats();
		return this.lst;
	}
	public void parseFloats() {
		System.out.println("Read floats from input file: "+this.filePath);
		File file = new File(this.filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing Floats ...");
		ArrayBasedList<Object> tempList = new ArrayBasedList<>();
		tempList.allFloat = true;
		Object temp = null;
		while(sc.hasNext()) {
			try {
				String[] line = sc.nextLine().split(" ");
				temp = Float.parseFloat(line[0]);
			}catch(Exception e) {
				System.out.println("Can't obtain info from file.");
			}
			tempList.add(temp);
		}
		this.lst = tempList;
		System.out.printf("Parse. %d lines of data from the file.", this.lst.size());
	}
	// add more floating point number to a given list
	public void addMoreFloats(ArrayBasedList list) {
		if(list.allFloat==false) {
			System.out.println("The list is not for floating point numbers, try again.");
			return;
		}
		System.out.println("Read floats from input file: "+this.filePath);
		File file = new File(this.filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Parsing Floats ...");
		Object temp = null;
		while(sc.hasNext()) {
			try {
				String[] line = sc.nextLine().split(" ");
				temp = Float.parseFloat(line[0]);
			}catch(Exception e) {
				System.out.println("Can't obtain info from file.");
			}
			list.add(temp);
		}
		list.sorted = false;
		System.out.printf("Parse. %d lines of data from the file.", this.lst.size());
	}
}
