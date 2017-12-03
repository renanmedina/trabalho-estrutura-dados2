package questao2;

import javax.swing.JOptionPane;

public class HashTable<T> {
	
	private HashElement<T> table[];
	private int items = 0;
	private int size;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.table = new HashElement[size];
		this.size = size;
	}
	
	public void add(T el) {
		HashElement<T> hel = new HashElement<T>(el);
		int index = this.hashing(el);
		hel.next = this.table[index];
		this.table[index] = hel;
		this.items++;
	}
	
	public void remove(T el) {
		int index = this.hashing(el);
		HashElement<T> auxil;
		if (this.table[index] != null){
			if (this.table[index].key.equals(el))
				this.table[index] = this.table[index].next;
			else{
				auxil = this.table[index].next;
				HashElement<T> previous = this.table[index];
				while(auxil != null && !auxil.key.equals(el)){
					previous = auxil;
					auxil = auxil.next;
				}

				if (auxil != null)
					previous.next = auxil.next;
				else
					JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Elemento não está presente");
	}
	
	public boolean removeByName(T el) {
		HashElement<T> auxil;
		boolean removed = false;
		for(int i=0;i<this.size;i++) {
			if (this.table[i] != null){
				if (this.table[i].key.equals(el)) {
					this.table[i] = this.table[i].next;
					removed = true;
					this.items--;
				}
				else{
					auxil = this.table[i].next;
					HashElement<T> previous = this.table[i];
					while(auxil != null && !auxil.key.equals(el)){
						previous = auxil;
						auxil = auxil.next;
						removed = true;
						this.items--;
					}

					if (auxil != null)
						previous.next = auxil.next;
				}
			}
		}
		
		return removed;
	}
	
	
	public HashElement<T>[] getTable(){
		return this.table;
	}
	
	public HashElement<T> getAtIndex(int i) {
		return this.table[i];
	}
	
	public int getSize() {
		return this.size;
	}
	
	private int hashing(T el) {
		return (int) Integer.parseInt(el.toString()) % this.size;
	}
	
	public boolean isEmpty() {
		return this.items > 0;
	}
	
}
