public class  Cup {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Cup(int id) {
        this.id = id;
        System.out.println("Creating a new Cup instance.");
    }

    public void fill() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}