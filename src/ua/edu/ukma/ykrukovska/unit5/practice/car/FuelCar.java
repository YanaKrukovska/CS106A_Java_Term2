package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;
import ua.edu.ukma.ykrukovska.unit5.practice.FuelCarData;

public abstract class FuelCar extends Car {


    protected FuelCarData fuelCarData;

    public FuelCar(EcoboostEngine engine, FuelCarData carData) {
        super(engine);
        this.fuelCarData = carData;
    }

    public void doTrip(int distance, int fuelConsumptions, int time){
        fuelCarData.addFuelConsumption(fuelConsumptions);
        fuelCarData.setDistanceCovered(fuelCarData.getDistanceCovered() + distance);
        fuelCarData.setTimeOfDriving(fuelCarData.getTimeOfDriving() + time);
    }

}
