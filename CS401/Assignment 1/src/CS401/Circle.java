package CS401;

public class Circle {
	private int radius = 0;
	public Circle(int r){
		this.radius = r;
	}
	public int getRadius() {
		return this.radius;
	}
	public void setRadius(int r) {
		this.radius = r;
	}
	public String toString() {
		return "THis is a circle with radius "+this.radius;
	}
	/*/
	public double getPerimeter() {
		if(this.radius > 0) {
			return 6.28*radius;
		}
		return 0.0;
	}/*/
	public double getArea() {
		if(this.radius > 0) {
			return 3.14*Math.pow(radius, 2);
		}
		return 0.0;
	}
}
