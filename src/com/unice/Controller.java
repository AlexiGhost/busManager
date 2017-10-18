package com.unice;

import java.util.List;

public class Controller {
	UI ui = new UI();
	String res, res2;
	List<String> resList;
	List<Integer> resIntList;
	boolean isStarted = true;

	public void start(){
		
		while(isStarted){
			BusManager.getInstance().importBusList("datas/busList.ser");
			Bus.importBusType("datas/busTypeList.ser");
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
				ui.print("A bient�t !");
				break;
			default:
				ui.printError("Cette commande n'existe pas, veuillez r�essayer");
				break;
			}
		}
	}
//CREATE
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
			ui.printError("Cette commande n'existe pas, veuillez r�essayer");
			break;
		}
	}
	
	public void createBus(){
		res = ui.getBusName();
		res2 = ui.getBusType();
		BusManager.getInstance().createBus(res, res2);
		ui.print("Bus cr�e avec succ�s");
	}
	
	public void createBox(){
		res = ui.getBusName();
		res2 = ui.getBoxName();
		int maxSize = ui.getBoxMaxSize();
		if (maxSize == 0){
			BusManager.getInstance().getBus(res).createBox(res2);			
		} else {
			BusManager.getInstance().getBus(res).createBox(res2, maxSize);
		}
		ui.print("La boite � �t� cr�e avec succ�s");
	}
	
	public void createMessage(){
		res = ui.getBusName();
		res2 = ui.getBoxName();
		String messageContent = ui.getMessage();
		if(res2.length() == 0){
			BusManager.getInstance().getBus(res).createMessage(messageContent);
		} else {
			BusManager.getInstance().getBus(res).createMessage(res2, messageContent);			
		}
		ui.print("Message ajout� avec succ�s !");
	}
	
//SHOW
	public void show(){
		res = ui.showCommand();
		while (res.length() == 0){ //Avoid the StringIndexOutOfBoundsException
			res = ui.showCommand();				
		}
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
			ui.printError("Cette commande n'existe pas, veuillez r�essayer");
			break;
		}
	}
	
	public void showBusMessages(){
		
	}
	
	public void showBoxMessages(){
		
	}
	
	public void showBusesNames(){
		ui.print("Liste des bus :");
		for(String busName : BusManager.getInstance().getBusesNames()){
			ui.print(busName);
		}
	}
	
	public void showBoxesNames(){
		
	}
	
//DELETE
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
			ui.printError("Cette commande n'existe pas, veuillez r�essayer");
			break;
		}
	}
	
	public void deleteBus(){
		res = ui.getBusName();
		BusManager.getInstance().deleteBus(res);
		ui.print("Le bus '"+res+"' a �t� supprim�");
	}
	
	public void deleteBox(){
		String busName = ui.getBusName();
		String boxName = ui.getBoxName();
		BusManager.getInstance().getBus(busName).deleteBox(boxName);
		ui.print("La boite '"+boxName+"' a �t� supprim�");
	}
	
	public void deleteMessages(){
		String busName = ui.getBusName();
		String boxName = ui.getBoxName();
		ui.print("Supprimer les messages ant�rieures � : ");
		resIntList = ui.getTime();
		int day = resIntList.get(0);
		int hour = resIntList.get(1);
		int minute = resIntList.get(2);
		int second = resIntList.get(3);
		BusManager.getInstance().getBus(busName).getBox(boxName).deleteOlderMessage(day, hour, minute, second);
		ui.print("Les messages ant�rieurs � la date indiqu�e ont �t� supprim�s");
	}
}