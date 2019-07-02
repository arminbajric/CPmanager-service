package com.cpmanager.service.controller;


import com.cpmanager.service.commonModels.AuthApiResponse;
import com.cpmanager.service.commonModels.LoginUser;
import com.cpmanager.service.commonModels.UniqueStatus;
import com.cpmanager.service.commonModels.UserDto;
import com.cpmanager.service.config.JwtTokenUtil;
import com.cpmanager.service.service.UserService;
import com.cpmanager.service.tableModels.UserTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final JwtTokenUtil util;

    public UserController(UserService userService, JwtTokenUtil util) {
        this.userService = userService;
        this.util = util;
    }

    @RequestMapping(value="/add")
    @PostMapping
    public AuthApiResponse saveUser(@RequestBody UserTableModel user){

        userService.save(user);
        return new AuthApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",user);
    }

    @PostMapping("/userAuth")
    public UniqueStatus checkUser(@RequestBody LoginUser userLogin) {
        if(userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword())){
            return new  UniqueStatus(200,true,true,util.generateToken(userService.getByEmail(userLogin.getEmail())));
        }
        else if(!userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword())&& userService.findByEmail(userLogin.getEmail())){
            return new UniqueStatus(200,true,false);
        }
        else{
            return new UniqueStatus(404,false,false);
        }

    }

    @GetMapping("/{id}")
    public AuthApiResponse<UserTableModel> getOne(@PathVariable int id){
        return new AuthApiResponse<UserTableModel>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
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
