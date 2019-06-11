package com.cpmanager.service.repositories;

import com.cpmanager.service.tableModels.RequestTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<RequestTableModel,Long> {
}
