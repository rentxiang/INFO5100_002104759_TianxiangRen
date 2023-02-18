public class Mouse {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Mouse(int id) {
        this.id = id;
        System.out.println("Creating a new Mouse instance.");
    }

    public void click() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}
