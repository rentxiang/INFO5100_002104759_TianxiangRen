public class WhippedCream extends CoffeeDecorator {
    Coffee coffee;

    public WhippedCream(Coffee coffee){
        this.coffee = coffee;
    }

    public String getDescription(){
        return coffee.getDescription() + ", Whipped Cream";
    }

    public double cost(){
        return coffee.cost() + 0.75;
    }
}
