import java.util.Date;


public class Message {
//Variables	
	private String content;
	private Date dateCreation;
//Constructors
	public Message(String contenu) {
		setContenu(contenu);;
		setDateCreation(new Date());
	}
//Getters & Setters
	public String getContent() {
		return content;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setContenu(String content) {
		this.content = content;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
