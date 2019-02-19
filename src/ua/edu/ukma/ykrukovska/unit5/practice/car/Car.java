package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.CarData;
import ua.edu.ukma.ykrukovska.unit5.practice.Engine;

public abstract class Car {

    protected CarData carData;
    protected Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

  public abstract void showCarInformation();

    public Engine getEngine() {
        return engine;
    }

    public CarData getCarData(){
        return carData;
    }


    public void setCarData(CarData carData) {
        this.carData = carData;
    }
}
