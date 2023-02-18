public class Dog {
    
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Dog(int id) {
        this.id = id;
        System.out.println("Creating a new Dog instance.");
    }

    public void run() {
    }

    public void bark() {
        System.out.println("bark bark");
    }
}