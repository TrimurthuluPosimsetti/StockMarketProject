package com.mthree.classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mthree.dto.OrderDTO;
import com.mthree.models.OrdersDetails;
import com.mthree.repository.SMRepository;

class comp implements Comparator<OrderDTO>{
	
	public int compare(OrderDTO o1,OrderDTO o2) {
		return o1.getPrice() < o2.getPrice() ? -1 
			     : o1.getPrice() > o2.getPrice() ? 1 
			     : 0;
	}
	
}

@Component
public class Sort {
	
	@Autowired
	private SMRepository smrepo;

	public void executeTrade(OrdersDetails od,List<OrderDTO> odto){
		
		Collections.sort(odto,new comp());
		
		for(OrderDTO o:odto) {
			if(o.getPrice()==od.getPrice()&&o.getNoofShares()==od.getNoofShares()) {
				//smrepo.updateSellDetailsOfSeller(o.get,0,0,"sold");
				//break;
			}
		}
		
	}
	
}
