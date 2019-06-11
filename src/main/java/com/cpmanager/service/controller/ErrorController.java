package com.cpmanager.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class ErrorController {
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public ModelAndView error () {
        System.out.print("uaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
