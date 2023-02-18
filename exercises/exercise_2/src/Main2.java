public class Main2 {
    public static void main(String[] args) {
        System.out.println("---------------------------");
        Shape shape = new Circle(2.0);
        System.out.println("Circle: Radius: 2.0");
        System.out.println("Area of the circle: " + shape.calculateArea());
        System.out.println("Perimeter of the circle: " + shape.calculatePerimeter());

        System.out.println("---------------------------");
        System.out.println("Rectangle: width 3.0, height: 4.0");
        shape = new Rectangle(3.0, 4.0);
        System.out.println("Area of the rectangle: " + shape.calculateArea());
        System.out.println("Perimeter of the rectangle: " + shape.calculatePerimeter());

        System.out.println("---------------------------");
        System.out.println("Triangle of base: 5.0, height: 6.0, sides: 3.0, 4.0, 5.0");
        shape = new Triangle(5.0, 6.0, 3.0, 4.0, 5.0);
        System.out.println("Area of the triangle: " + shape.calculateArea());
        System.out.println("Perimeter of the triangle: " + shape.calculatePerimeter());

        System.out.println("---------------------------");
        System.out.println("Square of side: 4.0");
        shape = new Square(4.0);
        System.out.println("Area of the square: " + shape.calculateArea());
        System.out.println("Perimeter of the square: " + shape.calculatePerimeter());
        System.out.println("---------------------------");

    }
}





