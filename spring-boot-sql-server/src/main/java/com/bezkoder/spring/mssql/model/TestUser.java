package com.bezkoder.spring.mssql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testuser")

public class TestUser {
	
	public TestUser() {

	}
	
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String passWord;
	
	
	public long getId() {
	    return id;
	}
	
	public String getUsername() {
	    return userName;
	}
	
	public String getPassword() {
	    return passWord;
	}
	
	public void setUsername(String username) {
	    this.userName= username;
	}
	
	public void setPassword(String password) {
	    this.passWord= password;
	}
	
	public TestUser(String username, String password,long id) {
		this.id = id;
	    this.userName = username;
	    this.passWord = password;
	    
	}
	public TestUser(String username, String password) {
		this.userName = username;
	    this.passWord = password;
	    
	}
}


