package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.EcoboostEngine;
import ua.edu.ukma.ykrukovska.unit5.practice.FuelCarData;

public class FordFocus3 extends PetrolCar {

    public FordFocus3(EcoboostEngine engine) {
        super(engine,new FuelCarData(2017, "AA2257II"));

    }


    @Override
    public void showCarInformation() {
        System.out.println(carData.getData());
    }
}
