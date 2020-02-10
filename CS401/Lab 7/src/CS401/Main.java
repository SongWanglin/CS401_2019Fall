package CS401;

public class Main {

	public static void main(String[] args) {
		System.out.println("\nPart I: infix to postfix converter.");
		InfixToPostfixConverter converter = new InfixToPostfixConverter();
		String infix1 = "7+2*8";
		String infix2 = "14-6+7*4-10";
		String infix3 = "2^3+9^2";
		String postfix1 = converter.InfixToPostfix(infix1);
		String postfix2 = converter.InfixToPostfix(infix2);
		String postfix3 = converter.InfixToPostfix(infix3);
		int res1 = converter.PostfixCalculator(postfix1);
		int res2 = converter.PostfixCalculator(postfix2);
		int res3 = converter.PostfixCalculator(postfix3);
		System.out.println("The first infix expression is:\t"+infix1+"\tthe corresponding postfix expression is: "+postfix1+"\nthe evaluation is: "+res1);
		System.out.println("The second infix expression is:\t"+infix2+"\tthe corresponding postfix expression is: "+postfix2+"\nthe evaluation is: "+res2);
		System.out.println("The third infix expression is:\t"+infix3+"\tthe corresponding postfix expression is: "+postfix3+"\nthe evaluation is: "+res3);
		System.out.println("\nPart II: valid palindrome.");
		String input1 = "121";
		String input2 = "amanaplanacanalpanama";
		ValidPalindrome checker = new ValidPalindrome();
		System.out.println(input1+" is palindrome string: "+checker.checker(input1));
		System.out.println(input2+" is palindrome string: "+checker.checker(input2));
	}

}
