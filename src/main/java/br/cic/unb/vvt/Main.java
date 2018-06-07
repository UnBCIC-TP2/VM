package br.cic.unb.vvt;

import java.util.Scanner;

public class Main {

	private VendingMachine vm;
	
	public Main() {
		vm = new VendingMachine(75);
	}
	
	public static void main(String args[]) {
		Main mainProgram = new Main();
		System.out.println("Welcome to our VendingMachine");
		
		mainProgram.mainMenu();
	}

	private void mainMenu() {
		System.out.println("Total available: " + vm.getCurrentValue());
		System.out.println("Select one of the following options");
		
		System.out.println("[1] Insert coins");
		System.out.println("[2] Remove coins");
		System.out.println("[3] Vend");
		System.out.println("[4] Exit");
		
		Scanner s = new Scanner(System.in);
		
		int option = Integer.parseInt(s.nextLine());
		
		switch(option) {
		 case 1: insert(); break;
		 case 2: vm.returnCoins(); break;
		 case 3: vm.vend(); break;
		 case 4: 
		  System.out.println("Returning your coins....");
		  System.out.println("Bye..."); break;
		 default: System.out.println("Invalid option."); 
		}
		mainMenu();
	}
	
	public void insert() {
		System.out.println("Insert a coin");
		System.out.println("[1] 25");
		System.out.println("[2] 50");
		System.out.println("[3] 75");
		System.out.println("[4] Exit");

		Scanner s = new Scanner(System.in);
		
		int option = Integer.parseInt(s.nextLine());
		s.reset();
		switch(option) {
		 case 1: vm.insertCoin(new Coin(25)); break;
		 case 2: vm.insertCoin(new Coin(50)); break;
		 case 3: vm.insertCoin(new Coin(75)); break;
		 case 4: mainMenu();
		}
		System.out.println("More coins (yes/no)? "); 
		String repeat = s.nextLine();
		
		if(repeat.equals("yes")) {
			insert();
		}
		mainMenu();
	}
}
