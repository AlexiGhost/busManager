import java.util.ArrayList;
import java.util.List;

public class BusManager {
//Variables
	private List<Bus> busList = new ArrayList<>();
//Methods
	/**Create a new bus within the buses list
	 * @param name the bus name*/
	public void createBus(String name){
		if (!isBusExist(name)){
			busList.add(new Bus(name));			
		}
	}
	/**Delete a bus within the buses list
	 * @param name The name of the bus you want to delete*/
	public void deleteBus(String name){
		for (Bus bus : busList){
			if(isBusExist(name)){
				busList.remove(bus);
			}
		}
	}
	/**Check if the bus exist within the buses list
	 * @return boolean
	 * @param name the name of the bus to check*/
	public boolean isBusExist(String name){
		for (Bus bus : busList) {
			if (bus.getName() == name){
				return true;
			}
		}
		return false;
	}
//Getters & Setters
	/**Return the buses list
	 * @return List<Bus>*/
	public List<Bus> getBuses(){
		return busList;
	}
	/**Return a bus within the buses list
	 * @return Bus
	 * @param name the bus name*/
	public Bus getBus(String name){
		for (Bus bus : busList) {
			if (bus.getName() == name){
				return bus;
			}
		}
		return null;
	}
}
