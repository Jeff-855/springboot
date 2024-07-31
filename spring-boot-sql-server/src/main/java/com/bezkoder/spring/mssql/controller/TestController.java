package com.bezkoder.spring.mssql.controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.action.*;


@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TestController {

			
	@PostMapping("/test")
	public int guessNum(@RequestBody RequestPOJO request) throws IOException {
		    int retryCnt = request.getRetryCnt();
		    int digital1 = request.getDigital1();
		    int digital2 = request.getDigital2();
		    int digital3 = request.getDigital3();
		 
		    System.out.println("test post:digtial1 is "+digital1);
		    System.out.println("test post:digtial2 is "+digital2);
		    System.out.println("test post:digtial3 is "+digital3);
		    List<Integer> al=new ArrayList<>();	
		    
		    guessNum gNum = new guessNum();
		    al = gNum.generateAnswer(retryCnt);
		    
		    int result = gNum.compareAnswer(al,digital1,digital2,digital3);
		    
		    
		    System.out.println("test post:resultNum is "+result);
		    
			
			
			if (HttpStatus.OK != null) {					    
				System.out.println("test post:2Num is "+result);
			    return result;
			}else {
				System.out.println("test post:3Num is "+result);
				return result;
			}
			
			
	}


	
}