package CS401;
import java.util.*;

public class TwoDimensionalArray {
	private int size = -1;
	private int[][] data;
	private int[] rowSum;
	private int[] colSum;
	private TreeMap<Integer, List<Tuple>> sortedNum = new TreeMap<>();
	private TreeMap<Integer, List<Integer>> rowSums = new TreeMap<>();
	private TreeMap<Integer, List<Integer>> colSums = new TreeMap<>();
	// initializa the 2d array
	public TwoDimensionalArray(int n, int upbound) {
		if(n>0) {
			size = n;
			rowSum = new int[size];
			colSum = new int[size];
			data = new int[size][size];
			for(int i = 0; i<size; i++) {
				for(int j = 0; j<size; j++) {
					int num = ( (int)(Math.random()*upbound) );
					data[i][j] = num;
				}
			}
		}
	}
	// initialize the 2d array (group by 2x2 block of same number)
	public TwoDimensionalArray(int n, int upbound, String flag) {
		if(n>0) {
			size = n;
			rowSum = new int[size];
			colSum = new int[size];
			data = new int[size][size];
			for(int i = 0; i<size; i+=2) {
				for(int j = 0; j<size; j+=2) {
					int num = ( (int)(Math.random()*upbound) );
					data[i][j] = num;
					if(i+1 < size) data[i+1][j] = num;	
					if(j+1 < size) data[i][j+1] = num;
					if((i+1)<size&&(j+1)<size) data[i+1][j+1] = num;
				}
			}
		}
	}
	// getters and setters
	public int getSize() {
		return this.size;
	}
	public void setData(int row, int col, int dat) {
		data[row][col] = dat;
	}
	public int getData(int row, int col) {
		if(row<size && col<size)
			return data[row][col];
		return -1;
	}
	public int[] getRowSum() {
		return rowSum;
	}
	
	public int[] getColSum() {
		return colSum;
	}
	// print the 2d array
	public void printAll() {
		if(size== -1)
			return;
		for(int[] row: data) {
			for(int num: row) {
				System.out.print(num+"\t");
			}
			System.out.println("");
		}
	}
	// get the tree-map of {data[i][j]: (i, j)} (sorted by data[i][j] in ascending order)
	public TreeMap<Integer, List<Tuple>> getSortedNum() {
		for(int i = 0; i<data.length; ++i) {
			for(int j = 0; j<data[i].length; ++j) {
				if(!sortedNum.containsKey(data[i][j])) {
					sortedNum.put(data[i][j], new LinkedList<Tuple>());
				}
				sortedNum.get(data[i][j]).add(new Tuple(i, j));
			}
		}
		return sortedNum;
	}
	// get the tree-map of { rowSum: i } (sorted by rowSum in ascending order)
	public TreeMap<Integer, List<Integer>> getRowSums() {
		for(int i = 0; i<data.length; ++i) {
			for(int j = 0; j<data[i].length; ++j) {
				rowSum[i] += data[i][j];
			}
		}
		for(int i = 0; i<rowSum.length; ++i) {
			if(!rowSums.containsKey(rowSum[i])) {
				rowSums.put(rowSum[i], new LinkedList<Integer>());
			}
			rowSums.get(rowSum[i]).add(i);
		}
		return rowSums;
	}
	// get the tree-map of { colSum: j} (sorted by colSum in ascending order)
	public TreeMap<Integer, List<Integer>> getColSums() {
		for(int i = 0; i<data.length; ++i) {
			for(int j = 0; j<data[i].length; ++j) {
				colSum[j] += data[i][j];
			}
		}
		for(int i = 0; i<colSum.length; ++i) {
			if(!colSums.containsKey(colSum[i])) {
				colSums.put(colSum[i], new LinkedList<Integer>());
			}
			colSums.get(colSum[i]).add(i);
		}
		return colSums;
	}
}
