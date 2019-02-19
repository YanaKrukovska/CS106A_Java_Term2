package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;
import ua.edu.ukma.ykrukovska.unit5.practice.ElectricEngine;

public class CarTester {


    public static void main(String[] args) {
        FordFocus3 ourCar = new FordFocus3(new EcoboostEngine());
        Tesla dreamCar = new Tesla(new ElectricEngine());

        System.out.println(ourCar.getEngine().getEngineInformation());
        System.out.println(ourCar.getCarData().showDistanceCovered());
        ourCar.doTrip(20, 2, 30);
        System.out.println(ourCar.getCarData().showDistanceCovered());

        System.out.println(dreamCar.getEngine().getEngineInformation());

        Car[] cars = new Car[2];

        cars[0] = ourCar;
        cars[1] = dreamCar;

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getCarData().getData());
        }

    }

}
