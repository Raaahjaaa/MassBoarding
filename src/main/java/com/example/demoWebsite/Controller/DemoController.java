package com.example.demoWebsite.Controller;


import com.example.demoWebsite.Entity.DemoEntityPojo;
import com.example.demoWebsite.Service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {


    @Autowired
    private DemoService demoService;

    @GetMapping("/getData")
    public ResponseEntity getData(){
        return  ResponseEntity.ok(demoService.showAll());
    }

    @GetMapping("/get")
    public void getdemo(@RequestBody DemoEntityPojo demoEntityPojo) throws JsonProcessingException {
        ObjectMapper m=new ObjectMapper();
        String str=m.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(demoEntityPojo.getMerchantProfile());
        System.out.println(str);
if(demoEntityPojo.getMerchantProfile()==null){
    System.out.println("Got You");
}
        System.out.println(demoEntityPojo.getMerchantProfile());
    }
}
