package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.classes.Sort;
import com.mthree.dto.AllOrdersDTO;
import com.mthree.dto.OrderDTO;
import com.mthree.dto.SorDTO;
import com.mthree.models.OrderBookDetails;
import com.mthree.models.OrdersDetails;
import com.mthree.repository.SMRepository;

@Service
public class SMServices {
	
	@Autowired
	private SMRepository smrepo;

	
	@Autowired
	private Sort s;
	
	public List<OrderDTO> getOrderBookService(){
		return smrepo.getOrderBookRepo();
	}
	
	public List<OrderDTO> getOrderCompleteBookService(OrdersDetails od){
		
		List<OrderDTO> odto=null;
		List<SorDTO> sdto=null;
		OrderBookDetails obd=od.getTraderName();
		String tn=obd.getTraderName();
		String cn=od.getCompanyName();
		String bs=od.getBuyOrSell();
		if(bs.equals("buy")) {
			bs="sell";
		}
		else {
			bs="buy";
		}
		
		if(tn.equals("sor")) {
			sdto=smrepo.getAllOrderCompleteBookRepository(cn,bs,"auction");
			s.marketOrder(od, sdto,od.getBuyOrSell(),20);//20% is the margin in market Order
		}
		else {
			odto=smrepo.getOrderCompleteBookRepository(tn,cn,bs,"auction");
			s.limitOrder(od, odto,od.getBuyOrSell());
			}
		return odto;
		//return smrepo.getOrderCompleteBookRepository();
	}
	
	public List<AllOrdersDTO> getOrders(int userId){
		return smrepo.getOrdersHistory(userId);
	}
	
	public String deleteOrder(int orderId) {
		String returnResult = "Deleted"; 
		try {
			smrepo.deleteById(orderId);
		}
		catch(Exception e) {
			returnResult = "Delete Failed";
		}

		return returnResult;
	}

}
