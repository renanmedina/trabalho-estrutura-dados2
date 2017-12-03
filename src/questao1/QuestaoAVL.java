package questao1;
import models.Client;
import models.Account;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class QuestaoAVL {
	
	static AVLTree<Client> clients_tree = new AVLTree<Client>();
	static AVLTree<Account> accounts_tree = new AVLTree<Account>();
	static Scanner sc = new Scanner(System.in);
	
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
						addClient();
						break;
					case 2:
						addAccount();
						break;
					case 3:
						if(!clients_tree.isEmpty())
							listClients(clients_tree.root);
						else
							JOptionPane.showMessageDialog(null, "A lista de clientes está vazia");
						break;
					case 4:
						if(!accounts_tree.isEmpty())
							listAccounts(accounts_tree.root);
						else
							JOptionPane.showMessageDialog(null, "A lista de contas está vazia");
						break;
					case 5:
						listClientAccounts();
						break;
				}
			
				opt = (opt == 6 ? opt : 0);
			}
			catch(NullPointerException ne) {
				opt = -1;
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				opt = 0;
			}
		} while(opt == 0);
	}
	
	static void addClient() {
		int c = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente: "));
		String n = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		String t = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
		String e = JOptionPane.showInputDialog("Digite o endereço do cliente: ");
		Client cl = new Client(c, n, t, e);
		clients_tree.add(cl);
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
	}
	
	static void addAccount() {
		//try {
			int c = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente: "));
			Client auxcli = new Client(c, "", "", "");
			if(clients_tree.find(auxcli)) {
				int c_num = Integer.parseInt(JOptionPane.showInputDialog("\nNúmero da conta: "));
				float v = Float.parseFloat(JOptionPane.showInputDialog("\nValor disponível na conta: "));
				Account ac = new Account(c_num, c, v);
				accounts_tree.add(ac);
				JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
			}
			else
				JOptionPane.showMessageDialog(null, "Cliente não cadastrado ainda, favor cadastre o cliente primeiro");
		//}
		//catch(Exception e) {
		//	JOptionPane.showMessageDialog(null, "Ocorreu um problema na criação");
		//}
	}
	
	static void listClients(AVLNode<Client> e) {
		if (e != null){
			Client cli = (Client) e.element; // casting
			JOptionPane.showMessageDialog(null, cli.outputString());
			listClients(e.left_tree);
			listClients(e.right_tree);
		}
	}
	
	static void listAccounts(AVLNode<Account> e) {
		if (e != null){
			Account acc = (Account) e.element; // casting
			JOptionPane.showMessageDialog(null, acc.outputString());
			listAccounts(e.left_tree);
			listAccounts(e.right_tree);
		}
	}
	
	static void listClientAccounts() {
		try {
			int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente: "));
			AVLNode<Account> aux = accounts_tree.root;
			boolean find_atleast_one = false;
			while(aux != null) {
				Account ac = (Account) aux.element;
				if(ac.getClientID() == cod) {
					JOptionPane.showMessageDialog(null, ac.outputString());
					find_atleast_one = true;
				}
				if(aux.left_tree != null)
					aux = aux.left_tree;
				else if(aux.right_tree != null)
					aux = aux.right_tree;
				else
					aux = null;
			}
			
			if(!find_atleast_one)
				JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada para o cliente de código #".concat(Integer.toString(cod)));
		}
		catch(NullPointerException ne) {
			return;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "O código deve ser um número inteiro.");
			listClientAccounts();
		}
	}
	
	public static String drawMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("------------------- MENU -------------------\n");
		sb.append("1. Cadastrar clientes \n");
		sb.append("2. Cadastrar contas \n");
		sb.append("3. Mostrar clientes\n");
		sb.append("4. Mostrar contas \n");
		sb.append("5. Mostrar contas de cliente\n");
		sb.append("6. Sair\n");
		return sb.toString();
	}

}
