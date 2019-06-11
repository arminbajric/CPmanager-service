package com.cpmanager.service.repositories;

import com.cpmanager.service.tableModels.ReportTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportTableModel,Long> {
}
