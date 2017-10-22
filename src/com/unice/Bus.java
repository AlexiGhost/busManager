package com.unice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**A bus of messages box.*/
public class Bus implements Serializable{ 
	
	//Variables
	private static final long serialVersionUID = 201710220205L;
	private String name;
	private String busType;
	private List<Box> boxes = new ArrayList<>();
	private static final String DEFAULT_BOX = "default"; //The name of the default box
	
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
			if(boxes.size()<this.getMaxBox() || this.getMaxBox()==0){
				boxes.add(new Box(name));								
			} else {
				System.out.println("Vous avez atteint le maximum de boite pour ce bus.");
			}
		}
	}
	/**Create a box and add it into the box list of the bus,
	 * also define a size limit for the messages of this box.
	 * @see Box*/
	public void createBox(String name, int maxMessageSize){
		createBox(name);
		getBox(name).setMaxMessageSize(maxMessageSize);
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
				System.err.println("Vous ne pouvez pas supprimer la boite par défaut.");
			}
		}
	}
	//Check
	/**Check if a specific box exist.
	 * @param boxName the box name.
	 * @return boolean*/
	public boolean isBoxExist(String boxName){
		for(Box box : boxes){
			if (box.getName().equals(name)){
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
			if (box.getName().equals(boxName)){
				return box;
			}
		}
		System.err.println("La boite '"+boxName+"' n'existe pas");
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
	
	/**Return the default box name
	 * @return String*/
	public static String getDefaultBoxName(){
		return DEFAULT_BOX;
	}
	
	/**Return the bus type
	 * @return String*/
	public String getBusType() {
		return busType;
	}
	
	/**Set the bus type of this bus (only if it's into the BusType list
	 * @see BusType*/
	public void setBusType(String busType) {
		if(BusType.getInstance().containsKey(busType)){
			this.busType = busType;			
		} else {
			System.err.println("Le type de bus '"+busType+"' n'existe pas");
		}
	}
	
	/**Get the max amount of box from the BusType list
	 * @return int
	 * @see BusType*/
	public int getMaxBox(){
		if(BusType.getInstance().containsKey(busType)){
			return BusType.getInstance().get(busType);			
		} else {
			return 1;
		}
	}
}