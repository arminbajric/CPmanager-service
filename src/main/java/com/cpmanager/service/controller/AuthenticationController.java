package com.cpmanager.service.controller;


import com.cpmanager.service.config.JwtTokenUtil;
import com.cpmanager.service.commonModels.AuthApiResponse;
import com.cpmanager.service.commonModels.AuthToken;
import com.cpmanager.service.commonModels.LoginUser;
import com.cpmanager.service.service.UserService;
import com.cpmanager.service.tableModels.UserTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public AuthApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final UserTableModel user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return new AuthApiResponse<>(200, "success",new AuthToken(token, user.getUsername()));
    }

}
