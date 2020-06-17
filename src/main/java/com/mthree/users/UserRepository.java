package com.mthree.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer>{
	
	UserInfo findByUserName(String userName);
	
	@Query("select userId from UserInfo where userName=:uname")
	int getId(@Param("uname") String userName);

}
