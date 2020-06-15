package com.mthree.dto;

public class OrderDTO {

	private int userId;
	private float price;
	private int noofShares;
	private String companyName;
	private String buyOrSell;
	
	OrderDTO(){}
	
	public OrderDTO(int userId, float price, int noofShares, String companyName, String buyOrSell) {
		super();
		this.userId = userId;
		this.price = price;
		this.noofShares = noofShares;
		this.companyName = companyName;
		this.buyOrSell = buyOrSell;
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

	@Override
	public String toString() {
		return "OrderDTO [userId=" + userId + ", price=" + price + ", noofShares=" + noofShares + ", companyName="
				+ companyName + ", buyOrSell=" + buyOrSell + "]";
	}
	
	
	
}
