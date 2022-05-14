package com.GarageManager;
import java.util.Arrays;

public class Truck extends Vehicle{
    public Truck() {
    }

    protected Truck(String modelName, String licenseNumber, int availableEnergy, int maximumTirePressure) {
        super(modelName, licenseNumber, "fuel",availableEnergy , Arrays.asList(
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure)));
    }
}
