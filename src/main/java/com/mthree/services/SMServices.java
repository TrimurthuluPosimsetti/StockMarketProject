package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dto.OrderDTO;
import com.mthree.repository.SMRepository;

@Service
public class SMServices {
	
	@Autowired
	private SMRepository smrepo;
	
	public List<OrderDTO> getOrderBookService(){
		return smrepo.getOrderBookRepo();
	}

}
