package ua.edu.ukma.ykrukovska.unit7.homework;

public class WetTShirtCarWashFactory implements CarWashFactory {
    @Override
    public CarWash createCarWash() {
        return new WetShirtCarWash();
    }
}
