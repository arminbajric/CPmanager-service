package com.cpmanager.service.repositories;

import com.cpmanager.service.tableModels.UserTableModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTableModel,Long> {
   UserTableModel findByUsername(String email);
}
