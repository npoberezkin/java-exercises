package patterns.builder;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = new MyPizza.Builder(MyPizza.Size.SMALL).addTopping(Pizza.Topping.HAM).addTopping(Pizza.Topping.MUSHROOM).build();
        System.out.println(pizza.toString());
    }
}
