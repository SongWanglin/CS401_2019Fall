package cs401;

public class Jacobsthal {
	public Jacobsthal() {
		
	}
	
	// recursive Jacobsthal
	public long Jacobsthal_recursive(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return Jacobsthal_recursive(n-1)+2*Jacobsthal_recursive(n-2);
	}
	// iterative Jacobsthal
	public String Jacobsthal_iterative(long n) {
		long[] dp = new long[2];
		dp[0] = 0;
		dp[1] = 1;
		String res = "Iterative version: 0, 1";
		for(int i = 2; i<n+1; ++i){
			long temp = dp[1]+2*dp[0];
			dp[0] = dp[1];
			dp[1] = temp;
			res += " ,"+temp;
		}
		return res;
	}
}
