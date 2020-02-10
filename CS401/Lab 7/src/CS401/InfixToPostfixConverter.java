package CS401;

import java.util.Arrays;
import java.util.HashSet;

public class InfixToPostfixConverter {
	MyStack stack;
	public InfixToPostfixConverter() {
		this.stack = new MyStack();
	}
	private int Prec(char temp) {
		return (temp=='+'||temp=='-')? 1: (temp=='*'||temp=='/')? 2:
				(temp=='^')? 3: -1;
	}
	public String InfixToPostfix(String exp) {
		String result = "";
		for(int i = 0; i<exp.length(); ++i){ 
	        char c = exp.charAt(i); 
	        if (Character.isLetterOrDigit(c)) 
	            result += c; 
	        else if (c == '(') {
	            stack.push(c); 
	        	result += " ";
	        }else if (c == ')') { 
	            while (!stack.isEmpty() && stack.peek() != '(') 
	                result += " "+stack.pop(); 
	            if (!stack.isEmpty() && stack.peek() != '(') 
	                return "Invalid Expression";              
	            else
	                stack.pop(); 
	        } 
	        else{ 
	            while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
	                if(stack.peek() == '(') 
	                    return "Invalid Expression"; 
	                result += " "+stack.pop(); 
	         } 
	            stack.push(c); 
	            result += " ";
	        } 
	   
	    }  
	    while (!stack.isEmpty()){ 
	        if(stack.peek() == '(') 
	            return "Invalid Expression"; 
	        result += " "+stack.pop(); 
	     } 
	    return result; 
	}
	public int PostfixCalculator(String input) {
		String[] exp = input.split("\\s+?");
		HashSet<String> ops = new HashSet<>();
		ops.add("+");ops.add("-");ops.add("*");ops.add("/");ops.add("^");
		for(int i = 0; i<exp.length; ++i) {
			if(ops.contains(exp[i])){
				int num2 = (int)stack.pop();
				int num1 = (int)stack.pop();
				switch(exp[i]) {
					case "+":
						stack.push(num1+num2);
						break;
					case "-":
						stack.push(num1-num2);
						break;
					case "*":
						stack.push(num1*num2);
						break;
					case "/":
						stack.push(num1/num2);
						break;
					case "^":
						stack.push((int)Math.pow(num1, num2));
						break;
				}
			}else {
				stack.push(Integer.parseInt(exp[i]));
			}
		}
		int res = (int)stack.pop();
		return res;
	}
}
