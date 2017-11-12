package com.unice;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

class testBus {

	Bus b1, b2;
	
	@Before
	/**Créer des Box pour le test*/
	public void initialiser(){
		b1 = new Bus("bus", "");
		b2 = new Bus("bus", "10");
	}
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
		b1 = null;
	}
	
	@Test
	public void getName() {
		assertEquals("Le nom ne correspond pas", "bus", b1.getName());
	}
	
	@Test
	public void setName() {
		b1.setName("bus");
		assertEquals("Le nom ne correspond pas", "bus", b1.getName());
	}
	
	@Test
	public void getBoxes() {
		assertEquals("Le nom ne correspond pas", "bus", b1.getBoxes());
	}
	
	@Test
	public void getBoxesNames(){
		assertEquals("Les noms ne correspondent pas", "bus", b1.getBoxesNames());
	}
	
	@Test
	public void getBox(){
		assertEquals("Le nom ne correspond pas", "bus", b1.getBox());
	}
	
	@Test
	public void getAllMessages(){
		assertEquals("Les messages ne correspondent pas", "bus", b1.getAllMessages());
	}
	
	@Test
	public void getDefaultBoxName(){
		assertEquals("Le nom par default ne correspond pas", "bus", b1.getDefaultBoxName());
	}
	
	@Test
	public void getBusType() {
		assertEquals("Le type ne correspond pas", "bus", b1.getBusType());
	}
	
	@Test
	public void setBusType() {
		b1.setBusType("pro");
		assertEquals("Le type ne correspond pas", "pro", b1.getBusType());
	}
	
	@Test
	public void getMaxBox(){
		assertEquals("Le nombre ne correspond pas", 10, b1.getMaxBox());
	}
	
	@Test
	public void createBox(){
		b1.createBox("box");
		assertEquals("La box n'a pas été créer", "box", b1.getBox().get(0).getContent());
	}
	
	@Test
	public void createBox(){
		b1.createBox(20);
		assertEquals("Le nom ne correspond pas", 20, b1.size());
	}
	
	@Test
	public void createMessage(){
		b1.createMessage("Bonjour c moi");
		assertEquals("Le message n'a pas été créer", "Bonjour c moi", b1.getAllMessages().get(0).getContent());
	}
	
	@Test
	public void deleteBox(){
		b1.createBox("Bonjour c moi");
		b1.deleteBox();
		assertEquals("La box n'a pas été suppriméa", 0, b1.getBox().size());
	}
	
	@Test
	public void isBoxExist(){
		assertNotNull(b1);
	}
	
	

}
