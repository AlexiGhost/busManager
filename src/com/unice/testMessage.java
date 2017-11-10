package com.unice;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testMessage {

	Message m1, m2;
	Date dateCreation;
	
	@Before
	/**Créer des Messages pour le test*/
	public void initialiser(){
		dateCreation = new Date();
		m1 = new Message("Message 1");
	}
	
	
	@After
	/**Detruit les Messages*/
	public void nettoyer(){
		m1 = null;
	}
	
	@Test
	/**Test - getContent()*/
	public void getContent(){
		assertEquals("Le contenu ne correspond pas", "Message 1", m1.getContent());
	}
	@Test
	/**Test - setContent()*/
	public void setContent(){
		m1.setContent("Message UN");
		assertEquals("Le contenu ne correspond pas", "Message UN", m1.getContent());
	}
	
	@Test
	/**Test - getDateCreation()*/
	public void getDateCreation(){
		assertTrue("Creation date isn't enough close to the real creation date",
				Math.abs(dateCreation.getTime()-m1.getDateCreation().getTime()) < 1000);
	}

}
