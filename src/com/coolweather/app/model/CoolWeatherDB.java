package com.coolweather.app.model;

import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.db.CoolWeatherOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {
	public static final String DB_NAME = "cool_weater";
	public static final int VERSION = 1;
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;
	
	private CoolWeatherDB(Context context){
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	public synchronized static CoolWeatherDB getInstance(Context context){
		if(coolWeatherDB == null){
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	
	public void saveProvince(Province province){
		if(province!=null){
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvincename());
			values.put("province_code", province.getProvincecode());
			db.insert("Province", null, values);
		}
	}
	
	public List<Province> loadProvinces(){
		List<Province> list = new ArrayList<Province>();
		Cursor cursor =  db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvincename(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvincecode(cursor.getString(cursor.getColumnIndex("province_code")));
				list.add(province);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	public void saveCity(City city){
		if(city!=null){
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityname());
			values.put("city_code", city.getCitycode());
			values.put("province_id", city.getProvince_id());
			db.insert("City", null, values);
		}
	}
	
	public List<City> loadCities(int province_id){
		List<City> list = new ArrayList<City>();
		Cursor cursor =  db.query("City", null, "province_id=?", new  String[]{String.valueOf(province_id)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityname(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCitycode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setProvince_id(province_id);
				list.add(city);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	public void saveCounty(County county){
		if(county!=null){
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCountyname());
			values.put("county_code", county.getCountycode());
			values.put("city_id", county.getCity_id());
			db.insert("County", null, values);
		}
	}
	
	public List<County> loadCounties(int city_id){
		List<County> list = new ArrayList<County>();
		Cursor cursor =  db.query("County", null, "city_id=?", new String[]{String.valueOf(city_id)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCountyname(cursor.getString(cursor.getColumnIndex("county_name")));
				county.setCountycode(cursor.getString(cursor.getColumnIndex("county_code")));
				county.setCity_id(city_id);
				list.add(county);
			}while(cursor.moveToNext());
		}
		return list;
	}
}
