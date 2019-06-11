package com.cpmanager.service.service;

import com.cpmanager.service.tableModels.UserTableModel;

import java.util.List;

public interface UserService {

    UserTableModel save(UserTableModel user);
    List<UserTableModel> findAll();
    void delete(int id);

    UserTableModel findOne(String username);

    UserTableModel findById(int id);

    UserTableModel update(UserTableModel userDto);
}
