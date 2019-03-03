package ua.edu.ukma.ykrukovska.unit7.practice;

import java.util.Random;

public class Dominos extends PizzaStore {

    @Override
    public String placeOrder(String order) {
        this.order = order;
        Random random = new Random();

        return "Your order " + order + " number is " + random.nextInt();
    }

    @Override
    public Pizza supplyPizza() {
        return new Pizza(order, 33);
    }

    @Override
    public boolean checkAvailableTables() {
        return false;
    }

    @Override
    public void bookTable(String name, String phoneNumber) {

        System.out.println("Unfortunately it's not possible to book a table here");
    }
}
