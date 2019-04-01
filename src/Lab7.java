/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 5
Date: Mar 3, 2019 */
import java.io.IOException;
import java.util.Scanner;

public class Lab7 {

	/**
	 * This is a menu used for navigating through the entire program. Calling on the Bank class to execute the
	 * methods. Using a case switch to navigate through the menu.
	 * @param args
	 * 
	 */
	public static void main(String[]args) {
		//variables
		String menu;
		Bank bank = new Bank(); //create bank account object.
		Scanner input = new Scanner(System.in);
		
		do {

			System.out.println("Enter P to print all accounts.");
			System.out.println("Enter M to run monthly update.");
			System.out.println("Enter Q to quit.");
			System.out.println("Enter R to read records.");
			System.out.println("Enter your option: ");

			menu = input.nextLine();

			switch (menu) {

			case "a":
			case "A":
		
				bank.addAccount(); //creates bank account. 
				
				break;

			case "u":
			case "U":

				bank.updateAccount();
										//prompts user to withdraw, deposit or update account balance.
				
				break;

			case "d":
			case "D":
			
				bank.displayAccount(); //displays a specific bank account.

				break;

			case "p":
			case "P":
				
				bank.openOutputFile();
				bank.printAccountDetails(); //prints all bank accounts. 
				bank.closeOutputFile();
			
				break;
			case "m":
			case "M":
				
				bank.monthlyUpdate(); //does a monthly update of each account based on fees and interest.
				
				break; 
			case "r":
			case"R":
				bank.openInputFile();
				bank.readRecords();
				bank.closeInputFile();
			
				break;
			}
	
		} while (!menu.toLowerCase().equals("q")); // quits menu
	
	}
}