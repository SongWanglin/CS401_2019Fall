package CS401;
import java.util.Comparator;
// Comparactor that compare the circles according to their radius
public class compareCircle implements Comparator<Circle> {
	public  int compare(Circle c1,  Circle c2) {
		return c1.getRadius()-c2.getRadius();
	}
}
