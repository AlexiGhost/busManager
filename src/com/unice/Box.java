package com.unice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**A box does contain a list of messages.*/
public class Box implements Serializable{
//Variables
	private static final long serialVersionUID = 201710220204L;
	private static final int MAX_MESSAGE = 20;
	private static final int MAX_MESSAGE_SIZE = 0; //0 = pas de limite
	
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
		if(messages.size() < maxMessage){
			if(maxMessageSize == 0){
				messages.add(new Message(content));
				System.out.println("Message ajout� avec succ�s !");
			} else {
				if(content.length() <= maxMessageSize){
					messages.add(new Message(content));
					System.out.println("Message ajout� avec succ�s !");
				} else {
					System.err.println("Ce message d�passe le nombre de caract�res autoris�s ("+maxMessageSize+")");
				}
			}
		} else {
			System.err.println("Nombre maximal de messages atteint");
		}
	}
	//Delete
	/**Delete a message by using is position into the messages list.
	 * @param nMessage the message 'id'.
	 * @deprecated*/
	public void deleteMessage(int nMessage){
		messages.remove(nMessage);
	}
	/**Delete messages if they are older than the time in parameters
	 * @param day the number of day
	 * @param hour the number of hour
	 * @param minute the number of minute
	 * @param seconds the number of seconds*/
	public void deleteOlderMessage(int day, int hour, int minute, int seconds){
		long MaxTime = day*24*60*60*1000 + hour*60*60*1000 + minute*60*1000 + seconds*1000;
		Date now = new Date();
		List<Message> messagesToDelete = new ArrayList<>();
		for(Message message : getMessages()){
			if((now.getTime()-message.getDateCreation().getTime()) > MaxTime) messagesToDelete.add(message);
		}
		for(Message message : messagesToDelete){
			messages.remove(messages.indexOf(message));
		}
		System.out.println(messagesToDelete.size()+" messages supprim�es.");
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