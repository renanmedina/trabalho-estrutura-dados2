package models;

public class Client {
	private int cod_cli;
	private String name;
	private String phone;
	private String address;
	
	public Client(int cod, String nm, String ph, String addr){
		this.cod_cli = cod;
		this.name = nm;
		this.phone = ph;
		this.address = addr;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNumber() {
		return this.phone;
	}
	
	public int getClientCode() {
		return this.cod_cli;
	}
	
	public String toString() {
		return Integer.toString(this.getClientCode());
	}
	
	public String getOutputString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente #".concat(this.toString()));
		sb.append("\nNome: ".concat(this.getName()));
		sb.append("\nTelefone: ".concat(this.getPhoneNumber()));
		sb.append("\nEndereço: ".concat(this.getAddress()));
		return sb.toString();
	}
}
