package com.unice;

import java.util.ArrayList;
import java.util.List;

/**Manage the buses (this is a Singleton class)
 * @author Courieux Alexi*/
public class BusManager{

//Variables
	
	private static BusManager INSTANCE = new BusManager();
	private List<Bus> busList = null;

//Constructor
	
	/**Private constructor*/
	private BusManager(){
		importBusList("datas/busList");
	}
	
//Functions
	
	//Create
	/**Create a new bus within the buses list
	 * @param name the bus name*/
	public void createBus(String name, String busType){
		if (!isBusExist(name)){
			busList.add(new Bus(name, busType));
		}
	}
	//Delete
	/**Delete a bus within the buses list
	 * @param name The name of the bus you want to delete*/
	public void deleteBus(String name){
		for (Bus bus : busList){
			if(isBusExist(name)){
				busList.remove(bus);
			}
		}
	}
	//Check
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
	
	/**Return the instance of BusManager
	 * @return BusManager Instance*/
	public static BusManager getInstance(){
		return INSTANCE;
	}
	
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
	
//Import & Export
	
	/**Import the bus list from a file
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	public void importBusList(String sourceFile){
		Object readedObject = Save.read(sourceFile+".ser");
		if(readedObject instanceof ArrayList){ //Check if the Object sub-type is an ArrayList 
			busList = (ArrayList<Bus>) readedObject; 			
		} else if(busList == null) {
			busList = new ArrayList<>();
		} else {
			System.err.println("The source file doesn't contain the bus list or is corrupted");
		}
	}
	
	/**Export the bus list to a serialized file
	 * @param targetFile the target file name (must have a '.ser' extension)*/
	public void exportBusList(String targetFile){
		Save.save(busList, targetFile+".ser");
	}
}



