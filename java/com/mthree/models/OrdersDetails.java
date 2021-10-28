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
	private int orderId;
	private int userId;
	private float price;
	private int noofShares;
	private String companyName;
	private String buyOrSell;
	private String status;
	@Autowired
	@ManyToOne
	@JoinColumn(name="trader_name")
	private OrderBookDetails traderName;
	
	OrdersDetails(){}

	public OrdersDetails(int orderId, int userId, float price, int noofShares, String companyName, String buyOrSell,
			String status, OrderBookDetails traderName) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.price = price;
		this.noofShares = noofShares;
		this.companyName = companyName;
		this.buyOrSell = buyOrSell;
		this.status = status;
		this.traderName = traderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderBookDetails getTraderName() {
		return traderName;
	}

	public void setTraderName(OrderBookDetails traderName) {
		this.traderName = traderName;
	}

	@Override
	public String toString() {
		return "OrdersDetails [orderId=" + orderId + ", userId=" + userId + ", price=" + price + ", noofShares="
				+ noofShares + ", companyName=" + companyName + ", buyOrSell=" + buyOrSell + ", status=" + status
				+ ", traderName=" + traderName + "]";
	}

	
	
	
	
}
