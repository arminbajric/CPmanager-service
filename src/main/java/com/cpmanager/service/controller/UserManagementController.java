package com.cpmanager.service.controller;

import com.cpmanager.service.commonModels.UserApiResponse;
import com.cpmanager.service.service.UserService;
import com.cpmanager.service.tableModels.UserTableModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManagementController {
    private final UserService userService;

    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add-user",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public UserApiResponse addUser(@RequestBody UserTableModel user){

        try{
            userService.save(user);
            return new UserApiResponse(200,"User saved");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return new UserApiResponse(300,"Error while trying to save!");
        }
    }
}
