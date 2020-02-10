import java.util.LinkedList;
import java.util.List;

public class StringPermutation {
	public static void dfs(List<String> res, char[] 
			Sets, int k, String temp) {
		if(temp.length()==k) {
			res.add(new String(temp));
			return;
		}
		for(int i = 0; i<Sets.length; ++i) {
			dfs(res, Sets, k, new String(temp+Sets[i]));
		}
	}
	public static void print(List<String> res) {
		for(String s: res) {
			System.out.println(s);
		}
	}
	public static void main(String args[]) {
		// Example 1
		System.out.println("Set[]={'a','b','c'}, k=3");
		List<String> res = new LinkedList<String>();
		char[] Sets = {'a', 'b'};
		dfs(res, Sets, 2, "");
		print(res);
		// Example 2
		System.out.println("Set[]={'a','b','c','d'}, k=1");
		List<String> res2 = new LinkedList<String>();
		char[] Sets2 = {'a','b','c','d'};
		dfs(res2, Sets2, 1, "");
		print(res2);
	}
}