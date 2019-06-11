package com.cpmanager.service.repositories;

import com.cpmanager.service.tableModels.EngineTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<EngineTableModel,Long> {
}
