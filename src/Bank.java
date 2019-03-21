
/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 5
Date: Mar 3, 2019 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class Bank {
	// variables
	private static BankAccount[] accounts;
	private static int numAccounts = 0;
	private int sizeBank = 10;
	private Scanner insert = new Scanner(System.in);

	/**
	 * 
	 */
	public Bank() {
		accounts = new BankAccount[sizeBank];
	}

	/**
	 * Param constructor to initialize the BankAccount array.
	 * 
	 * @param sizeBank
	 */
	public Bank(int sizeBank) {
		accounts = new BankAccount[sizeBank];
	}

	/**
	 * This method is used for adding a chequing or savings account based on user
	 * input.
	 * 
	 * @return
	 */

	public boolean addAccount() {
		String choice = null;

		if (numAccounts > sizeBank) {
			System.out.println("Sorry bank is full.");
		}
		do {
			System.out.println("Enter account type (s for savings, c for chequing): ");

			choice = insert.nextLine();

			if (choice.toLowerCase().equals("s")) { // creates savings account.
				accounts[numAccounts] = new SavingsAccount();
			} else if (choice.toLowerCase().equals("c")) { // creates chequing account.
				accounts[numAccounts] = new ChequingAccount();
			}
		} while (!choice.toLowerCase().equals("s") && !choice.toLowerCase().equals("c"));

		if (accounts[numAccounts].addBankAccount()) {
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
			System.out.println(accounts[findAccount()]);
		} catch (Exception e) {
			System.out.println("Invalid Account Number.");

		}
	}

	/**
	 * This method prints all the bank accounts in the accounts array.
	 */
	public void printAccountDetails() {
		System.out.println("\nBanking System\n************************\nNumber of Account holders: " + numAccounts);
		for (int i = 0; i < numAccounts; i++) {
			System.out.println(accounts[i].toString()); // prints out all accounts using for loop.
		}
	
	}

	/**
	 * This method will update a certain bank accounts balance based on user input.
	 */
	public void updateAccount() {

		System.out.println("Enter account number: ");
		long num = insert.nextLong();
		for (int i = 0; i < numAccounts; i++) { // for loop to loop through accounts.
			if (accounts[i].accountNumber == num) {
				System.out.println("Enter new account balance: ");
				accounts[i].balance = insert.nextDouble(); // updates chosen bank account with desired balance.
			} else
				System.out.println("Error, invalid account.");

		}
		try {
			Formatter txt = new Formatter("C:\\Users\\Ryan\\Documents\\bankoutput.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
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

		for (int i = 0; i < numAccounts; i++) { // loops through accounts.
			if (accounts[i].accountNumber == num) { // find specific account.
				return i; // returns specific account.
			}
		}

		return -1;
	}

	/**
	 * This method used a for-each statment to update all bank accounts in the array
	 * using the abstract method monthlyAccountUpdate.
	 */
	public void monthlyUpdate() {
		for (BankAccount accounts : accounts) { // for-each statment to update accounts.
			accounts.monthlyAccountUpdate();
		}
	}

	public void openInputFile() {

	}

	public void readRecords() {

	}

	public void closeInputFile() {

	}

	public void openOutputFile() {

	}

	public void closeOutputFile() {

	}
}
