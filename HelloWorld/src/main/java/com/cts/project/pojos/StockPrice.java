package com.cts.project.pojos;

import java.sql.Time;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity

@Table(name = "stockprice")

public class StockPrice {

	@Id
	private String companynamef;
	private String stockexchangef;
	private String currentprice;
	private Date date;
	private Time time;
	
	@Override

	public String toString() {

		return "StockPrice [companynamef=" + companynamef + ", stockexchangef=" + stockexchangef + ", currentprice="

				+ currentprice + ", date=" + date + ", time=" + time + "]";

	}

	public String getCompanynamef() {

		return companynamef;

	}

	public void setCompanynamef(String companynamef) {

		this.companynamef = companynamef;

	}

	public String getStockexchangef() {

		return stockexchangef;

	}

	public void setStockexchangef(String stockexchangef) {

		this.stockexchangef = stockexchangef;

	}

	public String getCurrentprice() {

		return currentprice;

	}

	public void setCurrentprice(String currentprice) {

		this.currentprice = currentprice;

	}

	public Date getDate() {

		return date;

	}

	public void setDate(Date date) {

		this.date = date;

	}

	public Time getTime() {

		return time;

	}

	public void setTime(Time time) {

		this.time = time;

	}

}
