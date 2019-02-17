package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;
import ua.edu.ukma.ykrukovska.unit5.practice.FuelCarData;

public abstract class HybridCar extends FuelCar {

    public HybridCar(EcoboostEngine engine, FuelCarData carData) {
        super(engine, carData);
    }
}
