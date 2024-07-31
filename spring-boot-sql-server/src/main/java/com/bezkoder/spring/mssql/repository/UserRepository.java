package com.bezkoder.spring.mssql.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.mssql.model.TestUser;

public interface UserRepository  extends JpaRepository<TestUser, String> {
	List<TestUser> findByUserName(String username);
}


