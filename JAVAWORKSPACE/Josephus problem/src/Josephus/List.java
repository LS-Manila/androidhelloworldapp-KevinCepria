package Josephus;

public interface List<E> {


	
	public void createlist ();
	
	
	public void add(int index, E item) ;
	
	
	public void remove (int index);
	
	
	public E get(int index);
	
	
	public int size ();
	
	
	public boolean isEmpty();
	
	
	public Node<E> find(int index);
	
	public void removeall();
	
	

}
