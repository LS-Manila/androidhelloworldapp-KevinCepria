package Josephus;


import java.awt.Color;
import java.util.Scanner;

import acm.graphics.GLabel;
import acm.program.*;
public class Josephus<E> extends GraphicsProgram {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPeople;
	private int k, i,index, temp, y;
	private E name;
	private int choice;


	private GLabel title= new GLabel("Josephus Problem");
	MyLinkedList<E> Josephus = new MyLinkedList<E>();
	MyLinkedList<Integer> autoJosephus = new MyLinkedList<Integer>();
	int offset = 3;

	Scanner reader1= new Scanner(System.in);
	Scanner reader2= new Scanner(System.in);
	Scanner reader3= new Scanner(System.in);
	Scanner reader4= new Scanner(System.in);
	Scanner reader5= new Scanner(System.in);


	public void run(){
		Josephus.createlist();
		autoJosephus.createlist();
		add(title, 10,12);
		main();
	}


	public void eliminate(){

		if(y==1){
			if(Josephus.size()==numPeople){
				temp=0;
				temp=(temp+k)%Josephus.size();
			}
			else{
				temp=(temp+k-1)%Josephus.size();
			}
			if(temp==0){
				temp=Josephus.size();

			}
			System.out.println("Person "+temp+"--> "+Josephus.get(temp)+" HAS BEEN ELIMINATED");
			Josephus.remove(temp);
			System.out.println("\n");
		}

		else if(y==2){
			if(autoJosephus.size()==numPeople){
				temp=0;
				temp=(temp+k)%autoJosephus.size();
			}
			else{
				temp=(temp+k-1)%autoJosephus.size();
			}
			if(temp==0){
				temp=autoJosephus.size();

			}
			System.out.println("Person "+"--> "+autoJosephus.get(temp)+" HAS BEEN ELIMINATED");
			autoJosephus.remove(temp);
		}
	}

	public void main(){
		while(true){
			numparticipants();
			k();
			add();
			displaylist();
			Elimination();
			displaymessage();
		}
	}

	public void displaylist(){
		refresh();
		add(title,10,12);
		if(y==1){
			for(i = 1;i <=Josephus.size();i++){	 
				GLabel item= new GLabel((i)+") "+ Josephus.get(i)+" ");
				add(item, (getWidth() - item.getWidth())/2, getWidth()/10 + i * (item.getHeight() + offset));
			}
		}
		else if(y==2){
			for(i = 1;i <=autoJosephus.size();i++){	 
				GLabel item= new GLabel("Person-->"+ autoJosephus.get(i));
				add(item, (getWidth() - item.getWidth())/2, getWidth()/10 + i * (item.getHeight() + offset));
			}	
		}
	}


	public void displaymessage(){

		i=i+2;
		if(y==1){
			GLabel messg= new GLabel("Playing the Josephus Game with "+ numPeople+ " people, eliminating every "+ k+"th person, leaves person-->"+Josephus.get(1)+" as the last survivor.");
			add(messg, 10, getWidth()/10 + i * (messg.getHeight() + offset));
		}
		else if(y==2){
			GLabel messg= new GLabel("Playing the Josephus Game with "+ numPeople+ " people, eliminating every "+ k+"th person, leaves person-->"+autoJosephus.get(1)+" as the last survivor.");
			add(messg, 10, getWidth()/10 + i * (messg.getHeight() + offset));	
		}
	}

	private void refresh(){
		removeAll();
		setBackground(Color.WHITE);
	}



	public void Elimination(){
		System.out.println("1) Eliminate One by One");
		System.out.println("2) Eliminate ALL");

		System.out.print("Enter choice: ");
		do{

			try {
				choice=reader4.nextInt();
			}
			catch (Exception ex){
				System.err.println("Invalid Input or Choice is not in Range!");			
				reader4.nextLine();
				System.out.println("ENTER CHOICE AGAIN:\n ");
				Elimination();
			}
			switch(choice){
			case 1:

				if(y==1){

					eliminate();
					displaylist();

				}
				else if(y==2){
					eliminate();
					displaylist();

				}
				break;

			case 2:

				if(y==1){
					do{

						eliminate();
						displaylist();
					}while(Josephus.size()!=1);
				}
				if(y==2){
					do{
						eliminate();
						displaylist();
					}while(autoJosephus.size()!=1);
				}
				break;

			default:
				System.err.println("Please enter a valid number!\n");
				Elimination();


			}


		}while(autoJosephus.size()>1||Josephus.size()>1);
	}

	@SuppressWarnings("unchecked")
	public void add(){
		System.out.println("1) Enter names manually");
		System.out.println("2) Enter names automatically(Format is Person x)");
		System.out.print("Enter Choice: ");

		try {
			y=reader5.nextInt();
		}
		catch (Exception ex){
			System.err.println("Invalid Input or Choice is not in Range!");			
			reader5.nextLine();
			System.out.println("ENTER CHOICE AGAIN:\n ");
			add();
		}
		switch(y){
		case 1:

			System.out.println("Please Enter The names of each person: ");
			for(index=1;index<=numPeople;index++){
				System.out.print("Person "+index+"--> ");
				name=(E) reader3.nextLine();
				Josephus.add(index,name);
			}
			System.out.println("PEOPLE HAVE BEEN ADDED IN THE LIST!");
			break;

		case 2:

			for(index=1;index<=numPeople;index++){
				autoJosephus.add(index, index);

			}
			System.out.println("PEOPLE HAVE BEEN ADDED IN THE LIST!");
			break;

		default:
			System.err.println("Please enter a valid number!\n");
			add();
		}
	}

	public void numparticipants(){
		System.out.print("\n\nEnter Number of People: ");

		try {
			numPeople=reader1.nextInt();
		}
		catch (Exception ex){
			System.err.println("Invalid Input!");	
			reader1.nextLine();
			System.out.println("ENTER CHOICE AGAIN: ");
			numparticipants();
		}

	}

	public void k (){
		removeall();
		displaylist();
		System.out.print("Eliminate Every kth Person: ");

		try {
			k=reader2.nextInt();
		}
		catch (Exception ex){
			System.err.println("Invalid Input!");			
			reader2.nextLine();
			System.out.println("ENTER CHOICE AGAIN: ");
			k();
		}
	}

	public void removeall(){
		if (y==1){
			do{
				Josephus.remove(1); 
			}while(Josephus.size()!=0);
		}
		else if (y==2){
			do{
				autoJosephus.remove(1); 
			}while(autoJosephus.size()!=0);
		}
	}

}
