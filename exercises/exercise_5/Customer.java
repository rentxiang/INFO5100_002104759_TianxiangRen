public class Customer implements CoffeeListener {
    private String name;

    public Customer(String name){
        this.name = name;
    }

    public void orderCoffee(Barista barista, String type, boolean hasMilk, boolean hasWhippedCream){
        System.out.println(name + " orders: " + type + " with "+ (hasMilk ? " milk" : "") + (hasWhippedCream ? " whipped cream" : ""));
        barista.addListener(this);
        barista.prepareCoffee(type, hasMilk, hasWhippedCream);
    }

    public void onCoffeeReady(Coffee coffee){
        System.out.println(name + ", your " + coffee.getDescription() + " is readdddy!");
    }


}
