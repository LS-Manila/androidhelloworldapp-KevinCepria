

public class MyQueue<E> implements Queue<E> {

	private int numItems;
	private Node<E> head;

	public void createQueue() {
		head = new Node<E>(null);
		numItems = 0;

	}

	public void add(E item) {
		if (numItems == 0) {
			Node<E> newNode = new Node<E>(item);
			newNode.setNext(head);
			head.setNext(newNode);
		 
		} else {
			Node<E> newNode = new Node<E>(item);
			Node<E> previous = find(numItems);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		}
		numItems++;

	}

	public void remove() {
 
			Node<E> frontNode = find(1);
			head.setNext(frontNode.getNext());	
		    numItems--;
		    

	}

	public E get(int index) {
		Node<E> current = find(index);
		E item = current.getItem();
		return item;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public int size() {
		return numItems;
	}

	public E getFront() {
		Node<E> current = find(1);
		E item = current.getItem();
		return item;

	}

	public E getRear() {
		Node<E> current = find(numItems);
		E item = current.getItem();
		return item;
	}



	public Node<E> find(int index) {

		Node<E> current = head.getNext();
		if (numItems != 0) {
			

			for (int i = 1; i < index; i++) {

				current = current.getNext();
			}

		}
		return current;
	}

}
