package ua.edu.ukma.ykrukovska.unit5.practice;

public class CarData {

    protected int year;
    protected int vin;
    protected int distanceCovered;
    protected int timeOfDriving;

    public CarData(int year) {
        this.year = year;
    }

    public int getTimeOfDriving() {
        return timeOfDriving;
    }

    public void setTimeOfDriving(int timeOfDriving) {
        this.timeOfDriving = timeOfDriving;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }
}
