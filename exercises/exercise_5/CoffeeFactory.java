public class CoffeeFactory {
    public static Coffee createCoffee(String type){
        if(type.equals("Espresso")){
            return new Espresso();
        }else if(type.equals("Latte")){
            return new Latte();
        }else if(type.equals("oolong tea")){
            return new Oolong();
        }else{
            return null;
        }
    }
}
