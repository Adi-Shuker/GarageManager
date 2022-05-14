package com.GarageManager;

import java.util.Arrays;

public class ElectricMotorcycle extends Vehicle{
    public ElectricMotorcycle() {
    }

    protected ElectricMotorcycle(String modelName, String licenseNumber, int availableEnergy, int maximumTirePressure) {
        super(modelName, licenseNumber,"battery", availableEnergy, Arrays.asList(
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure)));
    }
}
