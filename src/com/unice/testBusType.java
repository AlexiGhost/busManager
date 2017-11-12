package com.unice;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;


class testBusType {

	Bus b1;
	
	@Before
	/**Créer des Box pour le test*/
	public void initialiser(){
		b1 = new Bus("bus", "pro");

	}
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
		b1 = null;
	}
	
	@Test
	public void getInstance(){
		assertEquals("L'instance ne correspond pas", "Bus", b1.getInstance());
	}
	
	@Test
	public void getValue(){
		
	}
	
	@Test
	public void isKeyExist(){
		assertNotNull(b1);
	}

}
