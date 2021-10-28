package com.mthree.dto;

public class AllOrdersDTO {

	private int orderId;
	private int userId;
	private float price;
	private int noofShares;
	private String companyName;
	private String buyOrSell;
	private String status;
	
	
	public AllOrdersDTO(int orderId, int userId, float price, int noofShares, String companyName, String buyOrSell,
			String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.price = price;
		this.noofShares = noofShares;
		this.companyName = companyName;
		this.buyOrSell = buyOrSell;
		this.status = status;
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



	@Override
	public String toString() {
		return "AllOrdersDTO [orderId=" + orderId + ", userId=" + userId + ", price=" + price + ", noofShares="
				+ noofShares + ", companyName=" + companyName + ", buyOrSell=" + buyOrSell + ", status=" + status + "]";
	}
	
	
	
}