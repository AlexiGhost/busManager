package com.unice;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.start();
		BusManager.exportBusList("datas/buses");
	}
}
