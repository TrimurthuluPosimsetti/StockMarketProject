package com.mthree.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class Exchanges {
	
	
	@Id
	@GeneratedValue
	private int exchangeId;
	private float feeLader;
	private float todayTradeValue;
	
	@Autowired
	@OneToMany(mappedBy="exchangeId")
	private List<OrderBookDetails> obd;
	
	Exchanges(){}

	public Exchanges(int exchangeId, float feeLader, float todayTradeValue, List<OrderBookDetails> obd) {
		super();
		this.exchangeId = exchangeId;
		this.feeLader = feeLader;
		this.todayTradeValue = todayTradeValue;
		this.obd = obd;
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	public float getFeeLader() {
		return feeLader;
	}

	public void setFeeLader(float feeLader) {
		this.feeLader = feeLader;
	}

	public float getTodayTradeValue() {
		return todayTradeValue;
	}

	public void setTodayTradeValue(float todayTradeValue) {
		this.todayTradeValue = todayTradeValue;
	}

	public List<OrderBookDetails> getObd() {
		return obd;
	}

	public void setObd(List<OrderBookDetails> obd) {
		this.obd = obd;
	}

	@Override
	public String toString() {
		return "Exchanges [exchangeId=" + exchangeId + ", feeLader=" + feeLader + ", todayTradeValue=" + todayTradeValue
				+ ", obd=" + obd + "]";
	}






}
