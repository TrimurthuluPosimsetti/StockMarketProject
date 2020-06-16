package com.mthree.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.users.UserInfo;


@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer>{
	
	UserInfo findByUserName(String userName);

}
