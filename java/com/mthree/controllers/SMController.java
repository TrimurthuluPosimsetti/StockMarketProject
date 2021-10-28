package com.mthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dto.AllOrdersDTO;
import com.mthree.dto.OrderDTO;
import com.mthree.models.OrdersDetails;
import com.mthree.services.SMServices;

@RestController
public class SMController {
	
	@Autowired
	private SMServices smservice;
	
	@GetMapping(path="/home")
	public String welcomePage() {
		return "welcome";
	}
	
	@RequestMapping("/index")
	public List<OrderDTO> getOrderBook(){
		return smservice.getOrderBookService();	
	}
	
	@RequestMapping("/validate")
	public List<OrderDTO> getCompleteOrderBook(@RequestBody OrdersDetails od){
		return smservice.getOrderCompleteBookService(od);
	}
	
	
	
	
}
