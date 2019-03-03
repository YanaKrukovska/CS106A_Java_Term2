package ua.edu.ukma.ykrukovska.unit7.homework;

public class AutomaticCarWash implements CarWash {
    @Override
    public void wash() {
        System.out.println(AutomaticCarWash.class.getSimpleName() + " is washing your car");
    }

    @Override
    public void vacuum() {
        System.out.println(AutomaticCarWash.class.getSimpleName() + " vacuuming is not available");
    }

    @Override
    public void polish() {
        System.out.println(AutomaticCarWash.class.getSimpleName() + " polishing is not available");
    }
}
