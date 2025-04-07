// Interfata pentru toate formele geometrice
interface Shape {
    double calculateArea();
}

// Clasa pentru dreptunghi
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Clasa pentru cerc
class Circle implements Shape {
    private double radius;
    private static final double PI = Math.PI;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }
}

// Fabrica de forme geometrice
class ShapeFactory {
    public static Shape createShape(String type, double... dimensions) {
        if ("rectangle".equalsIgnoreCase(type) && dimensions.length == 2) {
            return new Rectangle(dimensions[0], dimensions[1]);
        } else if ("circle".equalsIgnoreCase(type) && dimensions.length == 1) {
            return new Circle(dimensions[0]);
        }
        return null; // Sau arunca o exceptie pentru input invalid
    }
}

public class AreaCalculator {
    public static void main(String[] args) {
        // Utilizam fabrica pentru a crea un dreptunghi
        Shape dreptunghi = ShapeFactory.createShape("rectangle", 5.0, 10.0);
        if (dreptunghi != null) {
            System.out.println("Aria dreptunghiului: " + dreptunghi.calculateArea());
        } else {
            System.out.println("Nu s-a putut crea dreptunghiul.");
        }

        // Utilizam fabrica pentru a crea un cerc
        Shape cerc = ShapeFactory.createShape("circle", 7.0);
        if (cerc != null) {
            System.out.println("Aria cercului: " + cerc.calculateArea());
        } else {
            System.out.println("Nu s-a putut crea cercul.");
        }

        // Exemplu de input invalid
        Shape formaInvalida = ShapeFactory.createShape("patrat", 3.0);
        if (formaInvalida == null) {
            System.out.println("Nu s-a putut crea forma invalida.");
        }
    }
}