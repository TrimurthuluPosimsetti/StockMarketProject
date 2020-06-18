package com.mthree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mthree.controllers.SMController;
import com.mthree.users.UserService;

class SignUpTesting {

	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private SMController uc;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
//		System.out.println("hello");
//		System.out.println(uc.welcomePage());

	}

}
