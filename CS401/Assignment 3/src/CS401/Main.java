package CS401;
import java.util.*;

public class Main {
	public static void main (String args []) throws InterruptedException {
			Scanner scan = new Scanner(System.in);
			System.out.print("Please enter the dimension of the 2D array:\n");
			// input array size, and choose the way you initialize the array
			int n = 0;
			while(n<=0) {
				n = scan.nextInt();
			}
			int flag = -1;
			System.out.println("Enter 1 if you want the matrix filled with 2x2 blocks with same element, otherwise 0");
			while(flag!=0 && flag !=1) {
				flag = scan.nextInt();
			}
			TwoDimensionalArray arr = null;
			if(flag==0) {
				arr = new  TwoDimensionalArray(n, 100); 
			} else {
				arr = new  TwoDimensionalArray(n, 100, "2x2 group");
			}
		 	// get the element - (i, j) tree-map, output the largest element's coordinate
		 	long start = System.currentTimeMillis();
		 	TreeMap<Integer, List<Tuple>> sortedNum = arr.getSortedNum();
		 	int max= sortedNum.lastEntry().getKey();
		 	List<Tuple> ind = sortedNum.lastEntry().getValue();
		 	String indices = "";
		 	for(Tuple t: ind) {
		 		indices += t.toString()+" ";
		 	}
		 	// get the column sum - column indices tree-map, output the column index with the largest column sum
		 	TreeMap<Integer, List<Integer>> colSum = arr.getColSums();
		 	String colIndex = "";
		 	for(int num: colSum.lastEntry().getValue()) {
		 		colIndex += num+" ";
		 	}
		 	// get the row sum - row indices tree-map, output the row index with the largest row sum
		 	TreeMap<Integer, List<Integer>> rowSum = arr.getRowSums();
		 	String rowIndex = "";
		 	for(int num: rowSum.lastEntry().getValue()) {
		 		rowIndex += num+" ";
		 	}
		 	// print out the matrix, the statistics of the matrix
		 	arr.printAll();
		 	System.out.println("The biggest number in the array is "+max+", and its index is "+indices);	 	
		 	System.out.println("The index of the row with the highest sum among all the rows is "+rowIndex+
		 			", and the index of the column with the highest sum among all the columns is "+colIndex);
		 	long end = System.currentTimeMillis()-start;
		 	System.out.println("Time taken to execute the program: "+end+" ms");
		 	
		 	/*/// print the sum of column and row
		 	System.out.println("Row Sum"+"\t"+"Column Index");
		 	for(int num: rowSum.keySet()) {
		 		System.out.println(num+"\t\t\t"+rowSum.get(num));
		 	}
		 	System.out.println("Col Sum"+"\t"+"Row Index");
		 	for(int num: colSum.keySet()) {
		 		System.out.println(num+"\t\t\t"+colSum.get(num));
		 	}/*/	
		 	scan.close();
		}
}
