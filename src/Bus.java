import java.util.ArrayList;
import java.util.List;

public class Bus {
//Variables
	private String name;
	private List<Box> boxes = new ArrayList<>();
	private static String DEFAULT_BOX = "default";
//Constructors
	public Bus(String name) {
		setName(name);
		createBox(DEFAULT_BOX);
	}
//Functions
	public void createBox(String name){
		boxes.add(new Box(name));
	}
	
	public void createMessage(String boxName, String content){
		getBox(boxName).createMessage(content);
	}
	
	public void createMessage(String content){
		getBox(DEFAULT_BOX).createMessage(content);
	}
	
	public void readBox(String boxName){
		getBox(boxName).ReadMessages();
	}
	
	public void readBus(){
		for(Box box : boxes){
			box.ReadMessages();
		}
	}
//Getters & Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Box> getBoxes() {
		return boxes;
	}
	
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
