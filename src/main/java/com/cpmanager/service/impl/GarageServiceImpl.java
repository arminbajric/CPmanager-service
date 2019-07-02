package com.cpmanager.service.impl;

import com.cpmanager.service.repositories.CategoryRepository;
import com.cpmanager.service.repositories.VehicleRepository;
import com.cpmanager.service.service.GarageService;
import com.cpmanager.service.tableModels.CategoryTableModel;
import com.cpmanager.service.tableModels.VehicleTableModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {
    private final VehicleRepository vehicleRepository;
    private final CategoryRepository categoryRepository;

    public GarageServiceImpl(VehicleRepository vehicleRepository, CategoryRepository categoryRepository) {
        this.vehicleRepository = vehicleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<VehicleTableModel> getVehiclesList() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<VehicleTableModel> getAllByCategory(CategoryTableModel categoryTableModel) {
        return null;
    }

    @Override
    public CategoryTableModel getModel(String category) {
        return categoryRepository.getByName(category);
    }

    @Override
    public List<VehicleTableModel> getByFuel(String fuel) {
        return vehicleRepository.getAllByFuel(fuel);
    }

    @Override
    public List<VehicleTableModel> getAvailableOnes(boolean available) {
        return vehicleRepository.getAllByAvailable(available);
    }

    @Override
    public List<VehicleTableModel> getAvailableOnesByFuel(boolean available, String fuel) {
        return vehicleRepository.getAllByFuelAndAvailable(fuel, available);
    }

    @Override
    public void addNewVehicle(VehicleTableModel vehicleTableModel) {
        vehicleRepository.save(vehicleTableModel);

    }

    @Override
    public void deleteVehicle(String reg_plates) {
        vehicleRepository.deleteVehicleTableModelByRegPlates(reg_plates);
    }


    @Override
    public boolean checkForUniqueRegPlates(String reg_plates) {
        return vehicleRepository.getByRegPlates(reg_plates);
    }
}
