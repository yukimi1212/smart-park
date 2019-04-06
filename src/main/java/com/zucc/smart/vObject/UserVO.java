package com.zucc.smart.vObject;

public class UserVO {
	private String user_id;
	private String user_name;
	private String user_gender;
    private int user_age;
    private String user_phone;
	private String registration_time;
	private int vehicle_num;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getRegistration_time() {
		return registration_time;
	}
	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}
	public int getVehicle_num() {
		return vehicle_num;
	}
	public void setVehicle_num(int vehicle_num) {
		this.vehicle_num = vehicle_num;
	}
}
