package ua.edu.ukma.ykrukovska.unit7.practice;

public class PizzaStoreTester {

    public static void main(String[] args) {

        PizzaStore dominos = new Dominos();
        PizzaStore mamaMia = new MamaMia();

        dominos.open();
        dominos.bookTable("Justin", "1 488 666");
        System.out.println(dominos.placeOrder("Toni pepperoni"));
        System.out.println(dominos.supplyPizza());
        System.out.println();
        mamaMia.open();
        if (mamaMia.checkAvailableTables()) {
            mamaMia.bookTable("Genddiy", "1 800 555");
        }
        System.out.println(mamaMia.placeOrder("Margarita"));
        System.out.println(mamaMia.supplyPizza());

    }

}
