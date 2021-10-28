package com.mthree.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class OrderBookDetails {
	
	@Id
	private String traderName;//either nyse or bse
	@Autowired
	@OneToMany(mappedBy="traderName")
	private List<OrdersDetails> order;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="exchange_id")
	private Exchanges exchangeId;
	
	
	public OrderBookDetails() {
	}


	public OrderBookDetails(String traderName, List<OrdersDetails> order, Exchanges exchangeId) {
		super();
		this.traderName = traderName;
		this.order = order;
		this.exchangeId = exchangeId;
	}


	public String getTraderName() {
		return traderName;
	}


	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}


	public List<OrdersDetails> getOrder() {
		return order;
	}


	public void setOrder(List<OrdersDetails> order) {
		this.order = order;
	}


	public Exchanges getExchange() {
		return exchangeId;
	}


	public void setExchange(Exchanges exchangeId) {
		this.exchangeId = exchangeId;
	}


	@Override
	public String toString() {
		return "OrderBookDetails [traderName=" + traderName + ", order=" + order + ", exchangeId=" + exchangeId + "]";
	}


	
}
