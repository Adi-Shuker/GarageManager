package com.GarageManager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("singleton")
public class GarageManager {
    public List<Vehicle> vehicles;
    // map between vehicle property to its comparator
    public HashMap<String, Comparator<Vehicle>> comparators;

    public GarageManager() {
        this.vehicles = new ArrayList<>();
        this.comparators = new HashMap<String, Comparator<Vehicle>>();
        comparators.put("modelName", Comparator.comparing(Vehicle::getModelName));
        comparators.put("licenseNumber", Comparator.comparing(Vehicle::getLicenseNumber));
        comparators.put("energySource", Comparator.comparing(Vehicle::getEnergySource));
        comparators.put("availableEnergy", Comparator.comparing(Vehicle::getAvailableEnergy));
    }

    public boolean addVehicle(Vehicle vehicle){
        boolean vehicleExists = vehicles.stream().anyMatch(item -> vehicle.getLicenseNumber().equals(item.getLicenseNumber()));
        if(!vehicleExists) {
            vehicles.add(vehicle);
        }
        return !vehicleExists;
    }

    public Vehicle getVehicle(String licenseNumber){
            Iterator<Vehicle> iterator = vehicles.iterator();
            while (iterator.hasNext()) {
                Vehicle vehicle = iterator.next();
                if (vehicle.getLicenseNumber().equals(licenseNumber)) {
                    return vehicle;
                }
            }
            return null;
    }

    public List<Vehicle> getAllVehicles(List<String> orderBy){
        return multipleFieldsSort(orderBy);
    }

    public Vehicle inflateVehicleTires(String licenseNumber) {
        Vehicle vehicle = getVehicle(licenseNumber);
        if(vehicle!=null){
            vehicle.inflateVehicleTires();
        }
        return vehicle;
    }

    public Vehicle addEnergy(String licenseNumber){
        Vehicle vehicle = getVehicle(licenseNumber);
        if(vehicle!=null){
            vehicle.addEnergy();
        }
        return vehicle;
    }

    // sort the vehicles list by user request
    public List<Vehicle> multipleFieldsSort(List<String> orderBy){
        if(orderBy==null){
            return vehicles;
        }
        Iterator<String> iterator = orderBy.iterator();
        Comparator<Vehicle> multipleFieldsComparator = Comparator.nullsFirst(null);
        // concat the relevant comparators according to the user request
        while (iterator.hasNext()) {
            String comp = iterator.next();
            multipleFieldsComparator = multipleFieldsComparator.thenComparing(comparators.get(comp));
        }
        vehicles.sort(multipleFieldsComparator);
        return vehicles;
    }
}
