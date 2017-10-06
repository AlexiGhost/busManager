'import static org.junit.Assert.*;

import org.junit.*

public class BusTest {
	Bus busA;
	
	@Before
	/**Créer des bus pour les tests*/
	public void initialise(){
		busA = new Bus("A");
	}
	@After
	public void clean(){
		busA = null;
	}
	@Test
	public void bus(){
		
	}
}