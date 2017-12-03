package questao2;

public class HashElement<T> {
	public HashElement next = null;
	public T key = null;
	
	public HashElement(T k) {
		this.key = k;
	}
}
