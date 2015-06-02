

public interface Stack<E> {

	
	public void createstack ();
	
	
	public void push(E item) ;
	
	
	public void pop ();
	
	
	public E get(int index);
	
	
	public int size ();
	
	
	public boolean isEmpty();
	
	
	public Node<E> find(int index);
	
	
	public E getTOS();
	
	
}
