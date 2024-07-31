package com.bezkoder.spring.mssql.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
class OpenDataController {

   @GetMapping("/getOpenData")
   // @PostMapping("/getOpenData")
    public String getOpenData() {
        // 替换为实际的Open Data API 地址
    	//https://yc-note.com/python/pythonday7python-api/
    	//http://localhost:8080/getOpenData
        //String apiUrl = "https://jsonplaceholder.typicode.com/todos/1";
    	//String apiUrl = "https://opendata.tdcc.com.tw/getOD.ashx?id=1-5";
    	String apiUrl = "https://opendata.tdcc.com.tw/getOD.ashx?id=1-5";
        String apiUrl1 = "https://data.taipei/api/v1/dataset/36847f3f-deff-4183-a5bb-800737591de5?scope=resourceAquire";

        // 使用RestTemplate发送HTTP请求
        RestTemplate restTemplate = new RestTemplate();
        String responseData = restTemplate.getForObject(apiUrl, String.class);
        
        String SPACE_DELIMITER = "\n";
        String COMMA_DELIMITER = ",";
        String stk_id = null;
        String col = null;
        List<String> records = new ArrayList<String>();
        List<String> columns = new ArrayList<String>();
        List<String> filterrecords = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(responseData)) {
            rowScanner.useDelimiter(SPACE_DELIMITER);
            while (rowScanner.hasNext()) {
                records.add(rowScanner.next());
                //System.out.println("總共筆數: "+ records.size());
            }
        }
        for (int i = 0; i < records.size(); i++) {

            // Print all elements of List
        	System.out.println("第: "+i+ "筆" + records.get(i));
        	try (Scanner rowScanner = new Scanner(records.get(i))) {
                rowScanner.useDelimiter(COMMA_DELIMITER);
                
               // System.out.println("column data0:");
                while (rowScanner.hasNext()) {
                	col = rowScanner.next();
                	  //System.out.println("column data1:##"+ col+"###");
                	  if (col.equalsIgnoreCase("2330")) {
                		  System.out.println("got0 stk_id" + records.get(i));
                		  filterrecords.add(records.get(i));
                	  }
                    //columns.add(col);
                    
                }
            }
        	
        }
      System.out.println("filterrecords" + filterrecords);
      responseData=filterrecords.toString();

       /* 
        RestTemplate restTemplate1 = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate1.getForEntity(apiUrl, String.class);
        System.out.println("Headers: ");
        org.springframework.http.HttpHeaders headers = responseEntity.getHeaders();
        headers.forEach((name, values) -> {
            System.out.println(name + " = " + values);
        });
        */
        //資料日期,證券代號,持股分級,人數,股數,占集保庫存數比例%
       // responseData.filter(row -> row.length > columnIndex && row[columnIndex].equals(targetValue)).collect(Collectors.toList());
// 在实际应用中，你可能需要解析JSON数据并进行进一步处理
        // 这里只是简单地返回原始JSON响应
       // System.out.println(responseData);
        return responseData;
        
    }
}
