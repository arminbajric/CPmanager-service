package com.cpmanager.service.service;

import com.cpmanager.service.tableModels.VehicleTableModel;

import java.util.List;

public interface GarageService {

    List<VehicleTableModel> getVehiclesList();
}
