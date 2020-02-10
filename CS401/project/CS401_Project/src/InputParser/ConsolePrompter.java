package InputParser;

import java.util.Scanner;
import java.util.logging.*;

public class ConsolePrompter {

	private static final Logger LOGGER = Logger.getLogger( ConsolePrompter.class.getName() );

	private Scanner in;
	
	// constructor
	public ConsolePrompter() {
		
	}
	public int promptInt(int lower, int upper) {	// takes a msg and print it before scanning for input
		in = new Scanner(System.in);
		int res = 0;
		boolean invalidInput = true;
		do {
			System.out.printf("\nPlease enter an integer between %d and %d:\n", lower, upper);
			if(this.in.hasNextInt()) {
				res = this.in.nextInt();
				invalidInput = false;
				if(res < lower || res > upper) {
					invalidInput = true;
					System.err.println("Input is out of range. Please try again.");
					LOGGER.log(Level.WARNING, "Invalid user input - out of range: {0}", res);
					this.in.nextLine();	// skip a line
					continue;
				}
			}else {
				System.err.println("Input is invalid. Please enter an integer.");
				LOGGER.log(Level.WARNING, "Invalid user input - not an integer: {0}", this.in.nextLine());
				invalidInput = true;
				continue;
			}
		}while(invalidInput);
		LOGGER.log( Level.FINE, "return user input: {0}", res);
		return res;
	}
	public float promptFloat(String msg) {	// takes a msg and print it before scanning for input
		in = new Scanner(System.in);
		boolean invalidInput = true;
		float res = 0;
		do {
			try {
				System.out.println(msg);
				res = this.in.nextFloat();
				invalidInput = false;
			}catch(Exception InputMismatchException) {
				System.err.println("Invalid user input. Please try again.");
				this.in.nextLine();
				invalidInput = true;
			}
		}while(invalidInput);
		return res;
	}
	
	public String promptString(String msg) {
		this.in = new Scanner(System.in);
		boolean invalidInput = true;
		String res = null;
		do {
			try {
				System.out.println(msg);
				res = this.in.nextLine();
				invalidInput = false;
			}catch(Exception InputMismatchException) {
				System.err.println("Invalid input. Please try again.");
				this.in.nextLine();
				invalidInput = true;
			}
		}while(invalidInput);
		return res;
	}
}