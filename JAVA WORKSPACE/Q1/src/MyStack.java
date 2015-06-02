
public class MyStack<E> implements Stack<E>{
     private Node<E> head;
     
     private int TOS;
       
 
   public void createstack(){   
      head = null;
      TOS=0;
   } 

   public void push(E item)  {
       
        if(TOS==0){
		Node<E> newNode = new Node<E>(item);
		newNode.setNext(head);
		head = newNode;
		TOS++;
        }
        else
        {
        Node<E> newNode = new Node<E>(item);
        Node<E> previous = find(TOS);
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
        TOS++;
        }
   }

   public void pop() {
      
	   Node<E> secondtocurrent = find(TOS-1);
	   secondtocurrent.setNext(null);
         
            TOS--;
   }

   public boolean isEmpty(){
           return TOS == 0;          
   }

   public E get(int index) {
      
             Node<E> current = find(index);
             E item = current.getItem();
             return item;
      
   }

   public int size(){
           return TOS;
   }

   
   public Node<E> find(int index){
   Node<E> current = head;
 
   for (int i = 1; i < index; i++)
   { 
	   
      current = current.getNext(); 
   }

   return current;
   } 
   
   public E getTOS(){
	   Node<E> current=find(TOS);
	   E item= current.getItem();
	   return item;
   }
   
   public void converToMatrix(){
	   //MyMatrix<E> matrix1 = new MyMatrix<E>();
	  
   }
}//end class
