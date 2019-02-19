package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.ElectricCarData;
import ua.edu.ukma.ykrukovska.unit5.practice.Engine;

public class Tesla extends ElectricCar{
    public Tesla(Engine engine) {
        super(engine);
        carData = new ElectricCarData(2018, "RITA-13");
    }

    @Override
    public void showCarInformation() {
        System.out.println(carData.getData());
    }
}
