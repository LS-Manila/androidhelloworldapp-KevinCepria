



public interface Queue <E> {
	
	public void createQueue();
	
	public void add(E item);
	
	public void remove();
	
	public E get(int index);
	
	public boolean isEmpty();
	
	public int size();
	
	public E getFront();
	
	public E getRear();
	
	
	public Node<E> find(int index);
	
	
}
