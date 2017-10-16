package com.unice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**A bus of messages box.*/
public class Bus implements Serializable{

//TODO Un consommateur peut demander à lister tous les messages qui se trouvent sur le bus dans ce cas tous les messages dans toutes le boîtes lui sont retournés.*/ 
	
//Variables
	private String name;
	private List<Box> boxes = new ArrayList<>();
	private String busType; //Define the maximum box amount 
	private static final String DEFAULT_BOX = "default"; //The name of the default box
	private static HashMap<String, Integer> busTypeList = null; //The list of existing bus types and their limitations
	
//Constructors
	/**Create a bus.
	 * @param name the bus name.*/
	public Bus(String name, String busType) {
		setName(name);
		setBusType(busType);
		createBox(DEFAULT_BOX);
	}
	
//Functions
	//Create
	/**Create a box and add it into the box list of the bus.
	 * @see Box*/
	public void createBox(String name){
		if(!isBoxExist(name)){
			if(boxes.size() < getMaxBox() || getMaxBox() == 0) {
				boxes.add(new Box(name));				
			} else {
				System.out.println("You've reach the max amount of box for this bus ("+getMaxBox()+")");
			}
		}
	}
	/**Create a box and add it into the box list of the bus,
	 * also define a size limit for the messages of this box.
	 * @see Box*/
	public void createBox(String name, int maxMessageSize){
		createBox(name);
		boxes.get(boxes.indexOf(name)).setMaxMessageSize(maxMessageSize);
	}
	
	/**Create a message into a specific box.
	 * @param boxName the box where the message have to go.
	 * @param content the message content.
	 * @see Box
	 * @see Message*/
	public void createMessage(String boxName, String content){
		getBox(boxName).createMessage(content);
	}
	/**Create a message into the default box.
	 * @param content the content of the message.
	 * @see Box
	 * @see Message*/
	public void createMessage(String content){
		getBox(DEFAULT_BOX).createMessage(content);
	}
	//Delete
	/**Delete a box from the bus.
	 * @param boxName the box to delete.*/
	public void deleteBox(String boxName){
		if(isBoxExist(boxName)){
			if(boxName != DEFAULT_BOX){
				boxes.remove(getBox(boxName));							
			} else {
				System.err.println("You can't delete the default box");
			}
		}
	}
	//Check
	/**Check if a specific box exist.
	 * @param boxName the box name.
	 * @return boolean*/
	public boolean isBoxExist(String boxName){
		for(Box box : boxes){
			if (box.getName() == name){
				return true;
			}
		}
		return false;
	}
	
//Getters & Setters
	/**Return the name of the bus.
	 * @return String*/
	public String getName() {
		return name;
	}
	/**Set the name of the bus.
	 * @param name the new bus name.*/
	public void setName(String name) {
		this.name = name;
	}
	/**Return the boxes of this bus.*/
	public List<Box> getBoxes() {
		return boxes;
	}
	public List<String> getBoxesNames(){
		List<String> boxesNames = new ArrayList<>();
		for(Box box : boxes){
			boxesNames.add(box.getName());
		}
		return boxesNames;
	}
	/**Return a specific box of this bus.
	 * @param boxName the name of the box.
	 * @return Box*/
	public Box getBox(String boxName){
		for(Box box : boxes){
			if (box.getName() == boxName){
				return box;
			}
		}
		System.err.println("The box '"+boxName+"' doesn't exist");
		return null;
	}
	/**Return the messages from all the boxes of this bus
	 * @return A big messages list does contain all the messages of this bus*/
	public List<Message> getAllMessages(){
		List<Message> messageList = new ArrayList<>();
		for(Box box : boxes){
			for(Message message : box.getMessages()){
				messageList.add(message);
			}
		}
		return messageList;
	}
	/**Define a new bus type (check if exist)
	 * @param busType the new type of bus*/
	public void setBusType(String busType){
		Bus.importBusType("datas/busTypeList");
		Object maxBus = busTypeList.get(busType);
		if(maxBus != null){
			this.busType = busType; 
		} else {
			System.err.println("The bus type '"+busType+"' doesn't exist.");
		}
	}
	
	/**Return the max box amount for this bus
	 * @return int*/
	public int getMaxBox(){
		Object maxBus = busTypeList.get(busType);
		if(maxBus != null){
			return (int)maxBus;
		} else {
			System.err.println("The bus type '"+busType+"' doesn't exist.");
			return 0; //if the bus type doesn't exist, the limitation is unheeded
		}
	}

//Imports & Exports [bus type list (de)serialization]
	/**Import the bus type list from a serialized file
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	public static void importBusType(String sourceFile){
		Object readedObject = Save.read(sourceFile+".ser");
		if(readedObject instanceof HashMap){ //Check if the Object sub-type is a HashMap 
			busTypeList = (HashMap<String, Integer>) readedObject;	    		  
		} else if(busTypeList == null) {
			busTypeList = new HashMap<>();
		} else {
			System.err.println("The source file doesn't contain the bus type list");
		}
	}
	
	/**Export the bus type list into a serialize file
	 * @param targetFile the target file name (must have a '.ser' extension)*/
	public static void exportBusType(String targetFile){
		Save.save(busTypeList, targetFile+".ser");
	}

//bus type list editing
	/**Add a new bus type
	 * @param busType the bus type name
	 * @param maxBox the maximum amount of message box for bus with this bus type
	 * @param targetFile the target file name (must have a '.ser' extension)
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	public static void addBusType(String busType, int maxBox, String sourceFile, String targetFile){
		 importBusType(sourceFile);
		 busTypeList.put(busType, maxBox);
         exportBusType(targetFile);
	}
	
	/**Remove a bus type
	 * @param busType the bus type to remove
	 * @param targetFile the target file name (must have a '.ser' extension)
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	public static void removeBusType(String busType, String targetFile, String sourceFile){
		importBusType(sourceFile);
		busTypeList.remove(busType);
		exportBusType(targetFile);
	}
	
	/**Edit a bus type (change the max box amount)
	 * @param busType the bus type name
	 * @param maxBox the maximum amount of message box for bus with this bus type
	 * @param targetFile the target file name (must have a '.ser' extension)
	 * @param sourceFile the source file name (must have a '.ser' extension)*/
	public static void editBusType(String busType, int maxBox, String sourceFile, String targetFile){
		importBusType(sourceFile);
		Object oldBusType = busTypeList.get(busType);
		if(oldBusType != null){
			busTypeList.put(busType, maxBox);
			exportBusType(targetFile);
		} else {
			System.err.println("The bus type '"+busType+"' doesn't exist.");
		}
	}
	
	public static HashMap<String, Integer> getBusTypeList(){
		return busTypeList;
	}
}