package com.ykrukovska.oop.animal;

public class Dog extends Animal{

    public Dog(double weight) {
        super(weight);
    }

    public void makeNoise(){
        System.out.println("Bark bark");
    }

}
