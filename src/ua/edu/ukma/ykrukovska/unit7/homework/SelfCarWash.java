package ua.edu.ukma.ykrukovska.unit7.homework;

public class SelfCarWash implements CarWash {
    @Override
    public void wash() {
        System.out.println(SelfCarWash.class.getSimpleName() + " is washing your car");
    }

    @Override
    public void vacuum() {
        System.out.println(SelfCarWash.class.getSimpleName() + " is vacuuming your car");
    }

    @Override
    public void polish() {
        System.out.println(SelfCarWash.class.getSimpleName() + " is polishing your car");
    }
}
