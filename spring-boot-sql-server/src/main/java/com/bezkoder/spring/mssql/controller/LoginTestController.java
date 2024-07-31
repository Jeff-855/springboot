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
import com.bezkoder.spring.mssql.model.Tutorial;
import com.bezkoder.spring.mssql.model.TestUser;
import com.bezkoder.spring.mssql.repository.TutorialRepository;
import com.bezkoder.spring.mssql.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginTestController {
	@Autowired
	UserRepository userRepository;
	@GetMapping("/loginTest")
	//@GetMapping("/loginTest/{username}")
	
	public ResponseEntity<TestUser> findUserByName(@RequestParam String  username) {
		System.out.println("test userName:"+username);
		TestUser userData =userRepository.findByUserName(username).get(0);
		if (userData != null ) {
			System.out.println("test userName find:"+username);
			return new ResponseEntity<>(userData, HttpStatus.OK);
		} else {
			System.out.println("test userName not find:"+username);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/loginTests")
	public ResponseEntity<TestUser> createTestuser(@RequestBody TestUser testUser) {
		try {
			System.out.println("test user:id is "+testUser.getId()+"|testuser is :"+testUser.getUsername()+"|pwd is :"+testUser.getPassword());
			//TestUser _testUser = userRepository.save(new TestUser(testUser.getUsername(), testUser.getPassword(),testUser.getId() ));
			TestUser _testUser = userRepository.save(new TestUser(testUser.getUsername(), testUser.getPassword() ));

					
			return new ResponseEntity<>(_testUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}

