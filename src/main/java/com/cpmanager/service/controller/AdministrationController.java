package com.cpmanager.service.controller;

import com.cpmanager.service.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrationController {
    @Autowired
    private final AdministrationService adminstrationService;

    public AdministrationController(AdministrationService adminstrationService) {
        this.adminstrationService = adminstrationService;
    }
}
