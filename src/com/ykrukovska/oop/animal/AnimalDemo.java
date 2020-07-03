package com.ykrukovska.oop.animal;

public class AnimalDemo {

    public static void main(String[] args) {
        Cat cat = new Cat(3.);
        Dog dog = new Dog(5.);

        Animal[] animals = new Animal[2];
        animals[0] = cat;
        animals[1] = dog;

        for (int i = 0; i < animals.length; i++) {
            animals[i].makeNoise();
            animals[i].eat();
        }

    }
}
