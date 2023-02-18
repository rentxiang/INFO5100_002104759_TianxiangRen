public class Phone {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Phone(int id) {
        this.id = id;
        System.out.println("Creating a new Phone instance.");
    }

    public void call() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}
