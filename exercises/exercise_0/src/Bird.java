
public class Bird {
        int id;
        String name;
        String color;
        String material;
        int height;
        int width;
        int depth;
        boolean hasArmrests;

        public Bird(int id) {
            this.id = id;
            System.out.println("Creating a new Bird instance.");
        }

        public void fly() {
        }

        public void sleep() {
            System.out.println("Bird is sleeping.");
        }
    }

