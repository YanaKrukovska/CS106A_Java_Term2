package com.ykrukovska.oop.animal;

public abstract class Animal {

    private double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public abstract void makeNoise();

    public void eat() {
        System.out.println("I'm eating");
    }

}
