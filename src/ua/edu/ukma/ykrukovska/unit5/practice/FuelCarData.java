package ua.edu.ukma.ykrukovska.unit5.practice;


public class FuelCarData extends CarData {


    private int fuelConsumption;

    public String showDistanceCovered() {

        return "Distance: " + distanceCovered + ". Time: " + timeOfDriving + ". Fuel: " + fuelConsumption;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void addFuelConsumption(int fuelConsumption) {
        this.fuelConsumption += fuelConsumption;
    }

    public FuelCarData(int year) {
        super(year);
    }
}
