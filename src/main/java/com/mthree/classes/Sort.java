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
	
	public String marketOrder(int userId, float price, int noofShares, String cn, String bs, String status,String tn,List<SorDTO> odto,float margin,String redirectPageName) {
		
		Collections.sort(odto,new comp2());
		
		int flag=0;
		
		OrdersDetails od=null;
		
		if(bs.equals("buy")) {
			
			
			for(SorDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()<=price/noofShares || o.getPrice()/o.getNoofShares()<=price+(price*margin/100)/noofShares) {
					
					if(flag==0) {
						System.out.println("flag"+flag);
					OrderBookDetails obd=smrepoOBD.getOrderBookDetails(o.getTraderName());
					od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);
					}
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares(),o.getPrice(),"sold");
						od.setPrice(od.getPrice());
						od.setStatus("owned");
						if(flag!=1) {
							OrdersDetails abc=smrepo.save(od);}
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-(o.getPrice()/o.getNoofShares())*od.getNoofShares(),"auction");
						od.setPrice((o.getPrice()/o.getNoofShares())*od.getNoofShares());		
						od.setStatus("owned");
						if(flag!=1) {
							OrdersDetails abc=smrepo.save(od);}
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"sell","sold",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares(),o.getPrice(),"sold");
						od.setNoofShares(od.getNoofShares()-o.getNoofShares());
						od.setPrice(od.getPrice()-o.getPrice());
						od.setStatus("auction");
						if(flag!=1) {
							od=smrepo.save(od);}
						System.out.println("order"+od.getOrderId()+" "+od.getNoofShares()+" "+od.getPrice());
						//i=smrepo.updateBuyDetailsOfBuyer(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),o.getPrice(),o.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"owned",od.getTraderName()));
					}
					flag=1;
					
				}
				
			}
			
			
		}
		else {
			//selling
			for(SorDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()>=price/noofShares || o.getPrice()/o.getNoofShares()>=(price-price*20/100)/noofShares) {
					
					if(flag==0) {
					OrderBookDetails obd=smrepoOBD.getOrderBookDetails(o.getTraderName());
					od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);}
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),o.getPrice(),"owned");
						od.setPrice(o.getPrice());
						od.setStatus("sold");
						if(flag!=1) {
							OrdersDetails abc=smrepo.save(od);}
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-od.getPrice(),"auction");		
						od.setStatus("sold");
						if(flag!=1) {
							OrdersDetails abc=smrepo.save(od);}
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"buy","owned",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),(od.getPrice()/od.getNoofShares())*o.getNoofShares(),"owned");
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice()-(od.getPrice()/od.getNoofShares())*o.getNoofShares(),od.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"sold",od.getTraderName()));
						od.setNoofShares(od.getNoofShares()-o.getNoofShares());
						od.setPrice(od.getPrice()-o.getPrice());
						od.setStatus("auction");
						if(flag!=1) {
							od=smrepo.save(od);}
						//i=smrepo.updateSellDetailsOfSeller(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						
					}
					flag=1;
					
				}
				
			}
			
		}
		
		if(flag==0) {
			OrderBookDetails obd=smrepoOBD.getOrderBookDetails("nyse");
			od=new OrdersDetails(1,userId,price,noofShares,cn,bs,"auction",obd);
			smrepo.save(od);
			return redirectPageName+"nodeal";
		}
		else {
			return redirectPageName+"deal";
		}

		
		
		
	}

	public String limitOrder(OrdersDetails od,List<OrderDTO> odto,String bors,String redirectPageName){
		
		
		Collections.sort(odto,new comp());
		int flag=0;
		
		if(bors.equals("buy")) {
		
			
			
			for(OrderDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()<=od.getPrice()/od.getNoofShares()) {
					
					
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares(),o.getPrice(),"sold");
						od.setStatus("owned");
						if(flag!=1) {
						od=smrepo.save(od);}
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-(o.getPrice()/o.getNoofShares())*od.getNoofShares(),"auction");
						od.setPrice((o.getPrice()/o.getNoofShares())*od.getNoofShares());		
						od.setStatus("owned");
						if(flag!=1) {
							od=smrepo.save(od);}
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"sell","sold",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateSellDetailsOfSeller(o.getOrderId(),o.getNoofShares(),o.getPrice(),"sold");
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),o.getPrice(),o.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"owned",od.getTraderName()));
						od.setNoofShares(od.getNoofShares()-o.getNoofShares());
						od.setPrice(od.getPrice()-o.getPrice());
						od.setStatus("auction");
						if(flag!=1) {
							od=smrepo.save(od);}
						//i=smrepo.updateBuyDetailsOfBuyer(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						
					}
					flag=1;
					
				}
				
			}
			
			
		}
		else {
			//selling
			for(OrderDTO o:odto) {
				
				int i=0;
				
				//when shares price per share same for both buyer and seller
				if(o.getPrice()/o.getNoofShares()>=od.getPrice()/od.getNoofShares()) {
					
					//System.out.println(o.getNoofShares()+" "+od.getNoofShares());
					if(o.getNoofShares()==od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),od.getPrice(),"owned");
						od.setStatus("sold");
						if(flag!=1) {
							od=smrepo.save(od);}
						break;
					}
					else if(o.getNoofShares()>od.getNoofShares()) {
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares()-od.getNoofShares(),o.getPrice()-od.getPrice(),"auction");		
						od.setStatus("sold");
						if(flag!=1) {
							od=smrepo.save(od);}
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice(),od.getNoofShares(),od.getCompanyName(),"buy","owned",od.getTraderName()));
					}
					else if(o.getNoofShares()<od.getNoofShares()){
						i=smrepo.updateBuyDetailsOfBuyer(o.getOrderId(),o.getNoofShares(),(od.getPrice()/od.getNoofShares())*o.getNoofShares(),"owned");
						OrdersDetails abc=smrepo.save(new OrdersDetails(111,od.getUserId(),od.getPrice()-(od.getPrice()/od.getNoofShares())*o.getNoofShares(),od.getNoofShares(),od.getCompanyName(),od.getBuyOrSell(),"sold",od.getTraderName()));
						od.setNoofShares(od.getNoofShares()-o.getNoofShares());
						od.setPrice(od.getPrice()-o.getPrice());
						od.setStatus("auction");
						if(flag!=1) {
							od=smrepo.save(od);}
						//i=smrepo.updateSellDetailsOfSeller(od.getOrderId(),od.getNoofShares()-o.getNoofShares(), od.getPrice()-o.getPrice(), "auction");
						
					}
					flag=1;
					
				}
				
			}
			
		}
		
		if(flag==0) {
			smrepo.save(od);
			return redirectPageName+"nodeal";
		}
		else {
			return redirectPageName+"deal";
		}
		
	}
	
}
