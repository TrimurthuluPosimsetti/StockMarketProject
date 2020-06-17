package com.mthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.dto.OrderDTO;
import com.mthree.services.SMServices;

@Controller
public class SMController {
	
	@Autowired
	private SMServices smservice;
	

	@GetMapping(path="/home")
	public String welcomePage() {
		return "index";
	}
	
	@GetMapping("/index")
	public List<OrderDTO> getOrderBook(){
		return smservice.getOrderBookService();	
	}

	
	@GetMapping("/validate")
	public String getCompleteOrderBook(@RequestParam("userid") int userId,@RequestParam("price") float price,@RequestParam("shares") int noofShares,@RequestParam("companyname") String companyName,@RequestParam("buyorsell") String buyOrSell,@RequestParam("tradername") String traderName){
		 
		 //System.out.println(userId+" "+price+" "+noofShares+" "+companyName+" "+buyOrSell+" "+obd.getTraderName());
		 smservice.getOrderCompleteBookService(userId,price,noofShares,companyName,buyOrSell,"auction",traderName);
		 ModelAndView mv=new ModelAndView();
		 return "redirect:/getOrders?userId="+String.valueOf(userId);
	}
	
	
}
