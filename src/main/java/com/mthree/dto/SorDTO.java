package com.mthree.dto;

public class SorDTO {

	private int orderId;
	private int userId;
	private float price;
	private int noofShares;
	private String companyName;
	private String buyOrSell;
	private String traderName;
	
	SorDTO(){}

	public SorDTO(int orderId, int userId, float price, int noofShares, String companyName, String buyOrSell,
			String traderName) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.price = price;
		this.noofShares = noofShares;
		this.companyName = companyName;
		this.buyOrSell = buyOrSell;
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

	public String getTraderName() {
		return traderName;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	@Override
	public String toString() {
		return "SorDTO [orderId=" + orderId + ", userId=" + userId + ", price=" + price + ", noofShares=" + noofShares
				+ ", companyName=" + companyName + ", buyOrSell=" + buyOrSell + ", traderName=" + traderName + "]";
	}	
	
	
}

