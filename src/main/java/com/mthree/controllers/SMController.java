package com.mthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.dto.OrderDTO;
import com.mthree.models.OrderBookDetails;
import com.mthree.models.OrdersDetails;
import com.mthree.repository.SMRepositoryOBD;
import com.mthree.services.SMServices;

@Controller
public class SMController {
	
	@Autowired
	private SMServices smservice;
	
	@Autowired 
	private SMRepositoryOBD smrepoOBD;
	
	@GetMapping(path="/home")
	public String welcomePage() {
		return "NewOrder";
	}
	
	@GetMapping("/index")
	public List<OrderDTO> getOrderBook(){
		return smservice.getOrderBookService();	
	}

	
	@GetMapping("/validate")
	public ModelAndView getCompleteOrderBook(@RequestParam("userid") int userId,@RequestParam("price") float price,@RequestParam("shares") int noofShares,@RequestParam("companyname") String companyName,@RequestParam("buyorsell") String buyOrSell,@RequestParam("tradername") String traderName){
		 
		 OrderBookDetails obd=smrepoOBD.getOrderBookDetails(traderName);
		 OrdersDetails od=new OrdersDetails(1,userId,price,noofShares,companyName,buyOrSell,"auction",obd);
		 smservice.getOrderCompleteBookService(od);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("orderHistory");
		 return mv;
	}
	
	
}
