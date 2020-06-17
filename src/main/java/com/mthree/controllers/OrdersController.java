package com.mthree.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mthree.dto.AllOrdersDTO;
import com.mthree.services.SMServices;

@Controller
public class OrdersController {

	@Autowired
	private SMServices smservice;
	

	
	@GetMapping(path="/getOrders")
	public String getOrdersHistory(HttpServletRequest request, @RequestParam String userId){
		int uid=Integer.parseInt(userId);
		List<AllOrdersDTO> aod=  smservice.getOrders(uid);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", aod);
		return "orderhistory";
	}
	
	@PostMapping(path="/deleteOrder")
	public String deleteOrder(HttpServletRequest request) {
//		String pressdel = request.getParameter("deleteOrder");
		HttpSession session = request.getSession();
		String orderId = request.getParameter("deleteOrder");
		int userId = (int) session.getAttribute("userId");
		String result = smservice.deleteOrder(Integer.parseInt(orderId));
		if(result.equals("Deleted")) {
			List<AllOrdersDTO> aod=  smservice.getOrders(userId);
			session.setAttribute("orderList", aod);
		}
		
		return "orderhistory";
		
		
		
		
		
	}

}