package com.GarageManager;

import java.util.Arrays;

public class ElectricCar extends Vehicle{
    protected ElectricCar(String modelName, String licenseNumber,int availableEnergy, int maximumTirePressure) {
        super(modelName, licenseNumber, "battery", availableEnergy, Arrays.asList(
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure)));
    }

    public ElectricCar() {
    }
}
