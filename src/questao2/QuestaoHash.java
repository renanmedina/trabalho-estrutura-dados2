package questao2;

import javax.swing.JOptionPane;

import models.Employee;

public class QuestaoHash {

	static HashTable<Employee> employees_list = new HashTable<Employee>(20);
	static int opt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do {
			String menu = drawMenu();
			String op = JOptionPane.showInputDialog(menu);
			try {
				if(op == null)
					throw new NullPointerException();
				
				opt = Integer.parseInt(op);
				switch(opt) {
					case 1:
						addEmployee();
						break;
					case 2:
						increaseSalaryAll();
						break;
					case 3:
						if(!employees_list.isEmpty())
							findSalariesAbove500();
						else
							JOptionPane.showMessageDialog(null, "A lista de funcionarios est� vazia");
						break;
					case 4:
						if(!employees_list.isEmpty())
							listEmployees();
						else
							JOptionPane.showMessageDialog(null, "A lista de funcion�rios est� vazia");
						break;
					case 5:
						deleteEmployeeByName();
						break;
				}
			
				opt = (opt == 6 ? opt : 0);
			}
			catch(NullPointerException ne) {
				opt = -1;
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
				opt = 0;
			}
		} while(opt == 0);
	}
	
	private static void deleteEmployeeByName() {
		String name = JOptionPane.showInputDialog("Digite o nome do funcionario: ");
		if(employees_list.removeByName(new Employee(name)))
			JOptionPane.showMessageDialog(null, "Funcion�rio ".concat(name).concat(" removido com sucesso!"));
		else
			JOptionPane.showMessageDialog(null, "Funcion�rio n�o cadastrado!");
	}

	private static void listEmployees() {
		HashElement<Employee> auxil;
		for ( int i = 0; i < employees_list.getSize(); i++){
			auxil = employees_list.getAtIndex(i);
			while(auxil != null){
				Employee emp = (Employee) auxil.key;
				JOptionPane.showMessageDialog(null, emp.getOutputString());
				auxil = auxil.next;
			}
		}
	}

	private static void findSalariesAbove500() {
		HashElement<Employee> auxil;
		for ( int i = 0; i < employees_list.getSize(); i++){
			auxil = employees_list.getAtIndex(i);
			while(auxil != null){
				Employee emp = (Employee) auxil.key;
				if(emp.getSalary() > 500)
					JOptionPane.showMessageDialog(null, emp.getOutputString());
				auxil = auxil.next;
			}
		}
	}

	private static void increaseSalaryAll() {
		HashElement<Employee> auxil;
		Float increase = Float.parseFloat(JOptionPane.showInputDialog("Informe o percentual de aumento de sal�rio: "));
		for ( int i = 0; i < employees_list.getSize(); i++){
			auxil = employees_list.getAtIndex(i);
			while(auxil != null){
				Employee emp = (Employee) auxil.key;
				emp.increaseSalaryByPercentage(increase);
				auxil = auxil.next;
			}
		}
	}

	private static void addEmployee() {
		int code = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do funcion�rio: "));
		String name = JOptionPane.showInputDialog("Digite o nome do funcion�rio: "); 
		float salary = Float.parseFloat(JOptionPane.showInputDialog("Digite o salario do funcion�rio: "));
		Employee emp = new Employee(code, name, salary);
		employees_list.add(emp);
	}

	public static String drawMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------------------------- MENU --------------------------------\n");
		sb.append("1. Cadastrar funcion�rio \n");
		sb.append("2. Conceder aumento percentual para todos os funcion�rios \n");
		sb.append("3. Consultar a soma salarial dos funcion�rios com sal�rio superior a 500\n");
		sb.append("4. Consultar todos os funcion�rios \n");
		sb.append("5. Excluir por nome\n");
		sb.append("6. Sair\n");
		return sb.toString();
	}

}
