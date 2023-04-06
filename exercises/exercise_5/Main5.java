public class Main5 {
    public static void main(String[] args){
        Barista barista = new Barista();
        Customer Carmen = new Customer("Carmen");
        Customer Dylan = new Customer("Dylan");

        System.out.println("-------------------");
        Carmen.orderCoffee(barista, "oolong tea", true, false);
        System.out.println("Attention: Carmen needs chess cream with her order oolong milk tea!👀☕️💗");
        Dylan.orderCoffee(barista, "Latte", true, false);
    }
}
