package ua.edu.ukma.ykrukovska.unit5.practice;


public class FuelCarData extends CarData {


    private int fuelConsumption;

    public FuelCarData(int year, String vin) {

        super(year, vin);
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void addFuelConsumption(int fuelConsumption) {
        this.fuelConsumption += fuelConsumption;
    }


    @Override
    public String getData(){
        return super.getData() + " . Fuel consumption: " + fuelConsumption;
    }
}
