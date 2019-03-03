package ua.edu.ukma.ykrukovska.unit7.practice;

import java.util.Random;

public class MamaMia extends PizzaStore implements Booking{

    @Override
    public String placeOrder(String order) {
        this.order = order;
        return "Your pizza " + order + " is being cooked. Waiter will bring it to you asap " ;
    }

    @Override
    public Pizza supplyPizza() {
        return new Pizza(order, 33);
    }

    @Override
    public boolean checkAvailableTables() {
        Random random = new Random();
        boolean isAvailable = random.nextBoolean();

        if (isAvailable){
            System.out.println("Tables are available");
        } else {
            System.out.println("Unfortunately tables are not available");
        }
        return isAvailable;
    }

    @Override
    public void bookTable(String name, String phoneNumber) {

        System.out.println("Table for " + name + ", " + phoneNumber + " reserved");
    }
}
