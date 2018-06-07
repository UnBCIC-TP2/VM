package br.cic.unb.vvt;

public class VendingMachine {
	  
	private int value; 
	private int currentValue;
	private boolean enabled;
	
	public VendingMachine(int value) {
		this.value = value;
		currentValue = 0;
		enabled = false;
	}
	
	public void insertCoin(Coin c) {
		currentValue += c.getValue();
		enabled = currentValue >= value;
	}
	
	public void returnCoins() {
		enabled = false;
		currentValue = 0;
	}
	
	public void vend() {
		if(enabled) {
			System.out.println("================================");
			System.out.println("Get your drink!");
			System.out.println("================================\n");
			currentValue -= value;	
			enabled = currentValue > value;
		}
		else {
			System.out.println("Please, insert " + (value-currentValue) + " in coins. \n");
		}
		if(currentValue < 0) {
			throw new IllegalStateException();
		}
	}

	public int getCurrentValue() {
		return currentValue;
	}
	
	
}
