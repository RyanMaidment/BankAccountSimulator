
/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 7
Date: Mar 31, 2019 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Bank {
	// variables
	private int numAccounts;
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(numAccounts); //creates arraylist of BankAccounts
	private Scanner insert = new Scanner(System.in);
	private String choice;
	private static Formatter output; // outputs text to a file.
	private Scanner scan;

	/**
	 * This method is used for adding a chequing or savings account based on user
	 * input.
	 * 
	 * @return
	 */

	public boolean addAccount() {

		do {
			System.out.println("Enter account type (s for savings, c for chequing): ");

			choice = insert.nextLine();

			if (choice.toLowerCase().equals("s")) { // creates savings account.
				accounts.add(new SavingsAccount());
			} else if (choice.toLowerCase().equals("c")) { // creates chequing account.
				accounts.add(new ChequingAccount());
			}
		} while (!choice.toLowerCase().equals("s") && !choice.toLowerCase().equals("c"));

		if (accounts.get(numAccounts).addBankAccount()) {
			numAccounts++; // adds bank account.
		} else
			System.out.println("Account not added.");
		return false;

	}

	/**
	 * This method prints a certain account using the findAccount method.
	 * 
	 */
	public void displayAccount() {

		try {
			System.out.println(accounts.get(findAccount()));
		} catch (Exception e) {
			System.out.println("Invalid Account Number.");

		}
	}

	/*
	 * This method prints all the bank accounts in the accounts array.
	 */
	public void printAccountDetails() {
		System.out.println("\nBanking System\n************************\nNumber of Account holders: " + numAccounts);
		for (BankAccount accounts : accounts) {
			System.out.println(accounts.toString()); // prints out all accounts using for loop.

		}
		for (BankAccount accounts : accounts) {

			output.format("%s%n", accounts.toString());
		}
	}

	/**
	 * This method will ask for user input to edit balance, withdraw or deposit from a certain Bank Account
	 */
	public void updateAccount() {
		
		String choose;
		
		System.out.println("Enter account number: ");
		long num = insert.nextLong();
		for (BankAccount accounts : accounts) { // for loop to loop through accounts.
			if (accounts.accountNumber == num) {
			do {	
				System.out.println("Enter B to enter new balance.");
				System.out.println("Enter W to withdraw.");
				System.out.println("Enter D to deposit.");
				System.out.println("Enter Q to quit.");
			
				choose = insert.nextLine();
				
				switch(choose) {
				
				case "b":
				case "B":
					System.out.println("Enter new account balance: ");
					accounts.balance = insert.nextDouble(); // updates chosen bank account with desired balance.
					break;
				case "w":
				case "W":
					accounts.withdraw(); //withdraws from bankaccount
					break;
				case "d":
				case "D":
					accounts.deposit(); //deposits from bankaccount
					break;
				}
			}while(!choose.toLowerCase().equals("q"));
		
			} else
				System.out.println("Error, invalid account.");
			
		}
	}

	/**
	 * This method will use a for loop and nested if statement to find a certain
	 * account based on user input.
	 * 
	 * @return
	 */
	public int findAccount() {

		System.out.println("Enter account number: ");
		long num = insert.nextLong();

		for (int i = 0; i < accounts.size(); i++) { // loops through accounts.
			if (i == num) { // find specific account.
				return i; // returns specific account.
			}
		}

		return -1;
	}

	/**
	 * This method used a for-each statement to update all bank accounts in the
	 * array using the abstract method monthlyAccountUpdate.
	 */
	public void monthlyUpdate() {
		for (BankAccount accounts : accounts) { // for-each statement to update accounts.
			accounts.monthlyAccountUpdate();
		}
	}
	/**
	 * This method well open input scanner for text file.
	 */
	public void openInputFile() {

		try {
			scan = new Scanner(Paths.get("bankinput.txt"));
		} catch (IOException e) {

			System.err.println("Could not find file.");
		}
	}
	/**
	 * This method will use bankinput.txt to automaticlly input BankAccounts into the accounts array. 
	 */
	public void readRecords() {
		//declare varibles
		char accountType;
		String firstName;
		String lastName;
		long accountNum;
		String email;
		double balance;
		Person accHolder;

		while (scan.hasNext()) { //while there is still data in text file loop through while loop.

			accountType = scan.next().charAt(0);
			firstName = scan.next();
			lastName = scan.next();
			accountNum = scan.nextLong();
			email = scan.next();
			balance = scan.nextDouble();

			if (accountType == 'C') {				 //creates chequing or savings account based on input. 
				accounts.add(new ChequingAccount());
			} else if (accountType == 'S') {
				accounts.add(new SavingsAccount());
			}
			// Creates bank account based on input from text file. 
			accounts.get(accounts.size() - 1).accHolder = new Person(firstName, lastName, email);
			accounts.get(accounts.size() - 1).accountNumber = accountNum;
			accounts.get(accounts.size() - 1).balance = balance;

		}
	}
	/**
	 * This method closes the input scanner.
	 */
	public void closeInputFile() {

		if (scan != null)
			scan.close();

	}
	/**
	 * This method intializes the output Formatter to a bankoutput.txt file
	 */
	public void openOutputFile() {

		try {
			output = new Formatter("bankoutput.txt");
		} catch (FileNotFoundException e) {

			System.err.println("Could not create output file.");
		}

	}
	/**
	 * This method closes the output. 
	 */
	public void closeOutputFile() {

		if (output != null)
			output.close();

	}
}
