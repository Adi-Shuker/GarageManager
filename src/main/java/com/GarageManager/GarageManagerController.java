package com.GarageManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GarageManagerController {

    @Autowired
    private GarageManager garageManager;
    ObjectMapper objectMapper = new ObjectMapper();

    //http://localhost:8080/api/vehicles
    /*
    body request:
    {
        "@type" : "ElectricCar",
        "modelName": "test",
        "licenseNumber": "1234567",
        "energySource" : "fuel",
        "availableEnergy": 100,
            "wheels": [
            {
                "maximumTirePressure": 32,
                "currentTirePressure": 15
            },
            {
                "maximumTirePressure": 32,
                "currentTirePressure": 32
            },
            {
                "maximumTirePressure": 32,
                "currentTirePressure": 32
            },
            {
                "maximumTirePressure": 32,
                "currentTirePressure": 32
            }
        ]
    }
    */
    @PostMapping("/vehicles")
    public Boolean addVehicle(@RequestBody String vehicleJson) throws JsonProcessingException {
        Vehicle vehicle = objectMapper.readValue(vehicleJson, Vehicle.class);
        return garageManager.addVehicle(vehicle);
    }

    //http://localhost:8080/api/vehicles/1234567
    @GetMapping(value = "/vehicles/{licenseNumber}")
    public String getVehicle(@PathVariable String licenseNumber) throws JsonProcessingException {
        return objectMapper.writeValueAsString(garageManager.getVehicle(licenseNumber));
    }

    //http://localhost:8080/api/vehicles?orderBy=availableEnergy,modelName
    @GetMapping("/vehicles")
    public String getAllVehicles(@RequestParam(value = "orderBy", required=false)  List<String> orderBy) throws JsonProcessingException {
        return objectMapper.writeValueAsString(garageManager.getAllVehicles(orderBy));
    }


    //http://localhost:8080/api/vehicles/1234567/inflate-vehicle-tires
    @PutMapping("/vehicles/{licenseNumber}/inflate-vehicle-tires")
    public String inflateVehicleTires(@PathVariable String licenseNumber) throws JsonProcessingException {
        return objectMapper.writeValueAsString(garageManager.inflateVehicleTires(licenseNumber));
    }

    //http://localhost:8080/api/vehicles/1234567/add-energy
    @PutMapping("/vehicles/{licenseNumber}/add-energy")
    public String addEnergy(@PathVariable String licenseNumber) throws JsonProcessingException {
        return objectMapper.writeValueAsString(garageManager.addEnergy(licenseNumber));
    }

}
