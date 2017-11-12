package com.unice;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

class testBusManager {
	
	@Before
	/**Créer des Bus pour le test*/
	public void initialiser(){
	}
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
	}
	
	@Test
	public void getBuses(){
		BusManager.createBus("bus", "pro");
		assertEquals("Les bus ne correspondent pas", 1, BusManager.getBuses().size());
	}
	
	@Test
	public void getBus(){
		BusManager.createBus("bus", "pro");
		assertEquals("Le nom ne correspond pas", "bus", BusManager.getBus("bus"));
	}
	
	@Test
	public void getBusesNames(){
		BusManager.createBus("bus", "pro");
		assertEquals("Les noms ne correspondent pas", "bus", BusManager.getBusesNames().get(0));
	}
	
	@Test
	public void createBus(){
		BusManager.createBus("bus","pro");
		assertEquals("Le bus n'a pas été créer", "bus", BusManager.getBus("bus"));
	}
	
	@Test
	public void deleteBus(){
		BusManager.createBus("bus","pro");
		BusManager.deleteBus("bus");
		assertEquals("Le bus n'a pas été supprimé", 1, BusManager.getBus("bus"));
	}
	
	@Test
	public void isBusExist(){
		BusManager.createBus("bus", "pro");
		assertEquals("Le bus n'existe pas",true, BusManager.isBusExist("bus"));
	}

}
