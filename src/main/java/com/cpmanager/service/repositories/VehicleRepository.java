package com.cpmanager.service.repositories;

import com.cpmanager.service.tableModels.CategoryTableModel;
import com.cpmanager.service.tableModels.VehicleTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleTableModel,String> {
public List<VehicleTableModel> getAllByCategoryTableModel(CategoryTableModel categoryTableModel);
public List<VehicleTableModel> getAllByFuel(String fuel);
    public List<VehicleTableModel> getAllByAvailable(boolean available);
    public  List<VehicleTableModel> getAllByFuelAndAvailable(String fuel,boolean available);
}
