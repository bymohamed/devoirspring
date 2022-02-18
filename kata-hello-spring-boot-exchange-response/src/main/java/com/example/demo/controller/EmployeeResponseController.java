package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// this is a Rest Controller
@RestController
public class EmployeeResponseController {

    @Autowired
    ServiceResponse serviceResponse;

    @RequestMapping(value = "/showWeather/{name}", method = RequestMethod.GET)
    public String showWeather(@PathVariable(value = "name") String name) {
        return serviceResponse.callResponse(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getResponseTest() {
        return "test";
    }



}



