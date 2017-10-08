import java.util.ArrayList;
import java.util.List;

/**A bus of messages box*/
public class Bus {
//Variables
	private String name;
	private List<Box> boxes = new ArrayList<>();
	private static String DEFAULT_BOX = "default";
//Constructors
	/**Create a bus
	 * @param name the bus name*/
	public Bus(String name) {
		setName(name);
		createBox(DEFAULT_BOX);
	}
//Functions
	//Create
	/**Create a box and add it into the box list of the bus
	 * @see Box*/
	public void createBox(String name){
		if(!isBoxExist(name)){
			boxes.add(new Box(name));
		} else {
			System.err.println("The box '"+name+"' already exist");
		}
	}
	/**Create a message into a specific box
	 * @param boxName the box where the message have to go
	 * @param content the message content
	 * @see Box
	 * @see Message*/
	public void createMessage(String boxName, String content){
		getBox(boxName).createMessage(content);
	}
	/**Create a message into the default box
	 * @param content the content of the message
	 * @see Box
	 * @see Message*/
	public void createMessage(String content){
		getBox(DEFAULT_BOX).createMessage(content);
	}
	//Read
	/**Read all the messages of a box
	 * @param boxName the box to read
	 * @see Box
	 * @see Message*/
	public void readBox(String boxName){
		if(isBoxExist(boxName)){
			getBox(boxName).ReadMessages();			
		}
	}
	/**Read all the messages of this bus
	 * @see Box
	 * @see Message*/
	public void readBus(){
		for(Box box : boxes){
			box.ReadMessages();
		}
	}
	//Delete
	/**Delete a box from the bus
	 * @param boxName the box to delete*/
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
	/**Check if a specific box exist
	 * @param boxName the box name
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
	/**Return the name of the bus
	 * @return String*/
	public String getName() {
		return name;
	}
	/**Set the name of the bus
	 * @param name the new bus name*/
	public void setName(String name) {
		this.name = name;
	}
	/**Return the boxes of this bus*/
	public List<Box> getBoxes() {
		return boxes;
	}
	/**Return a specific box of this bus
	 * @param boxName the name of the box
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
}
