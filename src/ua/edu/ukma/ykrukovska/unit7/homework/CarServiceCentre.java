package ua.edu.ukma.ykrukovska.unit7.homework;

public class CarServiceCentre {

    private CarWashFactory carWashFactory;

    public CarServiceCentre(CarWashFactory carWashFactory) {
        this.carWashFactory = carWashFactory;
    }

    public void cleanCar(){
        CarWash carWash = carWashFactory.createCarWash();
        carWash.wash();
        carWash.vacuum();
        carWash.polish();
    }

    public static void main(String[] args) {

        CarServiceCentre vidi  = new CarServiceCentre(new AutomaticCarWashFactory());
        vidi.cleanCar();
        System.out.println();
        CarServiceCentre garage = new CarServiceCentre(new WetTShirtCarWashFactory());
        garage.cleanCar();
        System.out.println();
        CarServiceCentre petrolStation = new CarServiceCentre(new SelfCarWashFactory());
        petrolStation.cleanCar();
    }
}
