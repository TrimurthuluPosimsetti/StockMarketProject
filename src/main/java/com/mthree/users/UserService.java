package com.mthree.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Service
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	public UserInfo signupUser(UserSignupDto userSignupDto) {
		System.out.println("working");
		UserInfo newUser = new UserInfo();
		
		UserInfo user = userRepository.findByUserName(userSignupDto.getUserName());
		
		if(user != null) {
			System.out.println("UserName already exists!");
            return null;
        }
		
		if(!userSignupDto.getPassword().equals(userSignupDto.getPasswordConfirm())) {
			System.out.println("Password and Confirm Password does not match.");
			return null;
		}
		
		newUser.setUserName(userSignupDto.getUserName());
		newUser.setPassword(userSignupDto.getPassword());
		userRepository.save(newUser);
		return newUser;
	}
	
	
	public String loginUser(UserLoginDto userLoginDto) {
		System.out.println("Workign");
		
		UserInfo user = userRepository.findByUserName(userLoginDto.getUserName());
		
		if(user == null) {
			System.out.println("User does not exist.");
            return null;
        }
        if(!user.getPassword().equals(userLoginDto.getPassword())){
			System.out.println("Wrong Password!!!");
			return null;
        }
        
        return "logged in!";
		
	}
	

}
