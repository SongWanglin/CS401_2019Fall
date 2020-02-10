package CS401;
// class for point coordinate in the matrix
public class Tuple {
	private int X;
	private int Y;
	public Tuple(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public String toString() {
		return "["+X+"]"+"["+Y+"]";
	}
}
