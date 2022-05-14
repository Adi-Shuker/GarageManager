package com.GarageManager;

import java.util.Arrays;

public class RegularCar extends Vehicle{
    public RegularCar() {
    }

    protected RegularCar(String modelName, String licenseNumber, int availableEnergy, int maximumTirePressure) {
        super(modelName, licenseNumber, "fuel",availableEnergy , Arrays.asList(
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure)));
    }
}
