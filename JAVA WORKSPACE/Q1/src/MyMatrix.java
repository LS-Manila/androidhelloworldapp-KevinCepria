

public class MyMatrix <E> implements Matrix<E>{
private int row, column;
private int numItems;
int MAX1,MAX2;
MyLinkedList<Integer> matrixtolist= new MyLinkedList<Integer>();
public E item[][];
	
	@SuppressWarnings("unchecked")
	public void createMatrix() {
		row=-1;
		column=-1;
		item = (E[][]) new Integer[MAX1][MAX2];
		numItems=0;
	}

	

	
	public void add(E item) {
		if(numItems==0){
			 row++;
			 column++;
			 this.item[row][column]=item;
			 column++;
			 
		}
		else {
			if(column<MAX2){
			this.item[row][column]=item;
			column++;
			}
			else if (column>=MAX2){
			column=0;
			row++;
			this.item[row][column]=item;
			column++;
			}
		}
		    numItems++;
	    
	}




	
	public int row() {
		return row;
	}
	
	public int column() {
		return column;
	}
	



	public boolean isEmpty() {
		if(numItems==0){
			return true;
			}
		else{
		return false;
		}
	}
	
	public void emptymatrix(){
		numItems=0;
		row=-1;
		column=-1;
		
	}

	
	

}
