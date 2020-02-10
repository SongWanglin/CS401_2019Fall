package CS401;
import java.io.*;
import java.util.*;
/* A20354898 Wanglin Song */
public class Main {
	public static void main(String[] args) {
		List<Circle> circles = new LinkedList<>();
		System.out.print("Please Enter the number of circle to create:");
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		// Create a list of circles that has N circles
		for(int i = 0; i<count; ++i) {
			circles.add(createCircle());
		}
		// Sort the circle list according to their radius
		Collections.sort(circles, new compareCircle());
		System.out.println("\nThe circle list after being sorted:");
		for(Circle c: circles) {
			System.out.println(c.toString());
		}
		scan.close();
	}
	// method to parse integers from input stream
    public static int readInteger() {
        try {
        	InputStreamReader input = new InputStreamReader(System.in);
        	BufferedReader reader = new BufferedReader(input);
        	return Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    // Create circle object and print out its area
    public static Circle createCircle() {
		int radius = -1;
		while(radius<=0) {
			System.out.println("Enter radius of a circle:");
			radius = readInteger();
		}
		Circle circle  = new Circle(radius);
		System.out.println("Area of a circle is:\n"+circle.getArea());
		return circle;
    }

}
