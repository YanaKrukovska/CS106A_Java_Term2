package ua.edu.ukma.ykrukovska.unit7.homework;

public class SelfCarWashFactory implements CarWashFactory {
    @Override
    public CarWash createCarWash() {
        return new SelfCarWash();
    }
}
