package com.example.demoWebsite.Controller;


import com.example.demoWebsite.Entity.DemoEntityPojo;
import com.example.demoWebsite.Entity.StatusReview;
import com.example.demoWebsite.Service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class DemoController {


    @Value("classpath:read.json")
    Resource resource;
    ArrayList<String> arr=new ArrayList<>();
    private DemoService demoService;
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/getData")
    public ResponseEntity getData(){
        return  ResponseEntity.ok(demoService.showAll());
    }

    @GetMapping("/get")
    public void getdemo(@RequestBody DemoEntityPojo demoEntityPojo) throws IOException {
        ObjectMapper mapper=new ObjectMapper();

        File file=resource.getFile();
        JsonNode jsonNode=mapper.readTree(file);
//     System.out.println(jsonNode.fieldNames());
        Iterator<String> st=jsonNode.get("merchant").fieldNames();
        while(st.hasNext()){
            arr.add(st.next());
        }
        for(int i=0;i<arr.size();i++){
            String s= String.valueOf(jsonNode.get("merchant").get(arr.get(i)).get("value"));
            System.out.println(s);
        }
//StatusReview str=mapper.readValue(file, StatusReview.class);
//        String str=m.writerWithDefaultPrettyPrinter()
//                        .writeValueAsString(demoEntityPojo.getMerchantProfile());
//        System.out.println(str);
//if(demoEntityPojo.getMerchantProfile()==null){
//    System.out.println("Got You");
//}
//        System.out.println(demoEntityPojo.getMerchantProfile());
    }
}
