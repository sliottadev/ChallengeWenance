package com.winance.challenge.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BtcStateTimestamp {
	private Double lprice;
	private String curr1;
	private String curr2;
	private String timestamp;
	
	public BtcStateTimestamp() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		this.timestamp = formatter.format(new Date());
	}
	
	public Double getLprice() {
		return lprice;
	}
	public void setLprice(Double lprice) {
		this.lprice = lprice;
	}
	public String getCurr1() {
		return curr1;
	}
	public void setCurr1(String curr1) {
		this.curr1 = curr1;
	}
	public String getCurr2() {
		return curr2;
	}
	public void setCurr2(String curr2) {
		this.curr2 = curr2;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "BtcStateTimestamp [lprice=" + lprice + ", curr1=" + curr1 + ", curr2=" + curr2 + ", timestamp="
				+ timestamp + "]";
	}
	
}
