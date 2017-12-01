package models;

public class Account {
	
	private int acc_number;
	private float amount;
	private Client cli;
	
	Account(int ac_n, float am){
		this.acc_number = ac_n;
		this.amount = am;
	}
	
	Account(int ac_n, float am, Client cl){
		this.acc_number = ac_n;
		this.amount = am;
		this.cli = cl;
	}
	
	public float getAmount() {
		return this.amount;
	}
	
	public int getAccNumber() {
		return this.acc_number;
	}
	
	public Client getClient() {
		return this.cli;
	}
}
