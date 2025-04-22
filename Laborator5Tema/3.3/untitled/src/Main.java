//Refactor Exemplul 2. 3 Sum the areas of various shapes in such a way that a
//method should compute the areas sum 5

import Package.AreaCalculator;
import Package.Rectangle;
import Package.Shape;
import Package.Circle;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Shape> shapesList = List.of(
                new Circle(2),
                new Rectangle(1, 3),
                new Circle(1)
        );

        double totalArea = AreaCalculator.sumAreas(shapesList);

        for (Shape shape : shapesList) {
            System.out.println("Area " + shape.getClass().getSimpleName() + ": " + shape.getArea());
        }
        System.out.println("Total Area: " + totalArea);
    }
}
