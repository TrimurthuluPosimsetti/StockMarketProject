package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.mthree.classes.Sort;
import com.mthree.dto.AllOrdersDTO;
import com.mthree.dto.OrderDTO;
import com.mthree.dto.SorDTO;
import com.mthree.models.OrderBookDetails;
import com.mthree.models.OrdersDetails;
import com.mthree.repository.SMRepository;
import com.mthree.repository.SMRepositoryOBD;

@Service
public class SMServices {
	
	@Autowired
	private SMRepository smrepo;

	@Autowired 
	private SMRepositoryOBD smrepoOBD;
	
	
	@Autowired
	private Sort s;
	
	public List<OrderDTO> getOrderBookService(){
		return smrepo.getOrderBookRepo();
	}
	
	public String getOrderCompleteBookService(int userId, float price, int noofShares, String cn, String bs,String status, String tn){
		
		String redirectPageName=null;
		List<OrderDTO> odto=null;
		List<SorDTO> sdto=null;
		if(bs.equals("buy")) {
			bs="sell";
		}
		else {
			bs="buy";
		}
		
		if(tn.equals("sor")) {
			sdto=smrepo.getAllOrderCompleteBookRepository(cn,bs,"auction");
			if(bs.equals("buy")) {
				bs="sell";
			}
			else {
				bs="buy";
			}
			redirectPageName=s.marketOrder(userId,price,noofShares,cn,bs,"auction",tn,sdto,20,"homepage");//20% is the margin in market Order
		}
		else {
			//System.out.println("limit");
			odto=smrepo.getOrderCompleteBookRepository(tn,cn,bs,"auction");
			if(bs.equals("buy")) {
				bs="sell";
			}
			else {
				bs="buy";
			}
			OrderBookDetails obd=smrepoOBD.getOrderBookDetails(tn);
			OrdersDetails od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);
			redirectPageName=s.limitOrder(od, odto,od.getBuyOrSell(),"homepage");
			}
		//return smrepo.getOrderCompleteBookRepository();
		return redirectPageName;
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
