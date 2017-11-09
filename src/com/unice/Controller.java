package com.unice;

import java.util.List;

public class Controller {
	UI ui = new UI();
	String res, res2;
	List<String> resList;
	List<Integer> resIntList;
	boolean isStarted = true;
	/**Ask what kind of action we want to do (create|show|delete)
	 * it's the initial menu when we start the application*/
	public void start(){
		BusManager.importBusList("datas/buses");
		while(isStarted){
			res = ui.startCommand();
			while (res.length() == 0){ //Avoid the StringIndexOutOfBoundsException
				res = ui.startCommand();				
			}
			switch (res.charAt(0)) {
			case 'c':
				create();
				break;
			case 'a':
				show();
				break;
			case 's':
				delete();
				break;
			case 'q':
				isStarted = false;
				ui.print("A bientôt !");
				break;
			default:
				ui.printError("Cette commande n'existe pas, veuillez réessayer\n");
				break;
			}
			for(int i=0;i<0;i++){
				ui.print("\n");
			}
		}
	}
//CREATE
	/**Ask what we want to create (bus|box|message)*/
	public void create(){
		res = ui.createCommand();
		while (res.length() == 0){ //Avoid the StringIndexOutOfBoundsException
			res = ui.createCommand();				
		}
		switch (res.charAt(0)) {
		case '1' : //bus
			createBus();
			break;
		case '2' : //boite
			createBox();
			break;
		case '3' : //message
			createMessage();
			break;
		default:
			ui.printError("Cette commande n'existe pas, veuillez réessayer\n");
			break;
		}
	}
	/**Create the read bus*/
	public void createBus(){
		res = ui.getBusName();
		res2 = ui.getBusType();
		BusManager.createBus(res, res2);
	}
	/**Create a box into the read bus*/
	public void createBox(){
		res = ui.getBusName();
		if(!isBusExist()) return;
		res2 = ui.getBoxName();
		if(isBoxExist()) return;
		int maxSize = ui.getBoxMaxSize();
		if (maxSize == 0){
			BusManager.getBus(res).createBox(res2);			
		} else {
			BusManager.getBus(res).createBox(res2, maxSize);
		}
	}
	/**Create a message into the read box*/
	public void createMessage(){
		res = ui.getBusName();
		if(!isBusExist()) return;
		ui.printBoxInfo();
		res2 = ui.getBoxName();
		if(!isBoxExist()) return;
		String messageContent = ui.getMessage();
		if(res2.length() == 0) BusManager.getBus(res).createMessage(messageContent);
		else BusManager.getBus(res).createMessage(res2, messageContent);
	}
	
//SHOW
	/**Ask what we want to see (bus messages|box messages|buses names|boxes names*/
	public void show(){
		res = ui.showCommand();
		while (res.length() == 0) res = ui.showCommand(); //Avoid the StringIndexOutOfBoundsException
		switch (res.charAt(0)) {
		case '1' : //Message bus
			showBusMessages();
			break;
		case '2' : //Message boite de bus
			showBoxMessages();
			break;
		case '3' : //Nom des bus
			showBusesNames();
			break;
		case '4' : //Nom des boite d'un bus
			showBoxesNames();
			break;
		default:
			ui.printError("Cette commande n'existe pas, veuillez réessayer\n");
			break;
		}
	}
	/**Show all the messages into a bus*/
	public void showBusMessages(){
		res=ui.getBusName();
		if(!isBusExist()) return;
		ui.print("Messages - "+res);
		for(Message message : BusManager.getBus(res).getAllMessages()){
			ui.print("\t"+message.getContent());
		}
	}
	/**Show the messages into a box*/
	public void showBoxMessages(){
		res=ui.getBusName();
		if(!isBusExist()) return;
		res2=ui.getBoxName();
		if(!isBoxExist()) return;
		ui.print("Messages - "+res+" - "+res2);
		for(Message message : BusManager.getBus(res).getBox(res2).getMessages()){
			ui.print("\t"+message.getContent());
		}
	}
	/**Show the buses names*/
	public void showBusesNames(){
		ui.print("Liste des bus :");
		for(String busName : BusManager.getBusesNames()){
			ui.print("\t"+busName);
		}
	}
	/**Show the boxes names of a bus*/
	public void showBoxesNames(){
		res=ui.getBusName();
		if(!isBusExist()) return;
		ui.print("Liste des boites - "+res);
		for(String boxName : BusManager.getBus(res).getBoxesNames()){
			ui.print("\t"+boxName);
		}
	}
	
//DELETE
	/**Ask what we want to delete (bus|box|messages)*/
	public void delete(){
		res = ui.deleteCommand();
		while (res.length() == 0){ //Avoid the StringIndexOutOfBoundsException
			res = ui.deleteCommand();				
		}
		switch (res.charAt(0)) {
		case '1': //bus
			deleteBus();
			break;
		case '2': //boite de messages
			deleteBox();
			break;
		case '3': //messages
			deleteMessages();
			break;
		default:
			ui.printError("Cette commande n'existe pas, veuillez réessayer\n");
			break;
		}
	}
	/**Delete the read bus*/
	public void deleteBus(){
		res = ui.getBusName();
		BusManager.deleteBus(res);
	}
	/**Delete the read box*/
	public void deleteBox(){
		res = ui.getBusName();
		if(!isBusExist()) return;
		String res2 = ui.getBoxName();
		BusManager.getBus(res).deleteBox(res2);
	}
	/**Delete the messages if they are older than the read time*/
	public void deleteMessages(){
		res = ui.getBusName();
		if(!isBusExist()) return;
		res2 = ui.getBoxName();
		if(!isBoxExist()) return;
		ui.print("Supprimer les messages antérieures à : ");
		resIntList = ui.getTime();
		int day = resIntList.get(0);
		int hour = resIntList.get(1);
		int minute = resIntList.get(2);
		int second = resIntList.get(3);
		BusManager.getBus(res).getBox(res2).deleteOlderMessage(day, hour, minute, second);
	}
	
	//CHECK
	/**Check if the 'read' bus exist
	 * @return true if exist | false if not exist*/
	public boolean isBusExist(){
		if(BusManager.isBusExist(res)) return true;
		else {
			System.err.println("Le bus '"+res+"' n'existe pas");
			return false;
		}
	}
	/**Check if the 'read' box exist
	 * @return true if exist | false if not exist*/
	public boolean isBoxExist(){
		if(BusManager.getBus(res).isBoxExist(res2)) return true;
		else {
			System.err.println("La boite '"+res2+"' n'existe pas");
			return false;
		}
	}
}