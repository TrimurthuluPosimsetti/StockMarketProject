package com.mthree.classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mthree.dto.OrderDTO;
import com.mthree.dto.SorDTO;
import com.mthree.models.OrderBookDetails;
import com.mthree.models.OrdersDetails;
import com.mthree.repository.SMRepository;
import com.mthree.repository.SMRepositoryOBD;

class comp implements Comparator<OrderDTO>{
	
	public int compare(OrderDTO o1,OrderDTO o2) {
		return o1.getPrice() < o2.getPrice() ? -1 
			     : o1.getPrice() > o2.getPrice() ? 1 
			     : 0;
	}
	
}

class comp2 implements Comparator<SorDTO>{
	
	public int compare(SorDTO o1,SorDTO o2) {
		return o1.getPrice() < o2.getPrice() ? -1 
			     : o1.getPrice() > o2.getPrice() ? 1 
			     : 0;
	}
	
}

@Component
public class Sort {
	
	@Autowired
	private SMRepository smrepo;
	
	@Autowired 
	private SMRepositoryOBD smrepoOBD;
	
	public void marketOrder(int userId, float price, int noofShares, String cn, String bs, String status,String tn,List<SorDTO> odto,float margin) {
		
		Collections.sort(odto,new comp2());
		
		int flag=0;
		
		if(bs.equals("buy")) {
			
			
			for(SorDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()<=price/noofShares || o.getPrice()/o.getNoofShares()<=price+(price*margin/100)/noofShares) {
					
					flag=1;
					OrderBookDetails obd=smrepoOBD.getOrderBookDetails(o.getTraderName());
					OrdersDetails od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),0,o.getPrice(),"sold");
						od.setPrice(od.getPrice());
						od.setStatus("owned");
						od=smrepo.save(od);
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-(o.getPrice()/o.getNoofShares())*od.getNoofShares(),"auction");
						od.setPrice((o.getPrice()/o.getNoofShares())*od.getNoofShares());		
						od.setStatus("owned");
						OrdersDetails abc=smrepo.save(od);
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"sell","sold",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),0,o.getPrice(),"sold");
						OrdersDetails abc=smrepo.save(od);
						i=smrepo.updateBuyDetailsOfBuyer(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),o.getPrice(),o.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"owned",od.getTraderName()));
					}
					
				}
				
			}
			
			
		}
		else {
			//selling
			for(SorDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()>=price/noofShares || o.getPrice()/o.getNoofShares()>=(price-price*20/100)/noofShares) {
					
					flag=1;
					OrderBookDetails obd=smrepoOBD.getOrderBookDetails(o.getTraderName());
					OrdersDetails od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),o.getPrice(),"owned");
						od.setPrice(o.getPrice());
						od.setStatus("sold");
						od=smrepo.save(od);
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-od.getPrice(),"auction");		
						od.setStatus("sold");
						OrdersDetails abc=smrepo.save(od);
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"buy","owned",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),(od.getPrice()/od.getNoofShares())*o.getNoofShares(),"owned");
						OrdersDetails abc=smrepo.save(od);
						i=smrepo.updateSellDetailsOfSeller(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice()-(od.getPrice()/od.getNoofShares())*o.getNoofShares(),od.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"sold",od.getTraderName()));
					}
					
				}
				
			}
			
		}
		
		if(flag==0) {
			OrderBookDetails obd=smrepoOBD.getOrderBookDetails("nyse");
			OrdersDetails od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);
			smrepo.save(od);
		}
		
		
		
	}

	public void limitOrder(OrdersDetails od,List<OrderDTO> odto,String bors){
		
		
		Collections.sort(odto,new comp());
		int flag=0;
		
		if(bors.equals("buy")) {
		
			
			
			for(OrderDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()<=od.getPrice()/od.getNoofShares()) {
					
					flag=1;
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),0,o.getPrice(),"sold");
						od.setStatus("owned");
						od=smrepo.save(od);
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-(o.getPrice()/o.getNoofShares())*od.getNoofShares(),"auction");
						od.setPrice((o.getPrice()/o.getNoofShares())*od.getNoofShares());		
						od.setStatus("owned");
						OrdersDetails abc=smrepo.save(od);
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"sell","sold",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),0,o.getPrice(),"sold");
						OrdersDetails abc=smrepo.save(od);
						i=smrepo.updateBuyDetailsOfBuyer(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),o.getPrice(),o.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"owned",od.getTraderName()));
					}
					
				}
				
			}
			
			
		}
		else {
			//selling
			for(OrderDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()>=od.getPrice()/od.getNoofShares()) {
					flag=1;
					//System.out.println(o.getNoofShares()+" "+od.getNoofShares());
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),od.getPrice(),"owned");
						od.setStatus("sold");
						od=smrepo.save(od);
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-od.getPrice(),"auction");		
						od.setStatus("sold");
						OrdersDetails abc=smrepo.save(od);
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"buy","owned",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),(od.getPrice()/od.getNoofShares())*o.getNoofShares(),"owned");
						OrdersDetails abc=smrepo.save(od);
						i=smrepo.updateSellDetailsOfSeller(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						od=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice()-(od.getPrice()/od.getNoofShares())*o.getNoofShares(),od.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"sold",od.getTraderName()));
					}
					
				}
				
			}
			
		}
		
		if(flag==0) {
			smrepo.save(od);
		}
		
	}
	
}
