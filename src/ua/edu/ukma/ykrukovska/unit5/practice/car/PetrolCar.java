package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;
import ua.edu.ukma.ykrukovska.unit5.practice.FuelCarData;

public abstract class PetrolCar extends FuelCar {
    public PetrolCar(EcoboostEngine engine, FuelCarData carData) {
        super(engine, carData);
    }
}
