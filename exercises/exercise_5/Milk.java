public class Milk extends CoffeeDecorator {
    Coffee coffee;

    public Milk(Coffee coffee){
        this.coffee = coffee;
    }

    public String getDescription(){
        return coffee.getDescription() + ", Milk";
    }

    public double cost(){
        return coffee.cost() + 0.50;
    }

}
