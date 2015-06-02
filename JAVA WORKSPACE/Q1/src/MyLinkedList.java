
public class MyLinkedList<E> implements List<E>{
       Node<E> head;
       int numItems;
       
 
   public void createlist(){   
      numItems = 0;
      head = null;
   } 

   public void add(int index, E item) throws ListIndexOutOfBoundsException {
       if ( index > 0 && index <= numItems + 1){
             if (index == 1){
		Node<E> newNode = new Node<E>(item);
		newNode.setNext(head);
		head = newNode;
		
            }
	    else
            {
		Node<E> newNode = new Node<E>(item);
		Node<E> previous = find(index-1);
		newNode.setNext(previous.getNext());
		previous.setNext(newNode);
            }
	    numItems++;
       	    }
       else
            throw new ListIndexOutOfBoundsException("ADD ERROR: List Index Out Of Bounds");
   }

   public void remove(int index) throws ListIndexOutOfBoundsException{
       if ( index > 0 && index <= numItems + 1){
          if (index == 1){ 
              head = head.getNext(); 
          }
          else{
             Node<E> previous = find(index-1);
             Node<E> current = previous.getNext();
             previous.setNext(current.getNext());
           }
           numItems--;
       }
      else
            throw new ListIndexOutOfBoundsException("REMOVE ERROR: List Index Out Of Bounds");
   }

   public boolean isEmpty(){
           return numItems == 0;          
   }

   public E get(int index) throws ListIndexOutOfBoundsException{
       if ( index > 0 && index <= numItems + 1){
             Node<E> current = find(index);
             E item = current.getItem();
             return item;
       }
       else
            throw new ListIndexOutOfBoundsException("GET ERROR: List Index Out Of Bounds");
   }

   public int size(){
           return numItems;
   }

   
   public Node<E> find(int index){
   Node<E> current = head;
 
   for (int i = 1; i < index; i++)
   { 
	   
      current = current.getNext(); 
   }

   return current;
   } 
   
   public void removeall() {
		numItems=0;
		
	}




}
