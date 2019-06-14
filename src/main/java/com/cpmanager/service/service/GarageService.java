package com.cpmanager.service.service;

import com.cpmanager.service.tableModels.CategoryTableModel;
import com.cpmanager.service.tableModels.VehicleTableModel;

import java.util.List;

public interface GarageService {

    List<VehicleTableModel> getVehiclesList();
    List<VehicleTableModel> getAllByCategory(CategoryTableModel category);
    CategoryTableModel getModel(String category);
    List<VehicleTableModel> getByFuel(String fuel);
    List<VehicleTableModel> getAvailableOnes(boolean available);
    List<VehicleTableModel> getAvailableOnesByFuel(boolean available,String fuel);
}
