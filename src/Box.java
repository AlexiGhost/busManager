import java.util.ArrayList;
import java.util.List;

public class Box {
//Variables
	private static int MAX_MESSAGE = 20;
	
	private int maxMessage;
	private String name;
	private List<Message> messages = new ArrayList<>();
//Constructors
	public Box(String name) {
		setName(name);
		maxMessage = MAX_MESSAGE;
	}
//Functions
	public void createMessage(String content){
		if(messages.size() >= maxMessage){
			messages.add(new Message(content));			
		}
	}
	
	public void deleteMessage(int nMessage){
		messages.remove(nMessage);
	}
	
	public void ReadMessages(){
		for (Message message : messages){
			System.out.println(message.getContent());
		}
	}
//Getters & Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public Message getMessage(int nMessage){
		return messages.get(nMessage);
	}
	
	public void setMaxMessage(int maxMessage) {
		this.maxMessage = maxMessage;
	}
	
	public int getMaxMessage() {
		return maxMessage;
	}
}