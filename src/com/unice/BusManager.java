package com.unice;

import java.util.ArrayList;
import java.util.List;

/**Manage the buses (this is a Singleton class)*/
public class BusManager{

//Variables
	
	private static BusManager INSTANCE = new BusManager();
	private static List<Bus> buses = null;

//Constructor
	
	/**Private constructor*/
	private BusManager(){
		importBusList("datas/buses");
	}
	
//Functions
	
	//Create
	/**Create a new bus within the buses list
	 * @param name the bus name*/
	public static void createBus(String name, String busType){
		if (!isBusExist(name)){
			buses.add(new Bus(name, busType));
		}
		exportBusList("datas/buses");
	}
	//Delete
	/**Delete a bus within the buses list
	 * @param name The name of the bus you want to delete*/
	public static void deleteBus(String name){
		for (Bus bus : buses){
			if(isBusExist(name)){
				buses.remove(bus);
			}
		}
	}
	//Check
	/**Check if the bus exist within the buses list
	 * @return boolean
	 * @param name the name of the bus to check*/
	public static boolean isBusExist(String name){
		for (Bus bus : buses) {
			if (bus.getName().equals(name)){
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
	public static List<Bus> getBuses(){
		return buses;
	}
	/**Return a bus within the buses list
	 * @return Bus
	 * @param name the bus name*/
	public static Bus getBus(String name){
		for (Bus bus : buses) {
			if (bus.getName().equals(name)){
				return bus;
			}
		}
		return null;
	}
	/**Return the buses names
	 * @return List<String> the buses names*/
	public static List<String> getBusesNames(){
		List<String> busesNames = new ArrayList<>();
		for(Bus bus : buses){
			busesNames.add(bus.getName());
		}
		return busesNames;
	}
//Import & Export
	
	/**Import the bus list from a file
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	@SuppressWarnings("unchecked") //Checked with InstanceOf
	public static void importBusList(String sourceFile){
		Object readedObject = Save.read(sourceFile);
		if(readedObject instanceof ArrayList){ //Check if the Object sub-type is an ArrayList 
			buses = (ArrayList<Bus>) readedObject; 			
		} else if(buses == null) {
			buses = new ArrayList<>();
		} else {
			System.err.println("Le fichier source est corrompu");
		}
	}
	
	/**Export the bus list to a serialized file
	 * @param targetFile the target file name (must have a '.ser' extension)*/
	public static void exportBusList(String targetFile){
		Save.save(buses, targetFile);
	}
}



