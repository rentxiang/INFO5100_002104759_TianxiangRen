import java.util.ArrayList;
import java.util.List;

//imitate a Starbucks shop
public class Barista{
    private List<CoffeeListener> listeners = new ArrayList<CoffeeListener>();

    public void addListener(CoffeeListener listener){
        listeners.add(listener);
    }

    public void removeListener(CoffeeListener listerner){
        listeners.remove(listerner);
    }

    public void prepareCoffee(String type, boolean hasMilk, boolean hasWhippedCream){
        Coffee coffee = CoffeeFactory.createCoffee(type);
        if(hasMilk){
            coffee = new Milk(coffee);
        }
        if(hasWhippedCream){
            coffee = new WhippedCream(coffee);
        }

        System.out.println("Making" + coffee.getDescription() + "....");
        System.out.println("Coffee reeeeeady!");

        for(CoffeeListener listener: listeners){
            listener.onCoffeeReady(coffee);
        }
    }
   
}