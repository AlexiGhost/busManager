package com.unice;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

class testBusManager {
	
	Bus b1;
	
	@Before
	/**Créer des Bus pour le test*/
	public void initialiser(){
		b1 = new Bus("Bus un", "");
	}
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
		b1 = null;
	}
	
	@Test
	public void getInstance(){
		assertEquals("L'instance ne correspond pas", "Bus un", b1.getInstance());
	}
	
	@Test
	public void getBuses(){
		assertEquals("Les buses ne correspondent pas", "Bus un", b1.getBuses());
	}
	
	@Test
	public void getBus(){
		assertEquals("Le nom ne correspond pas", "Bus un", b1.getBus());
	}
	
	@Test
	public void getBusesNames(){
		assertEquals("Les noms ne correspondent pas", "Bus un", b1.getBusesNames());
	}
	
	@Test
	public void importBusList(){
		
	}
	
	@Test
	public void exportBusList(){
		
	}
	
	@Test
	public void createBus(){
		b1.createBus("Bonjour c moi");
		assertEquals("Le bus n'a pas été créer", "Bonjour c moi", b1.getBus().content());
	}
	
	@Test
	public void deleteBus(){
		b1.createBus("Bonjour c moi");
		b1.deleteBus();
		assertEquals("Le bus n'a pas été supprimé", 0, b1.getBus().size());
	}
	
	@Test
	public void isBusExist(){
		assertNotNull(b1);
	}


}
