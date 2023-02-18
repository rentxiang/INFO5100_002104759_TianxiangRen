public class Book {
    int id;
    String name;
    String color;
    String material;
    int height;
    int width;
    int depth;
    boolean hasArmrests;

    public Book(int id) {
        this.id = id;

        System.out.println("Creating a new Book instance.");
    }

    public void read() {
    }

    public void sold() {
        System.out.println("Sold out.");
    }
}
