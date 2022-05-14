package com.GarageManager;

public class Wheel {
    private int maximumTirePressure;
    private int currentTirePressure;

    public Wheel() {
    }

    public Wheel(int maximumTirePressure, int currentTirePressure) {
        this.maximumTirePressure = maximumTirePressure;
        this.currentTirePressure = currentTirePressure;
    }

    public int getCurrentTirePressure() {
        return currentTirePressure;
    }

    public void setCurrentTirePressure(int currentTirePressure) {
        this.currentTirePressure = currentTirePressure;
    }

    public int getMaximumTirePressure() {
        return maximumTirePressure;
    }

    public void setMaximumTirePressure(int maximumTirePressure) {
        this.maximumTirePressure = maximumTirePressure;
    }

    public void InflateTire(){
        this.currentTirePressure=this.maximumTirePressure;
    }
}
