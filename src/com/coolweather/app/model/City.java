package com.coolweather.app.model;

public class City {
	private int id;
	private String cityname;
	private String citycode;
	private int province_id;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getCityname(){
		return cityname;
	}
	
	public void setCityname(String cityname){
		this.cityname = cityname;
	}
	
	public String getCitycode(){
		return citycode;
	}
	
	public void setCitycode(String citycode){
		this.citycode = citycode;
	}
	
	public int getProvince_id(){
		return province_id;
	}
	
	public void setProvince_id(int province_id){
		this.province_id = province_id;
	}
}
