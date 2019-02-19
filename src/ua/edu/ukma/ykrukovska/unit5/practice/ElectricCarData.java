package ua.edu.ukma.ykrukovska.unit5.practice;

public class ElectricCarData extends CarData {

    private int batteryLife = 100;

    public ElectricCarData(int year, String vin) {
        super(year, vin);
    }

    @Override
    public String getData(){
        return super.getData() + " . Battery life: " + batteryLife;
    }
}
