import java.io.*;

public class Circle extends Shape implements Serializable {
    private double radius;
    private static final double PI = 3.14159265359;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}
