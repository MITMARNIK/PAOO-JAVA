import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

interface Shape {
    void draw(Graphics2D g2d);
}

class EightShape implements Shape {
    private int x;
    private int y;
    private int size;

    public EightShape(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // Drawing the top circle
        Ellipse2D.Double topCircle = new Ellipse2D.Double(x, y, size, size);
        g2d.draw(topCircle);

        // Drawing the bottom circle
        Ellipse2D.Double bottomCircle = new Ellipse2D.Double(x, y + size, size, size);
        g2d.draw(bottomCircle);

        //Connecting line.
        Line2D.Double connectingLine = new Line2D.Double(x + size, y + (size/2), x + size, y + (size + (size/2)));
        g2d.draw(connectingLine);
    }
}

public class ShapeDrawer extends JPanel {
    private List<Shape> shapes = new ArrayList<>();

    public ShapeDrawer() {
        shapes.add(new EightShape(50, 50, 50)); // Example: Draw an '8' shape
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ShapeDrawer());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}