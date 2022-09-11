package com.example.mircroservices.limitsservice.controller;

import com.example.mircroservices.limitsservice.bean.Limits;
import com.example.mircroservices.limitsservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsControler {

    private Configuration configuration;

    public LimitsControler(Configuration configuration){
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retriveLimits(){
       return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
