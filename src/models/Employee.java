package models;

public class Employee {

	private String name;
	private float salary;
	private int code;
	
	public Employee(int c, String n, float sl) {
		this.name = n;
		this.salary = sl;
		this.code = c;
	}
	
	public Employee(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getSalary() {
		return this.salary;
	}
	
	public int getEmployeeCode() {
		return this.code;
	}
	
	public String toString() {
		return Integer.toString(this.getEmployeeCode());
	}
	
	@Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Employee))
            return false;
        if (obj == this)
            return true;

        Employee emp = (Employee) obj;
        return emp.getName().toLowerCase().equals(this.getName().toLowerCase());
    }
	
	public void increaseSalaryByPercentage(float by_amount) {
		this.salary += (this.salary * (by_amount / 100));
	}
	
	public String getOutputString() {
		StringBuilder sb = new StringBuilder();
		sb.append("C�digo do funcion�rio: #".concat(Integer.toString(this.getEmployeeCode())));
		sb.append("\nNome do funcion�rio: ".concat(this.getName()));
		sb.append("\nSal�rio do funcion�rio: R$".concat(String.format("%.2f", this.getSalary())));
		return sb.toString();
	}
}
