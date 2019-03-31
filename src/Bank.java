
/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 5
Date: Mar 3, 2019 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Bank {
	// variables
	private ArrayList <BankAccount> accounts = new ArrayList<BankAccount>(numAccounts);
	private static int numAccounts = 0;
	private int sizeBank = 10;
	private Scanner insert = new Scanner(System.in);
	private String choice;
	private static Formatter output; //outputs text to a file.
	Scanner yolo;

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
		for(BankAccount accounts : accounts) {

			output.format("%s%n", accounts.toString());
		}
	}
	
	
	

	/**
	 * This method will update a certain bank accounts balance based on user input.
	 */
	public void updateAccount() {

			System.out.println("Enter account number: ");
			long num = insert.nextLong();
			for (BankAccount accounts : accounts) { // for loop to loop through accounts.
				if (accounts.accountNumber == num) {
					System.out.println("Enter new account balance: ");
					accounts.balance = insert.nextDouble(); // updates chosen bank account with desired balance.
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
	 * This method used a for-each statement to update all bank accounts in the array
	 * using the abstract method monthlyAccountUpdate.
	 */
	public void monthlyUpdate() {
		for (BankAccount accounts : accounts) { // for-each statement to update accounts.
			accounts.monthlyAccountUpdate();
		}
	}

	public void openInputFile() {

		try {
			yolo = new Scanner(Paths.get("bankinput.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public void readRecords() throws IOException {

		String accountType = null;
		String firstName;
		String lastName;
		long accountNum;
		String email;
		double balance;
		
		while (yolo.hasNextLine()) {
			accountType = yolo.next();
			firstName = yolo.next();
			lastName = yolo.next();
			accountNum = yolo.nextLong();
			email = yolo.next();
			balance = yolo.nextDouble();
		}

		if(accountType == "C") {
			accounts.add(new ChequingAccount());
		}
		else if(accountType == "S") {
			accounts.add(new SavingsAccount());
		}
	}

	public void closeInputFile() {

		
	}

	public void openOutputFile() {
		
		try {
			output = new Formatter("bankoutput.txt");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	public void closeOutputFile() {

			output.close();
		
	}
}
