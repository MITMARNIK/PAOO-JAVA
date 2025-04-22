package Package;
import Package.Shape;
import java.util.List;

public class AreaCalculator {
    public static double sumAreas(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
}
