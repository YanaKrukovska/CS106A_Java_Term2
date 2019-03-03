package ua.edu.ukma.ykrukovska.unit7.homework;

public class WetShirtCarWash implements CarWash {
    @Override
    public void wash() {
        System.out.println(WetShirtCarWash.class.getSimpleName() + " is washing your car");
    }

    @Override
    public void vacuum() {
        System.out.println(WetShirtCarWash.class.getSimpleName() + " is vacuuming your car");
    }

    @Override
    public void polish() {
        System.out.println(WetShirtCarWash.class.getSimpleName() + " is polishing your car");
    }
}
