package com.mthree.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.users.*;

@Controller
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	public String signup(@RequestBody UserSignupDto user) {
		
		
		UserInfo newUser = userService.signupUser(user);
		
		if(newUser!=null) {
			return "redirect:/login";
		}
		else {
			return "signup";
		}

		
	}
	
	
	@RequestMapping("/login")	
	public String login(@RequestBody UserLoginDto userLoginDto) {
		
		String login =  userService.loginUser(userLoginDto);
		
		if (login != null) {
			return "redirect:/homepage";
//			return new ModelAndView("homepage");
		}
		else {
			return "login";
		}
	
	}

}
