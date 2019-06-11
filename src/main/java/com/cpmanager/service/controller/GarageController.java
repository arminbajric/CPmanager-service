package com.cpmanager.service.controller;

import com.cpmanager.service.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
