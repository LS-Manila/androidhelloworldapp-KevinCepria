import java.awt.Color;
import java.util.Scanner;

import acm.graphics.*;
import acm.program.*;

public class Main<E> extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	MyMatrix<Integer> matrix1=new MyMatrix<Integer>();
	MyMatrix<Integer> matrixSum=new MyMatrix<Integer>();
	MyMatrix<Integer> matrix2=new MyMatrix<Integer>();
	MyLinkedList<Integer> matrixtolist= new MyLinkedList<Integer>();
	MyStack<Integer> matrixtostack= new MyStack<Integer>();
	MyQueue<Integer> matrixtoqueue= new MyQueue<>();


	Scanner reader1= new Scanner(System.in);
	Scanner reader2= new Scanner(System.in);
	Scanner reader3= new Scanner(System.in);
	Scanner reader4= new Scanner(System.in);
	Scanner reader5= new Scanner(System.in);
	Scanner reader6= new Scanner(System.in);
	Scanner reader7= new Scanner(System.in);
	Scanner reader8= new Scanner(System.in);
	Scanner reader9= new Scanner(System.in);
	Scanner reader10= new Scanner(System.in);
	Scanner reader11= new Scanner(System.in);
	Scanner reader12= new Scanner(System.in);
	Scanner reader13= new Scanner(System.in);
	Scanner reader14= new Scanner(System.in);
	Scanner reader15= new Scanner(System.in);
	Scanner reader16= new Scanner(System.in);
	Scanner reader17= new Scanner(System.in);
	private GLabel title= new GLabel("");

	private int row, column, choice, choice1,choice2,choice3,choice4,choice5,choice6,choice7,choice8, i;
	private int offset=3;
	static Integer item;
	public void run(){
		add(title, 10,12);	
		main();
		submenu();
	}


	private void main(){
		System.out.print("1)Enter number of rows: ");
		row=matrix1.MAX1=reader2.nextInt();
		System.out.print("2)Enter number of columns: ");
		column=matrix1.MAX2=reader3.nextInt();
		matrix1.createMatrix();
		System.out.println("MATRIX TO BE MADE IS A "+row+"x"+column+" MATRIX");
		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				System.out.print("Element "+i+j+"-->");
				item=reader4.nextInt();
				matrix1.add(item);
			}
			displaymatrix();
		}


	}

	private void submenu(){
		while (true){
			System.out.println("1)Convert Matrix --> LIST");
			System.out.println("2)Convert Matrix --> STACK");
			System.out.println("3)Convert Matrix --> QUEUE");
			System.out.println("4)ADD with another Matrix");
			System.out.print("ENTER CHOICE: ");
			choice=reader1.nextInt();
			switch(choice){
			case 1:
				matToList();
				displaylist();
				mainlist();


				break;

			case 2:
				matToStack();
				displaystack();
				mainstack();
				break;

			case 3:
				matToQueue();
				displayqueue();
				mainqueue();

			case 4:
				addmatrices();
				break;
			}
		}
	}


	private void addmatrices(){
		matrix2.createMatrix();
		matrixSum.createMatrix();
		System.out.print("1)Enter number of rows: ");
		row=matrix2.MAX1=matrixSum.MAX1=reader2.nextInt();
		System.out.print("2)Enter number of columns: ");
		column=matrix2.MAX2=matrixSum.MAX2=reader3.nextInt();
		if(matrix1.MAX1*matrix2.MAX2==matrix2.MAX1*matrix2.MAX2){
			System.out.println("MATRIX TO BE MADE AND THE SUM IS A "+row+"x"+column+" MATRIX");
			matrix2.createMatrix();
			matrixSum.createMatrix();
			for(int i=1;i<=row;i++){
				for(int j=1;j<=column;j++){
					System.out.print("Element "+i+j+"-->");
					item=reader16.nextInt();
					matrix2.add(item);
				}

			}
			displaymatrix2();
			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
					matrixSum.item[i][j]=matrix1.item[i][j]+matrix2.item[i][j];
				}

			}

			displaymatrixSum();

			matrix1=matrixSum;

		}
		else{
			System.out.print("THE TWO MATRICES SHOULD BE EQUAL IN TERMS OF ROW AND COLUMN!");
			System.out.print("TRY AGAIN!");
			addmatrices();
		}
	}

	private void refresh(){
		removeAll();
		setBackground(Color.WHITE);
	}
	public void displaymatrix(){
		refresh();
		add(title,10,12);

		for(i = 0;i <row;i++){	 
			for(int j=0;j<column;j++){
				GLabel item= new GLabel("|"+ matrix1.item[i][j]+"|");
				add(item, offset+(j*(getWidth() - item.getWidth())/9), getWidth()/10 + (i+offset) * (item.getHeight() + offset));
			}
		}
		i++;
		GLabel item= new GLabel("MATRIX 1");
		add(item,10, getWidth()/10 + (i+offset) * (item.getHeight() + offset));

	}

	public void displaymatrix2(){

		for(i = 0;i <row;i++){	 
			for(int j=0;j<column;j++){
				GLabel item= new GLabel("|"+ matrix2.item[i][j]+"|");
				add(item, 200+offset+(j*(getWidth() - item.getWidth())/9), getWidth()/10 + (i+offset) * (item.getHeight() + offset));
			}
		}
		i++;
		GLabel item= new GLabel("MATRIX 2");
		add(item,200, getWidth()/10 + (i+offset) * (item.getHeight() + offset));
		GLabel plus= new GLabel("+");
		add(plus,130, getWidth()/10 + (i+offset) * (item.getHeight() + offset));


	}

	public void displaymatrixSum(){

		for(i = 0;i <row;i++){	 
			for(int j=0;j<column;j++){
				GLabel item= new GLabel("|"+ matrixSum.item[i][j]+"|");
				add(item, 400+offset+(j*(getWidth() - item.getWidth())/9), getWidth()/10 + (i+offset) * (item.getHeight() + offset));
			}
		}
		i++;
		GLabel item= new GLabel("MATRIX SUM");
		add(item,400, getWidth()/10 + (i+offset) * (item.getHeight() + offset));
		GLabel equals= new GLabel("=");
		add(equals,340, getWidth()/10 + (i+offset) * (item.getHeight() + offset));


	}
	private void displaylist(){

		add(title,10,12);

		for(i = 1;i <=matrixtolist.size();i++){	 
			GLabel item= new GLabel((i)+") "+ matrixtolist.get(i)+" ");
			add(item, (getWidth() - item.getWidth())/2, getWidth()/10 + i * (item.getHeight() + offset));
		}

	}

	private void displaystack(){

		add(title,10,12);

		for(i = 1;i <=matrixtostack.size();i++){	 
			GLabel item= new GLabel((i)+") "+ matrixtostack.get(i)+" ");
			add(item,(getWidth() - item.getWidth())/2, getWidth()/10 + i * (item.getHeight() + offset));
		}


	}

	private void displayqueue(){

		add(title,10,12);

		for(i = 1;i <=matrixtoqueue.size();i++){	 
			GLabel item= new GLabel((i)+") "+ matrixtoqueue.get(i)+" ");
			add(item, (getWidth() - item.getWidth())/2, getWidth()/10 + i * (item.getHeight() + offset));
		}

	}

	private void mainlist(){
		while (true){
			System.out.println("\nMATRIX CONVERTED TO LIST!");
			System.out.println("LIST");
			System.out.println("1)Add integer");
			System.out.println("2)Remove integer");
			System.out.println("3)Convert back to matrix ");
			System.out.print("Enter choice: ");
			choice1=reader4.nextInt();
			switch(choice1){
			case 1: 
				System.out.print("Enter INDEX: ");
				choice2=reader5.nextInt();
				System.out.print("Enter Integer: ");
				choice3=reader6.nextInt();
				matrixtolist.add(choice2,choice3);
				System.out.println("INTEGER ADDED!");
				refresh();
				displaylist();
				break;

			case 2:
				System.out.print("Enter INDEX: ");
				choice4=reader7.nextInt();
				matrixtolist.remove(choice4);
				System.out.print("INTEGER REMOVED!");
				refresh();
				displaylist();
				break;

			case 3:
				System.out.print("Enter new ROW: ");
				row=matrix1.MAX1=reader8.nextInt();
				System.out.print("Enter new COLUMN: ");
				column=matrix1.MAX2=reader9.nextInt();
				if(matrixtolist.size()!=row*column){
					System.out.print("LIST SIZE DOES NOT MATCH THE MATRIX! TRY AGAIN!");
					mainlist();
				}
				else{
					matrix1.createMatrix();
					listToMatrix();
					displaymatrix();
					System.out.println("LIST CONVERTED TO MATRIX!");
					submenu();}
				break;

			default:
				System.out.println("Out of RANGE! Enter a valid choice!");
				mainlist();


			}
		}
	}

	public void mainstack(){
		while (true){
			System.out.println("\nMATRIX CONVERTED TO STACK!");
			System.out.println("STACK");
			System.out.println("1)Push integer");
			System.out.println("2)Pop TOP OF STACK");
			System.out.println("3)Convert back to matrix ");
			System.out.print("Enter choice: ");
			choice5=reader10.nextInt();
			switch(choice5){
			case 1: 

				System.out.print("Enter Integer: ");
				choice6=reader11.nextInt();
				matrixtostack.push(choice6);
				System.out.println("INTEGER PUSHED!");
				refresh();
				displaystack();
				break;

			case 2:
				matrixtostack.pop();
				System.out.print("INTEGER POP!");
				refresh();
				displaystack();
				break;

			case 3:
				System.out.print("Enter new ROW: ");
				row=matrix1.MAX1=reader12.nextInt();
				System.out.print("Enter new COLUMN: ");
				column=matrix1.MAX2=reader13.nextInt();
				if(matrixtostack.size()!=row*column){
					System.out.print("STACK SIZE DOES NOT MATCH THE MATRIX! TRY AGAIN!");
					mainstack();
				}
				else{
					matrix1.createMatrix();
					stackToMatrix();
					displaymatrix();
					System.out.println("STACK CONVERTED TO MATRIX!");
					submenu();}
				break;

			default:
				System.out.println("Out of RANGE! Enter a valid choice!");
				mainstack();


			}
		}
	}

	public void mainqueue(){
		while (true){
			System.out.println("\nMATRIX CONVERTED TO QUEUE!");
			System.out.println("QUEUE");
			System.out.println("1)Add integer");
			System.out.println("2)Remove integer");
			System.out.println("3)Convert back to matrix ");
			System.out.print("Enter choice: ");
			choice7=reader14.nextInt();
			switch(choice7){
			case 1: 

				System.out.print("Enter Integer: ");
				choice8=reader15.nextInt();
				matrixtoqueue.add(choice8);
				System.out.println("INTEGER ADDED!");
				refresh();
				displayqueue();
				break;

			case 2:

				matrixtoqueue.remove();
				System.out.print("INTEGER REMOVED!");
				refresh();
				displayqueue();
				break;

			case 3:
				System.out.print("Enter new ROW: ");
				row=matrix1.MAX1=reader8.nextInt();
				System.out.print("Enter new COLUMN: ");
				column=matrix1.MAX2=reader9.nextInt();
				if(matrixtoqueue.size()!=row*column){
					System.out.print("QUEUE SIZE DOES NOT MATCH THE MATRIX! TRY AGAIN!");
					mainqueue();
				}
				else{
					matrix1.createMatrix();
					queueToMatrix();
					displaymatrix();
					System.out.println("QUEUE CONVERTED TO MATRIX!");
					submenu();}
				break;

			default:
				System.out.println("Out of RANGE! Enter a valid choice!");
				mainqueue();


			}
		}
	}

	public void matToList()  {
		int a=1;
		matrixtolist.createlist();
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				matrixtolist.add(a, (Integer) matrix1.item[i][j]);
				a++;
			}
		}

	}


	public void listToMatrix() {

		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				System.out.println("Element "+i+j+"-->"+matrixtolist.get(1));
				matrix1.add(matrixtolist.get(1));
				matrixtolist.remove(1);		

			}
		}
	}


	public void matToStack() {


		matrixtostack.createstack();
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				matrixtostack.push((Integer)matrix1.item[i][j]);

			}
		}



	}


	public void stackToMatrix() {

		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				System.out.println("Element "+i+j+"-->"+matrixtostack.get(matrixtostack.size()));
				matrix1.add(matrixtostack.get(matrixtostack.size()));
				matrixtostack.pop();		

			}
		}
	}


	public void matToQueue() {

		matrixtoqueue.createQueue();
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				matrixtoqueue.add((Integer)matrix1.item[i][j]);


			}
		}

	}


	public void queueToMatrix() {
		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				System.out.println("Element "+i+j+"-->"+matrixtoqueue.get(1));
				matrix1.add(matrixtoqueue.get(1));
				matrixtoqueue.remove();		

			}
		}

	}


}
