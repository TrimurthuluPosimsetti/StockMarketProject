package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class OrdersDetails {
	@Id
	@GeneratedValue
	private int userId;
	private float price;
	private int noofShares;
	private String companyName;
	private String buyOrSell;
	@Autowired
	@ManyToOne
	@JoinColumn(name="trader_name")
	private OrderBookDetails traderName;
	
	OrdersDetails(){}

	public OrdersDetails(int userId, float price, int noofShares, String companyName, String buyOrSell,
			OrderBookDetails traderName) {
		super();
		this.userId = userId;
		this.price = price;
		this.noofShares = noofShares;
		this.companyName = companyName;
		this.buyOrSell = buyOrSell;
		this.traderName = traderName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNoofShares() {
		return noofShares;
	}

	public void setNoofShares(int noofShares) {
		this.noofShares = noofShares;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBuyOrSell() {
		return buyOrSell;
	}

	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	public OrderBookDetails getTraderName() {
		return traderName;
	}

	public void setTraderName(OrderBookDetails traderName) {
		this.traderName = traderName;
	}

	@Override
	public String toString() {
		return "Orders [userId=" + userId + ", price=" + price + ", noofShares=" + noofShares + ", companyName="
				+ companyName + ", buyOrSell=" + buyOrSell + ", traderName="
				+ traderName + "]";
	}

	

	
		
	
	
}
