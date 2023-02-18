public class Cat {
    
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Cat(int id) {
        this.id = id;
        System.out.println("Creating a new Cat instance.");
    }

    public void run() {
    }

    public void Meow() {
        System.out.println("Meow");
    }


    //nested class
public class BlackCat{
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public BlackCat(int id) {
        this.id = id;
        System.out.println("Creating a new BlackCat instance.");
    }

    public void run() {
    }

    public void Meow() {
        System.out.println("Meow");
    }
}
public class WhiteCat{
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public WhiteCat(int id) {
        this.id = id;
        System.out.println("Creating a new WhiteCat instance.");
    }

    public void run() {
    }

    public void Meow() {
        System.out.println("Meow");
    }
}
}

