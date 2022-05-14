package com.GarageManager;
import java.util.Arrays;

public class RegularMotorcycle extends Vehicle{
    public RegularMotorcycle() {
    }

    protected RegularMotorcycle(String modelName, String licenseNumber, int availableEnergy, int maximumTirePressure) {
        super(modelName, licenseNumber, "fuel", availableEnergy,Arrays.asList(
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure),
                new Wheel(maximumTirePressure, maximumTirePressure)));
    }
}
