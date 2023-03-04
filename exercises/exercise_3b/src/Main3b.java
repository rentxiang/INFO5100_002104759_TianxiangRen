import java.io.*
;
public class Main3b {
    public static void main(String[] args) {
        System.out.println("---------------------------");
        Shape shape1 = new Circle(2.0);
        System.out.println("Circle: Radius: 2.0");
        System.out.println("Area of the circle: " + shape1.calculateArea());
        System.out.println("Perimeter of the circle: " + shape1.calculatePerimeter());

        System.out.println("---------------------------");
        System.out.println("Rectangle: width 3.0, height: 4.0");
        Shape shape2 = new Rectangle(3.0, 4.0);
        System.out.println("Area of the rectangle: " + shape2.calculateArea());
        System.out.println("Perimeter of the rectangle: " + shape2.calculatePerimeter());

        System.out.println("---------------------------");
        System.out.println("Triangle of base: 5.0, height: 6.0, sides: 3.0, 4.0, 5.0");
        Shape shape3 = new Triangle(5.0, 6.0, 3.0, 4.0, 5.0);
        System.out.println("Area of the triangle: " + shape3.calculateArea());
        System.out.println("Perimeter of the triangle: " + shape3.calculatePerimeter());

        System.out.println("---------------------------");
        System.out.println("Square of side: 4.0");
        Shape shape4 = new Square(4.0);
        System.out.println("Area of the square: " + shape4.calculateArea());
        System.out.println("Perimeter of the square: " + shape4.calculatePerimeter());
        System.out.println("---------------------------");

        // Serialize objects
        try {
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(shape1);
            out.writeObject(shape2);
            out.writeObject(shape3);
            out.writeObject(shape4);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in shapes.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialize objects
        try {
            FileInputStream fileIn = new FileInputStream("shapes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Shape deserializedShape1 = (Shape) in.readObject();
            Shape deserializedShape2 = (Shape) in.readObject();
            Shape deserializedShape3 = (Shape) in.readObject();
            Shape deserializedShape4 = (Shape) in.readObject();
            in.close();
            fileIn.close();

            // Print deserialized objects
            System.out.println("Deserialized data:");
            System.out.println(deserializedShape1.getClass().getSimpleName() + ": " + deserializedShape1.calculateArea());
            System.out.println(deserializedShape2.getClass().getSimpleName() + ": " + deserializedShape2.calculateArea());
            System.out.println(deserializedShape3.getClass().getSimpleName() + ": " + deserializedShape3.calculateArea());
            System.out.println(deserializedShape4.getClass().getSimpleName() + ": " + deserializedShape4.calculateArea());
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Shape class not found");
            c.printStackTrace();
        }
    }
}





