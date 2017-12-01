package models;

public class Account {
	
	private int acc_number;
	private float amount;
	private int client_code;
	
	public Account(int ac_n, int client_id, float am){
		this.acc_number = ac_n;
		this.client_code = client_id;
		this.amount = am;
	}
	
	
	public float getAmount() {
		return this.amount;
	}
	
	public int getAccNumber() {
		return this.acc_number;
	}
	
	public int getClientID() {
		return this.client_code;
	}
	
	// override
	public String toString() {
		return Integer.toString(this.acc_number);
	}
	
	public String outputString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Número da conta:  #".concat(Integer.toString(this.getAccNumber())));
		sb.append("\nCódigo de cliente : #".concat(Integer.toString(this.getClientID())));
		sb.append("\nValor na conta: R$".concat(String.format("%.2f", this.getAmount())));
		return sb.toString();
	}
}
