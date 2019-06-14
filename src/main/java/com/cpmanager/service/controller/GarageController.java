package com.cpmanager.service.controller;

import com.cpmanager.service.service.GarageService;
import com.cpmanager.service.tableModels.VehicleTableModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/app" )
public class GarageController {
     private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @RequestMapping(value = "/app/vehicles",method = RequestMethod.GET)
    public ResponseEntity getAllVehicles(){
        return ResponseEntity.ok().body(garageService.getVehiclesList());
    }
    @RequestMapping(value="/app/vehicles/{category}")
    public List<VehicleTableModel> getAllByCategory(@RequestParam String category){
        return garageService.getAllByCategory(garageService.getModel(category));
    }
    @RequestMapping(value="/app/vehicles/{fuel}")
    public List<VehicleTableModel> getAllByFuel(@RequestParam String fuel){
        return garageService.getByFuel(fuel);
    }
    @RequestMapping(value="/app/vehicles/{available}")
    public List<VehicleTableModel> getAllByFuel(@RequestParam boolean available){
        return garageService.getAvailableOnes(available);
    }
    @RequestMapping(value="/app/vehicles/{available}{fuel}")
    public List<VehicleTableModel> getAvailableOnesByFuel(@RequestParam boolean available,@RequestParam String fuel){
        return garageService.getAvailableOnesByFuel(available, fuel);
    }
}
