package ua.edu.ukma.ykrukovska.unit7.practice;

public abstract class PizzaStore implements Booking{

    protected String order;

 public abstract String placeOrder(String order);
 public abstract Pizza supplyPizza();


 public void open(){
     System.out.println("Hello guest. We are happy to see you! ");
 }

}
