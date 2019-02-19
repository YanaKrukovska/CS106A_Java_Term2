package ua.edu.ukma.ykrukovska.unit5.practice;

public abstract class CarData {

    protected int year;
    protected String vin;
    protected int distanceCovered;
    protected int timeOfDriving;

    public CarData(int year, String vin) {
        this.year = year;
        this.vin = vin;
    }

    public String getData(){
        return "year: "+ getYear() + " . Vin: " + getVin() + " . Distance covered: " +
                getDistanceCovered() + " . Time of driving: " + getTimeOfDriving();
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

    public String getVin() {
        return vin;
    }

    public int getDistanceCovered() {
        return distanceCovered;
    }

    public String showDistanceCovered() {

        return "Distance: " + distanceCovered + ". Time: " + timeOfDriving ;
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }
}
