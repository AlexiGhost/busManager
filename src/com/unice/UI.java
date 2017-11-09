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
	/**Return the start content
	 * @return String*/
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
	/**Just print something*/
	public void print(String text){
		System.out.println(text);
	}
	/**Print an error*/
	public void printError(String text){
		System.err.println(text);
	}
	/**Print info about box*/
	public void printBoxInfo(){
		System.out.println("Laisser vide pour utiliser la boite par défaut.");
	}

//CREATE
	/**Return the create command content
	 * @return String*/
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
	/**Return the show command content
	 * @return String*/
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
	/**Return the delete command content
	 * @return String*/
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
	/**Return the read bus name
	 * @return String - The bus name*/
	public String getBusName() {
		System.out.print("Nom du bus : ");
		res = reader.nextLine();
		return res;
	}
	/**Return the read bus type name
	 * @return String - BusType name*/
	public String getBusType(){
		System.out.println("Liste des types de bus disponibles");
		for(Map.Entry<String, Integer> busType : BusType.getInstance().entrySet()) {
		    System.out.println("\t"+busType.getKey());
		}
		System.out.print("Type de bus : ");
		res = reader.nextLine();
		return res.toLowerCase();
	}
	/**Return the read box name
	 * @return String - Box name*/
	public String getBoxName() {
		System.out.print("Nom de la boite : ");
		res = reader.nextLine();
		return res;
	}
	/**Return the read max size of a box
	 * @return int - The max size*/
	public int getBoxMaxSize(){
		System.out.print("Taille maximale d'un message (en caractère)\n"+
				"(0 = pas de limite) : ");
		resInt = reader.nextInt();
		return resInt;
	}
	/**Return the read message content
	 * @return String - message content*/
	public String getMessage(){
		System.out.println("Contenu du message :");
		res = reader.nextLine();
		return res;
	}
	/**Return a 'date'
	 * @return List = Integers which define the date*/
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
