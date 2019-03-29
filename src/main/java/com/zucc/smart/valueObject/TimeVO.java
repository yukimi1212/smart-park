package com.zucc.smart.valueObject;

public class TimeVO {
	private String time;
	private int amount;
	
	public TimeVO(String time, int amount){
		this.time = time;
		this.amount = amount;
	}
	
	public TimeVO() {
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
