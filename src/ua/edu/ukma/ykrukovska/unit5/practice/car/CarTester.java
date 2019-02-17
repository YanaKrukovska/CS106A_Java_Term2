package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;

public class CarTester {


    public static void main(String[] args) {
        FordFocus3 ourCar = new FordFocus3(new EcoboostEngine());
        System.out.println(ourCar.getEngine().getEngineInformation());
        System.out.println(ourCar.getCarData().showDistanceCovered());
        ourCar.doTrip(20, 2, 30);
        System.out.println(ourCar.getCarData().showDistanceCovered());


    }

}
