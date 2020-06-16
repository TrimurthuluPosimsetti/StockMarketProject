package com.mthree.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.users.UserRepository;
import com.mthree.users.UserInfo; 

@Service
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	public UserInfo signupUser(UserSignupDto userSignupDto) {
		UserInfo newUser = new UserInfo();
		
		UserInfo user = userRepository.findByUserName(userSignupDto.getUserName());
		
		if(user != null) {
            throw new RuntimeException("User already exists!");
        }
		
		if(!userSignupDto.getPassword().equals(userSignupDto.getPasswordConfirm())) {
			throw new RuntimeException("Password does not match.");
		}
		
		newUser.setUserName(userSignupDto.getUserName());
		newUser.setPassword(userSignupDto.getPassword());
		userRepository.save(newUser);
		return newUser;
	}
	
	
	public String loginUser(UserLoginDto userLoginDto) {
		
		
		UserInfo user = userRepository.findByUserName(userLoginDto.getUserName());
		
		if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(userLoginDto.getPassword())){
            throw new RuntimeException("Wrong password!");
        }
        
        return "logged in!";
		
	}
	

}
