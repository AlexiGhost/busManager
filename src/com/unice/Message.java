package com.unice;

import java.util.Date;

/**A message with a content*/
public class Message {
//Variables	
	private String content;
	private Date dateCreation;
//Constructors
	/**Create a new message.
	 * @param the message content.*/
	public Message(String content) {
		setContent(content);;
		dateCreation = new Date();
	}
//Getters & Setters
	/**Return the content of the message.
	 * @return String.*/
	public String getContent() {
		return content;
	}
	/**Set the content of the message.
	 * @param content the new message content.*/
	public void setContent(String content) {
		this.content = content;
	}
	/**Return the creation date of the message.
	 * @return Date*/
	public Date getDateCreation() {
		return dateCreation;
	}
}
