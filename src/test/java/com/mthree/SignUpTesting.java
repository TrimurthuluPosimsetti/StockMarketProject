package com.mthree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.mthree.users.UserLoginDto;
import com.mthree.users.UserService;

class SignUpTesting {

	@Mock
	private UserService userService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//assertEquals("maya",userService.signupUser(new UserSignupDto("maya","123","123")).getUserName());
		//assertEquals("123",userService.signupUser(new UserSignupDto("ammu","123","123")).getPassword());
//		System.out.println("Hello");
//		UserSignupDto user=new UserSignupDto("amm","dao","dao");
//		UserInfo newUser = userService.signupUser(user);
//		UserLoginDto udto=new UserLoginDto("ammu","ammu");
//		System.out.println("Hello");
//		String login =  userService.loginUser(udto);
		//assertEquals(null,userService.signupUser(new UserSignupDto("amm","12","123")));
	}

}
