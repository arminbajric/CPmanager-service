package com.cpmanager.service.impl;

import com.cpmanager.service.repositories.VehicleRepository;
import com.cpmanager.service.service.GarageService;
import com.cpmanager.service.tableModels.VehicleTableModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {
    private final VehicleRepository vehicleRepository;

    public GarageServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleTableModel> getVehiclesList() {
        return vehicleRepository.findAll();
    }
}
