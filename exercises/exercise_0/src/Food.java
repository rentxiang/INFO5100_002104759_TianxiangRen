public class Food {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Food(int id) {
        this.id = id;
        System.out.println("Creating a new Food instance.");
    }

    public void eat() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}
