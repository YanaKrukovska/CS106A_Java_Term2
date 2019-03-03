package ua.edu.ukma.ykrukovska.unit7.homework;

public class AutomaticCarWashFactory implements CarWashFactory {
    @Override
    public CarWash createCarWash() {
        return new AutomaticCarWash();
    }
}
