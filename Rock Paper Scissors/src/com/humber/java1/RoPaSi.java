/*
 * @author - Malhaar Patel (n01597720)
 */

package com.humber.java1;

import java.util.Scanner;
import java.util.Random;



public class RoPaSi {
	
	//Initializing and Declaring variables
	public static String value;
	public static int counter = 0;
	
	public static String value1;
	public static int counter1 = 0;
	
	public static String name;
	
	
	// Variables for color code 
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	
	//Asking for name of the player
	static void ask() {
		System.out.println("Enter your name: ");		
		Scanner RPS = new Scanner(System.in);
		name = RPS.nextLine();

		System.out.printf("Welcome %s!!, You'll be playing against JON SNOW today!! ",name.toUpperCase());
	}

	//User End Logic
	static void mets() {
		
		// Asking player to choose from the given options
		System.out.println("\n\nR ---- Rock");
		System.out.println("P ---- Paper");		
		System.out.println("S ---- Scissors");
		System.out.println("Q ---- Quit");
		
		//Taking user input for above choice
		System.out.println("Enter your choice -- ");
		Scanner RSP2 = new Scanner(System.in);
		String selectedOpts1 =  RSP2.nextLine();
		
		String selectedOpts = selectedOpts1.substring(0,1).toUpperCase(); // To capitalize user character if they enter in lower-case
		
		//Logic if user enter the character
		switch(selectedOpts) {
		case "R":
			value= "Rock";	
			System.out.println(value);
			mets2();
			break;
		case "P":
			value = "Paper";	
			System.out.println(value);
			mets2();
			break;

		case "S":
			value = "Scissors";
			System.out.println(value);
			mets2();
			break;
		case "Q":
			finalScore();
			System.exit(0); //Using exit in-built method to exit the program if user chooses to quit the game
			break;
		default:
			System.out.println(ANSI_RED + "Invalid choice!! Please enter choice again!"+ ANSI_RESET); //Text of this print statement are printed in Red color as color code given to color variables above 
			mets();
			break;
		}	
	}
	
	//Computer End Logic
	static void mets2() {
				
		Random r1 = new Random(); 
		int r = r1.nextInt(1,4);
		switch(r) {
		case 1:
			value1 = "Rock";
			System.out.println("Jon's choice R");
			break;
		case 2:
			value1 = "Paper";	
			System.out.println("Jon's choice P");
			break;

		case 3:
			value1 = "Scissors";
			System.out.println("Jon's choice S");
			break;
		}
	}
	

	// Using this method comparing user and computer's choices and giving the winner 
	static void logic() {
		if(value.equalsIgnoreCase(value1)) {
			System.out.println("It's a tie!!");
			System.out.printf("%s's score -- %d\t",name,counter);
			System.out.printf("Jon's score -- %d",counter1);	
			mets();;
			logic();
		}
		else {
			if(value == "Rock" && value1 == "Paper") {
				System.out.printf("%s lose!!",name);
				counter1++;
				System.out.printf("\n%s's score -- %d\t",name,counter);
				System.out.printf("Jon's score -- %d",counter1);
				mets();
				logic();
			}
			else if(value == "Rock" && value1 == "Scissors") {
				System.out.printf("%s win!!",name);
				counter++;
				System.out.printf("\n%s's score -- %d\t",name,counter);
				System.out.printf("Jon's score -- %d",counter1);
				mets();
				logic();
			} 
			else if(value == "Paper" && value1 == "Scissors") {
				System.out.printf("%s lose!!",name);
				counter1++;
				System.out.printf("\n%s's score -- %d\t",name,counter);
				System.out.printf("Jon's score -- %d",counter1);
				mets();
				logic();
			}
			else if(value == "Paper" && value1 == "Rock") {
				System.out.printf("%s win!!",name);
				counter++;
				System.out.printf("\n%s's score -- %d\t",name,counter);
				System.out.printf("Jon's score -- %d",counter1);
				mets();
				logic();
			}
			else if(value == "Scissors" && value1 == "Rock") {
				System.out.printf("%s lose!!",name);
				counter1++;
				System.out.printf("\n%s's score -- %d\t",name,counter);
				System.out.printf("Jon's score -- %d",counter1);
				mets();
				logic();
			}
			else if(value == "Scissors" && value1 == "Paper") {
		
				System.out.printf("%s win!!",name);
				counter++;
				System.out.printf("\n%s's score -- %d\t",name,counter);
				System.out.printf("Jon's score -- %d",counter1);
				mets();
				logic();

			}
			
			else {
				System.out.println("Thank You For Playing");
			}
		}
	}
	
	
	//Logic to display final score if user quits the game
	static void finalScore() {
		System.out.printf("Final Score is of %s's is: %d\n",name,counter);
		System.out.printf("Final Score is of Jon's is: %d",counter1);
		if(counter<counter1) {
			System.out.printf("\nJon defeated %s!!",name);
		}
		else if(counter>counter1) {
			System.out.printf("\nCongrats %s!! You defeated Jon",name);
		}
		else
		{
			System.out.printf("\nIt's a Tie between Jon and %s",name);

		}

	}
	
	

}