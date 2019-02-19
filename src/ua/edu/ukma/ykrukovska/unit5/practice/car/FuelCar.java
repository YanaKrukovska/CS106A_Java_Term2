package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;
import ua.edu.ukma.ykrukovska.unit5.practice.FuelCarData;

public abstract class FuelCar extends Car {


    public FuelCar(EcoboostEngine engine, FuelCarData carData) {
        super(engine);
        this.carData = carData;
    }

    public void doTrip(int distance, int fuelConsumptions, int time) {
        ((FuelCarData) carData).addFuelConsumption(fuelConsumptions);
        carData.setDistanceCovered(carData.getDistanceCovered() + distance);
        carData.setTimeOfDriving(carData.getTimeOfDriving() + time);
    }

}
