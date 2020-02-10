
public class Minimum {
	public static int minimum(int A[], int size) {
		if(A.length==0)
			return 0;
		if(size == 0)
			return A[0];
		return Math.min(A[size-1], minimum(A, size-1));
	}
	public static void main(String args[]) {
		int A[] = {10, -20, 1, 2, 0, 5, -100};
		int s = minimum(A, 4);
		System.out.println(s);
	}
}
