package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.classes.Sort;
import com.mthree.dto.OrderDTO;
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
		List<OrderDTO> odto=smrepo.getOrderCompleteBookRepository(tn,cn,bs);
		s.executeTrade(od, odto);
		return odto;
		//return smrepo.getOrderCompleteBookRepository();
	}

}
