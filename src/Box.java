import java.util.ArrayList;
import java.util.List;
//TODO delete messages by creationDate
/**A box of messages.*/
public class Box {
//Variables
	private static int MAX_MESSAGE = 20;
	private static int MAX_MESSAGE_SIZE = 0; //0 = pas de limite
	
	private int maxMessage;
	private int maxMessageSize;
	private String name;
	private List<Message> messages = new ArrayList<>();
//Constructors
	/**Create a message box.
	 * @param name the box name.*/
	public Box(String name) {
		setName(name);
		setMaxMessage(MAX_MESSAGE);
		setMaxMessageSize(MAX_MESSAGE_SIZE);
	}
	/**Create a message box with a limit for messages size.
	 *@param name the box name.
	 *@param maxMessageSize the maximum size for a message.*/
	public Box(String name, int maxMessageSize){
		this(name);
		setMaxMessageSize(maxMessageSize);
	}
//Functions
	//Create
	/**Create a new message into the box.
	 * @param content the message content.
	 * @see Message*/
	public void createMessage(String content){
		if(messages.size() >= maxMessage){
			if(maxMessageSize == 0){
				messages.add(new Message(content));							
			} else {
				if(content.length() <= maxMessageSize){
					messages.add(new Message(content));
				}
			}
		}
	}
	//Delete
	/**Delete a message by using is position into the messages list.
	 * @param nMessage the message 'id'.
	 * @deprecated*/
	public void deleteMessage(int nMessage){
		messages.remove(nMessage);
	}
	/**Delete all the messages of the box.*/
	public void deleteMessages(){
		messages.clear();
	}
//Getters & Setters
	/**Set the name of the box.
	 * @param name the new box name.*/
	public void setName(String name) {
		this.name = name;
	}
	/**Return the name of the box.*/
	public String getName() {
		return name;
	}
	/**Return the messages list.
	 * @return List<Message>*/
	public List<Message> getMessages() {
		return messages;
	}
	/**Return a specific message by using is position into the messages list.
	 * @param nMessage the message  'id'.
	 * @deprecated*/
	public Message getMessage(int nMessage){
		return messages.get(nMessage);
	}
	/**Set the maximum amount of messages of the box.
	 * @param maxMessage the maximum amount.*/
	public void setMaxMessage(int maxMessage) {
		this.maxMessage = maxMessage;
	}
	/**Return the maximum amount of messages.
	 * @return int*/
	public int getMaxMessage() {
		return maxMessage;
	}
	/**Set the limit size (in character) of the messages into this box.
	 * @param maxSize the limit size.*/
	public void setMaxMessageSize(int maxSize) {
		this.maxMessageSize = maxSize;
	}
	/**Return the limit size (in character) of the messages into this box.*/
	public int getMaxMessageSize(){
		return maxMessageSize;
	}
}