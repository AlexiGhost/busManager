package com.unice;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

class testBus {

	Bus b1;
	
	@Before
	/**Créer des Bus pour le test*/
	public void initialiser(){
		b1 = new Bus("bus", "pro");
	}
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
		b1 = null;
	}
	
	@Test
	public void Bus(){
		assertNotNull(b1);
	}
	
	@Test
	public void getName() {
		assertEquals("Le nom ne correspond pas", "bus", b1.getName());
	}
	
	@Test
	public void setName() {
		b1.setName("bus1");
		assertEquals("Le nom ne correspond pas", "bus1", b1.getName());
	}
	
	@Test
	public void getBoxes() {
		b1.createBox("box");
		assertEquals("La liste de boites n'est pas correcte", 1, b1.getBoxes().size());
	}
	
	@Test
	public void getBoxesNames(){
		b1.createBox("box");
		assertEquals("Les noms ne correspondent pas", "box", b1.getBoxesNames().get(0));
	}
	
	@Test
	public void getBox(){
		b1.createBox("box");
		assertNotNull("Le box n'existe pas", b1.getBox("box"));
	}
	
	@Test
	public void getAllMessages(){
		b1.createBox("box");
		b1.createMessage("m1");
		b1.createMessage("m2");
		b1.createMessage("box", "m3");
		assertEquals("La liste des messages est incorrecte", 3, b1.getAllMessages().size());
	}
	
	@Test
	public void getDefaultBoxName(){
		assertEquals("Le nom par default ne correspond pas", "default", Bus.getDefaultBoxName());
	}
	
	@Test
	public void getBusType() {
		assertEquals("Le type ne correspond pas", "pro", b1.getBusType());
	}
	
	@Test
	public void setBusType() {
		b1.setBusType("premium");
		assertEquals("Le type ne correspond pas", "premium", b1.getBusType());
	}
	
	@Test
	public void getMaxBox(){
		assertEquals("Le nombre ne correspond pas", 0, b1.getMaxBox());
	}
	
	@Test
	public void createBox(){
		b1.createBox("box");
		assertEquals("La box n'a pas été créer", "box", b1.getBox("box").getName());
	}
	
	@Test
	public void createBox2(){
		b1.createBox("box",20);
		assertEquals("Le nom ne correspond pas", "box", b1.getBox("box").getName());
	}
	
	@Test
	public void createMessage(){
		b1.createMessage("Bonjour c moi");
		assertEquals("Le message n'a pas été créer", "Bonjour c moi", b1.getAllMessages().get(0).getContent());
	}
	
	@Test
	public void deleteBox(){
		b1.createBox("box");
		b1.deleteBox("box");
		assertNull("La box n'a pas été supprimé", b1.getBox("box"));
	}
	
	@Test
	public void isBoxExist(){
		b1.createBox("box");
		assertNotNull(b1.isBoxExist("box"));
	}
}