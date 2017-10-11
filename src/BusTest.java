import org.junit.*;

public class BusTest {
	Bus busA;
	
	@Before
	/**Créer des bus pour les tests*/
	public void initialise(){
		busA = new Bus("A", "Pro");
	}
	@After
	public void clean(){
		busA = null;
	}
	@Test
	public void bus(){
		
	}
}