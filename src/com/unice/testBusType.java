package com.unice;

import static org.junit.Assert.*;
import org.junit.Test;

class testBusType {
	
	@Test
	public void getValue(){
		assertEquals("La valeur est incorrecte", 5, BusType.getInstance().getValue("premium"));
	}
	
	@Test
	public void isKeyExist(){
		assertEquals("La clé n'existe pas", true, BusType.getInstance().isKeyExist("community"));
	}

}
