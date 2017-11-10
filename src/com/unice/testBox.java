package com.unice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class testBox {
	
	Box b1, b2;
	
	@Before
	/**Créer des Box pour le test*/
	public void initialiser(){
		b1 = new Box("BOX UN");
		b2 = new Box("BOX DEUX", 20);
	}
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
		b1 = null;
	}

	
	@Test
	/**Return the name of the box.*/
	public void getName() {
		assertEquals("Le nom ne correspond pas", "BOX UN", b1.getName());
	}
	
	@Test
	public void setName(){
		b1.setName("BOX UN");
		assertEquals("Le nom ne correspond pas", "BOX UN", b1.getName());
	}
	
	@Test
	public void getMaxMessage() {
		assertEquals("Le nombreMax ne correspond pas", 20, b1.getMaxMessage());
	}
	
	@Test
	public void setMaxMessage(){
		b1.setMaxMessage(20);
		assertEquals("Le nom ne correspond pas", 20, b1.getMaxMessage());
	}
	
	@Test
	public void getMaxMessageSize(){
		assertEquals("La taille max du message ne correspond pas", 0, b1.getMaxMessageSize());
	}
	
	@Test
	public void setMaxMessageSize(){
		b1.setMaxMessageSize(50);
		assertEquals("La taille max du message ne correspond pas", 50, b1.getMaxMessageSize());
	}
	
	@Test
	public void getMessages() {
		b1.createMessage("Bonjour c moi");
		assertEquals("La liste des messages elle est pas belle", 1, b1.getMessages().size());
	}
	
	@Test
	public void Box() {
		assertNotNull(b1);
		assertNotNull(b2);
	}
	
	@Test
	public void createMessage(){
		b1.createMessage("Bonjour c moi");
		assertEquals("Le message n'a pas été créer", "Bonjour c moi", b1.getMessages().get(0).getContent());
	}
	
	@Test
	public void deleteOlderMessage(){
		b1.createMessage("Bonjour c moi");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b1.createMessage("Bonjour c toi");
		b1.deleteOlderMessage(0, 0, 0, 1);
		assertEquals("Le message n'a pas été supprimé", 1, b1.getMessages().size());
	}
	
	@Test
	public void deleteMessages(){
		b1.createMessage("Bonjour c moi");
		b1.deleteMessages();
		assertEquals("Les messages n'ont pas été supprimés", 0, b1.getMessages().size());
	}

}
