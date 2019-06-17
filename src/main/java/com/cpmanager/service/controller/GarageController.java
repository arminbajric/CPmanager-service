package com.cpmanager.service.controller;

import com.cpmanager.service.commonModels.UniqueStatus;
import com.cpmanager.service.service.GarageService;
import com.cpmanager.service.tableModels.VehicleTableModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/app" )
public class GarageController {
     private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @RequestMapping(value = "/vehicles",method = RequestMethod.GET)
    public ResponseEntity getAllVehicles(){
        return ResponseEntity.ok().body(garageService.getVehiclesList());
    }
    @RequestMapping(value="/vehicles{category}" ,method = RequestMethod.GET)
    public List<VehicleTableModel> getAllByCategory(@RequestParam String category){
        return garageService.getAllByCategory(garageService.getModel(category));
    }
    @RequestMapping(value="/vehicles{fuel}",method = RequestMethod.GET)
    public List<VehicleTableModel> getAllByFuel(@RequestParam String fuel){
        return garageService.getByFuel(fuel);
    }
    @RequestMapping(value="/vehicles{available}",method = RequestMethod.GET)
    public List<VehicleTableModel> getAllByFuel(@RequestParam boolean available){
        return garageService.getAvailableOnes(available);
    }
    @RequestMapping(value="/vehicles{available}{fuel}",method = RequestMethod.GET)
    public List<VehicleTableModel> getAvailableOnesByFuel(@RequestParam boolean available,@RequestParam String fuel){
        return garageService.getAvailableOnesByFuel(available, fuel);
    }
    @RequestMapping(value = "/vehicles/add",method = RequestMethod.POST)
    public ResponseEntity addNewVehicle(@RequestBody VehicleTableModel vehicleTableModel){
        garageService.addNewVehicle(vehicleTableModel);
        return ResponseEntity.status(200).build();
    }
    @RequestMapping(value = "/vehicles/delete{reg_plates}",method = RequestMethod.DELETE)
    public ResponseEntity deleteVehicle(@RequestParam String reg_plates){
        garageService.deleteVehicle(reg_plates);
        return ResponseEntity.status(200).build();
    }
    @RequestMapping(value = "/vehicles/update{reg_plates}",method = RequestMethod.PUT)
    public ResponseEntity updateVehicle(@RequestParam String reg_plates){
        garageService.deleteVehicle(reg_plates);
        return ResponseEntity.status(200).build();
    }
    @RequestMapping(value = "/vehicles/unique{reg_plates}",method = RequestMethod.GET)
    public UniqueStatus checkRegPlates(@RequestParam String reg_plates){

        UniqueStatus uniqueStatus=new UniqueStatus(200,garageService.checkForUniqueRegPlates(reg_plates));
        return uniqueStatus;
    }
}
