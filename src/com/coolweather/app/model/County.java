package com.coolweather.app.model;

public class County {
	private int id;
	private String countyname;
	private String countycode;
	private int city_id;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getCountyname(){
		return countyname;
	}
	
	public void setCountyname(String countyname){
		this.countyname = countyname;
	}
	
	public String getCountycode(){
		return countycode;
	}
	
	public void setCountycode(String countycode){
		this.countycode = countycode;
	}
	
	public int getCity_id(){
		return city_id;
	}
	
	public void setCity_id(int city_id){
		this.city_id = city_id;
	}
}
