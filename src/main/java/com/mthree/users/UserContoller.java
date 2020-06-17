package com.mthree.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public String signup(@RequestParam("email") String username,@RequestParam("password") String password,@RequestParam("cpassword") String cpassword) {
		
		UserSignupDto user=new UserSignupDto(username,password,cpassword);
		
		UserInfo newUser = userService.signupUser(user);
		
		if(newUser!=null) {
			return "redirect:/index";
		}
		else {
			return "signup";
		}

		
	}
	
	
	@PostMapping("/login")	
	public String login(HttpServletRequest request,@RequestParam("email") String username,@RequestParam("password") String password) {
		
		UserLoginDto udto=new UserLoginDto(username,password);
		String login =  userService.loginUser(udto);
		
		
		
		if (login == "logged in!") {
			HttpSession session=request.getSession(true);
			session.setAttribute("userId",userRepository.getId(username));
			System.out.println(session.getAttribute("userId"));
			return "redirect:/homepage.jsp";
//			return new ModelAndView("homepage");
		}
		else {
			return "index";
		}
	
	}

}
