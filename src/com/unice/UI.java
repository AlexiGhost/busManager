package com.unice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UI {

//Variables
	Scanner reader = new Scanner(System.in);
	String res;
	int resInt;
	//pre formated text
	String line = "------------------------------\n";

//START
	public String startCommand(){
		System.out.print(
				line+
				"Que souhaitez vous faire ?\n"+
				line+
				"c : Créer...\n"+
				"a : Afficher...\n"+
				"s : Supprimer...\n"+
				"q : Quitter\n"+
				line);
		res = reader.nextLine();
		return res;
	}
	public void print(String text){
		System.out.println(text);
	}
	public void printError(String text){
		System.err.println(text);
	}
	
	public void printBoxInfo(){
		System.out.println("Laisser vide pour utiliser la boite par défaut.");
	}

//CREATE
	public String createCommand(){
		System.out.print(
				line+
				"Vous souhaitez créer un(e) ...\n"+
				line+
				"1 : bus\n"+
				"2 : boite de message\n"+
				"3 : message\n"+
				line);
		res = reader.nextLine();
		return res;
	}
//SHOW	
	public String showCommand(){
		System.out.print(
				line+
				"Vous souhaitez afficher les ...\n"+
				line+
				"1 : Messages d'un bus\n"+
				"2 Messages d'une boite\n"+
				"3 Noms des bus existants\n"+
				"4 Noms des boites de message\n"+
				line);
		res = reader.nextLine();
		return res;
	}
//DELETE
	public String deleteCommand(){
		System.out.print(
				line+
				"Vous souhaitez supprimer ...\n"+
				line+
				"1 : un bus\n"+
				"2 : une boite de message\n"+
				"3 : des messages\n"+
				line);
		res = reader.nextLine();
		return res;
	}
//GETTER
	public String getBusName() {
		System.out.print("Nom du bus : ");
		res = reader.nextLine();
		return res;
	}
	
	public String getBusType(){
		System.out.println("Liste des types de bus disponibles");
		for(Map.Entry<String, Integer> busType : BusType.getInstance().entrySet()) {
		    System.out.println("\t"+busType.getKey());
		}
		System.out.print("Type de bus : ");
		res = reader.nextLine();
		return res;
	}
	
	public String getBoxName() {
		System.out.print("Nom de la boite : ");
		res = reader.nextLine();
		return res;
	}
	
	public int getBoxMaxSize(){
		System.out.print("Taille maximale d'un message (en caractère)\n"+
				"(0 = pas de limite) : ");
		resInt = reader.nextInt();
		return resInt;
	}
	
	public String getMessage(){
		System.out.println("Contenu du message :");
		res = reader.nextLine();
		return res;
	}
	
	public List<Integer> getTime() {
		List<Integer> resList = new ArrayList<>();
		System.out.print("Jours : ");
		resInt = reader.nextInt();
		resList.add(resInt);
		System.out.print("Heures : ");
		resInt = reader.nextInt();
		resList.add(resInt);
		System.out.print("Minutes : ");
		resInt = reader.nextInt();
		resList.add(resInt);
		System.out.print("Secondes : ");
		resInt = reader.nextInt();
		resList.add(resInt);
		return resList;
	}
}
