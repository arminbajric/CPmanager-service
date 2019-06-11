package com.cpmanager.service.controller;


import com.cpmanager.service.commonModels.AuthApiResponse;
import com.cpmanager.service.commonModels.UserDto;
import com.cpmanager.service.service.UserService;
import com.cpmanager.service.tableModels.UserTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value="/add")
    @PostMapping
    public AuthApiResponse<UserTableModel> saveUser(@RequestBody UserTableModel user){

        return new AuthApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @GetMapping
    public AuthApiResponse<List<UserTableModel>> listUser(){
        return new AuthApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{id}")
    public AuthApiResponse<UserTableModel> getOne(@PathVariable int id){
        return new AuthApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/{id}")
    public AuthApiResponse<UserDto> update(@RequestBody UserTableModel userDto) {
        return new AuthApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public AuthApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new AuthApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
