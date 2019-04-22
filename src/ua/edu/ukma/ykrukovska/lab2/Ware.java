package ua.edu.ukma.ykrukovska.lab2;

public class Ware {

    private String name;
    private String description;
    private String producer;
    private double price;
    private double amount = 0;
    private String group;


    public Ware(String name, String description, String producer, double price, String group) {
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.price = price;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", " + description + ", produced by " +
                producer + ", price: " + price + ", group: " + group + ", amount: " + amount;
    }
}
