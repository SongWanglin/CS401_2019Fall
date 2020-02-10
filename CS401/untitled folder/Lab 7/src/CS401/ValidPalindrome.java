package CS401;

public class ValidPalindrome {
	public ValidPalindrome() {
		
	}
	public boolean checker(String s) {
		if(s.isEmpty() || s==null)
			return true;
		int start = 0, end = s.length()-1;
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++; end--;
		}
		return true;
	}
}
