public class Lamp {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Lamp(int id) {
        this.id = id;
        System.out.println("Creating a new Lamp instance.");
    }

    public void light() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}