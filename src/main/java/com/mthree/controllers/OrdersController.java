package com.mthree.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mthree.dto.AllOrdersDTO;
import com.mthree.services.SMServices;

@Controller
public class OrdersController {

	@Autowired
	private SMServices smservice;
	
	@GetMapping(path="/getOrders")
	public String getOrdersHistory(HttpServletRequest request, @RequestParam int userId){
		List<AllOrdersDTO> aod=  smservice.getOrders(userId);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", aod);
		return "orderhistory";
	}
	
	@DeleteMapping(path="/deleteOrder")
	public String deleteOrder(HttpServletRequest request, @RequestParam int orderId, @RequestParam int userId) {
		String result = smservice.deleteOrder(orderId);
		if(result.equals("Deleted")) {
			
			List<AllOrdersDTO> aod=  smservice.getOrders(userId);
			HttpSession session = request.getSession();
			session.setAttribute("orderList", aod);
		}
		
		return "orderhistory";
		
	}

}
