package com.unice;

import java.util.HashMap;

/**A pre-initialized HashMap does contain bus types and their box limit*/
public class BusType extends HashMap<String, Integer>{

	private static final long serialVersionUID = 201710220137L;
	private static BusType INSTANCE = new BusType();
	
	private BusType() {
		this.put("community", 2);
		this.put("premium", 5);
		this.put("pro", 0); //no limit
	}
	
	public static BusType getInstance(){
		return INSTANCE;
	}
	
	public int getValue(String key){
		if(containsKey(key)){
			return get(key);			
		} else {
			return -1;
		}
	}
	
	public boolean isKeyExist(String key){
		if(containsKey(key)){
			return true;
		} else {
			return false;
		}
	}
}
