package ua.edu.ukma.ykrukovska.unit5.practice.car;

import ua.edu.ukma.ykrukovska.unit5.practice.CarData;

public class HybridCarData extends CarData {

    protected int batteryVolume;

    public HybridCarData(int year, int batteryVolume) {
        super(year);
        this.batteryVolume = batteryVolume;
    }
}
