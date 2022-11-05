package com.example.demoWebsite.Controller;


import com.example.demoWebsite.Service.DemoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@RestController
public class DemoController {


    @Value("classpath:student.xlsx")
    Resource excelFile;
    @Value("classpath:read.json")
    Resource jsonFile;
    @Value("classpath:status.xlsx")
    Resource resource3;

    public void getObj(JsonNode jsonNode){
        if (jsonNode.isObject()){
            Iterator<String> isobj = jsonNode.fieldNames();

            while (isobj.hasNext()){
                String fieldName = isobj.next();
                JsonNode fieldValue = jsonNode.get(fieldName);
                System.out.println(fieldValue.get("value"));
                getObj(fieldValue);
            }
        }
    }

    ArrayList<ArrayList<String>> s1=new ArrayList<>();
    ArrayList<String> arr=new ArrayList<String>();
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
    public void getdemo() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        ArrayList<String> arr2=new ArrayList<>();

        File file= jsonFile.getFile();
        JsonNode jsonNode=mapper.readTree(file);
//     System.out.println(jsonNode.fieldNames());
        Iterator<String> st=jsonNode.get("merchant").fieldNames();
        while(st.hasNext()){
            arr.add(st.next());
        }
int count= arr.size();
        s1.add(arr);


        int i=0;
       while(i!=count){
          String s= jsonNode.get("merchant").get(arr.get(i)).get("value").textValue();
            arr2.add(s);

            i++;
        }
       s1.add(arr2);
     System.out.println(s1);
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet=workbook.createSheet("status");
     int rows=s1.size();
     int columns=s1.get(0).size();
     for(int m=0;m<rows;m++){
         XSSFRow row=sheet.createRow(m);
         for(int p=0;p<columns;p++){
             XSSFCell cell=row.createCell(p);
             Object s3=s1.get(m).get(p);
             if(s3 instanceof String){
                 cell.setCellValue((String)s3);
             }
         }
     }
        FileOutputStream fo=new FileOutputStream("/Users/test/Downloads/status.xlsx");
        workbook.write(fo);
        fo.close();

//Iterator<String> st2=jsonNode.at("/"+arr.get(i)+"/value");
//StatusReview str=mapper.readValue(file, StatusReview.class);
//        String str=m.writerWithDefaultPrettyPrinter()
//                        .writeValueAsString(demoEntityPojo.getMerchantProfile());
//        System.out.println(str);
//if(demoEntityPojo.getMerchantProfile()==null){
//    System.out.println("Got You");
//}
//        System.out.println(demoEntityPojo.getMerchantProfile());

    }
    @GetMapping("/getexcel")
    public void getExcel() throws IOException {
        File file= excelFile.getFile();
        System.out.println(file.exists());

        FileInputStream inputStream=new FileInputStream(file);

        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);

        XSSFSheet sheet= workbook.getSheet("student");

        int rows=sheet.getLastRowNum();
        int columns=sheet.getRow(1).getLastCellNum();

        for(int i=0;i<rows;i++){
            XSSFRow row= sheet.getRow(i);
            for(int p=0;p<columns;p++){
                XSSFCell shet=row.getCell(p);
                switch(shet.getCellType()){
                    case STRING:
                        System.out.println(shet.getStringCellValue());
                        break;

                    case NUMERIC:
                        System.out.println(shet.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.println(shet.getBooleanCellValue());
                        break;
                    case _NONE:
                        System.out.println("NAN");
                        break;
                    case BLANK:
                        System.out.println("Doesn't have anything");
                        break;
                    default:
                        System.out.println("nothing");
                }
                System.out.println();
            }
        }
    }

    @GetMapping("/test")
    public void test() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        ArrayList<String> arr2=new ArrayList<>();

        File file= jsonFile.getFile();
        System.out.println(file.isFile());
        JsonNode jsonNode=mapper.readTree(file);
        System.out.println(jsonNode.get("merchantProfile").isObject());
//        getObj(jsonNode.get("merchantProfile"));
    }



}
