package com.unice;

import java.util.ArrayList;
import java.util.List;

/**Manage the buses (this is a Singleton class)*/
public class BusManager{

//Variables
	
	private static BusManager INSTANCE = new BusManager();
	private static List<Bus> buses = new ArrayList<>();

//Constructor
	
	/**Private constructor*/
	private BusManager(){}
	
//Functions
	
	//Create
	/**Create a new bus within the buses list
	 * @param name the bus name*/
	public static void createBus(String name, String busType){
		if (!isBusExist(name)){
			Bus bus = new Bus(name, busType);
			if(bus.getBusType()!= null){
				buses.add(bus);
				System.out.println("Le bus "+bus.getName()+" a été crée avec succés.");
			}
		}
		exportBusList("datas/buses");
	}
	//Delete
	/**Delete a bus within the buses list
	 * @param name The name of the bus you want to delete*/
	public static void deleteBus(String name){
		if(isBusExist(name)){
			for (Bus bus : buses){
				if(bus.getName().equals(name)){
					buses.remove(bus);
					System.out.println("Le bus '"+name+"' a été supprimé");
					return;
				}
			}
		}
		exportBusList("datas/buses");
	}
	//Check
	/**Check if the bus exist within the buses list
	 * @return boolean
	 * @param name the name of the bus to check*/
	public static boolean isBusExist(String name){
		if(buses.size()!=0){
			for (Bus bus : buses) {
				if (bus.getName().equals(name)){
					return true;
				}
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
		try{
			for(Bus bus : buses){
				busesNames.add(bus.getName());
			}
		} catch(NullPointerException e){
			System.err.println("Il n'y a pas de bus.");
		}
		return busesNames;
	}
//Import & Export
	
	/**Import the bus list from a file
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	@SuppressWarnings("unchecked") //checked by 'instanceof'
	public static void importBusList(String sourceFile){
		Object readObject = Save.read(sourceFile);
		if(readObject instanceof ArrayList){ //Check if the Object sub-type is an ArrayList 
			buses = (ArrayList<Bus>) readObject; 			
		} else {
			System.err.println("Le fichier de sauvegarde est corrompu/inexistant");
		}
	}
	
	/**Export the bus list to a serialized file
	 * @param targetFile the target file name (must have a '.ser' extension)*/
	public static void exportBusList(String targetFile){
		Save.save(buses, targetFile);
	}
}



