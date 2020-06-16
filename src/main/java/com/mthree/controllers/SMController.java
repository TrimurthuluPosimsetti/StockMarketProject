package com.mthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.dto.AllOrdersDTO;
import com.mthree.dto.OrderDTO;
import com.mthree.models.OrdersDetails;
import com.mthree.services.SMServices;

@Controller
public class SMController {
	
	@Autowired
	private SMServices smservice;
	
	@GetMapping(path="/home")
	public String welcomePage() {
		return "homepage";
	}
	
	@GetMapping("/index")
	public List<OrderDTO> getOrderBook(){
		return smservice.getOrderBookService();	
	}

	
	@GetMapping("/validate")
	public ModelAndView getCompleteOrderBook(@RequestBody OrdersDetails od){
		 smservice.getOrderCompleteBookService(od);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("orderHistory");
		 return mv;
	}
	
	
}
