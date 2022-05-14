package com.GarageManager;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Iterator;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ElectricCar.class, name = "ElectricCar"),
        @JsonSubTypes.Type(value = ElectricMotorcycle.class, name = "ElectricMotorcycle"),
        @JsonSubTypes.Type(value = RegularCar.class, name = "RegularCar"),
        @JsonSubTypes.Type(value = RegularMotorcycle.class, name = "RegularMotorcycle"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck"),
})
public abstract class Vehicle {
    private String modelName;
    private String licenseNumber;
    private String energySource;
    private int availableEnergy; //percentage
    private List<Wheel> wheels;

    public Vehicle() {
    }


    protected Vehicle(String modelName, String licenseNumber, String energySource, int availableEnergy, List<Wheel> wheels) {
        this.modelName = modelName;
        this.licenseNumber = licenseNumber;
        this.energySource = energySource;
        this.availableEnergy = availableEnergy;
        this.wheels = wheels;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEnergySource() {
        return energySource;
    }

    public void setEnergySource(String energySource) {
        this.energySource = energySource;
    }

    public int getAvailableEnergy() {
        return availableEnergy;
    }

    public void setAvailableEnergy(int availableEnergy) {
        this.availableEnergy = availableEnergy;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public void inflateVehicleTires() {
        Iterator<Wheel> iterator = wheels.iterator();
        while (iterator.hasNext()) {
            Wheel wheel = iterator.next();
            wheel.InflateTire();
        }
    }

    public void addEnergy() {
        this.availableEnergy = 100;
    }

}
