package com.unice;

import java.util.HashMap;

/**A pre-initialized HashMap does contain bus types and their box limit*/
public class BusType extends HashMap<String, Integer>{

	private static final long serialVersionUID = 201710220137L;
	private static BusType INSTANCE = new BusType();
	
	private BusType() {
		this.put("Community", 2);
		this.put("Premium", 5);
		this.put("Pro", 0);
	}
	
	public static BusType getInstance(){
		return INSTANCE;
	}
}
