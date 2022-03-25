package com.winance.challenge.dtos;

public class BtcTimestampSummary {
	private String date1;
	private Double price1;
	private String date2;
	private Double price2;
	private Double averange;
	private Double maxPrice;
	private Double percentWithMax;

	public Double getPrice1() {
		return price1;
	}
	public void setPrice1(Double price1) {
		this.price1 = price1;
	}
	public Double getPrice2() {
		return price2;
	}
	public void setPrice2(Double price2) {
		this.price2 = price2;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public Double getAverange() {
		return averange;
	}
	public void setAverange(Double averange) {
		this.averange = averange;
	}
	public Double getPercentWithMax() {
		return percentWithMax;
	}
	public void setPercentWithMax(Double percentWithMax) {
		this.percentWithMax = percentWithMax;
	}
	
}
