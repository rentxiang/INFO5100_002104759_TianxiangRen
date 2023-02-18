public class Keyboard {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Keyboard(int id) {
        this.id = id;
        System.out.println("Creating a new Keyboard instance.");
    }

    public void tap() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}
