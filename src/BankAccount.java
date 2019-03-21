
/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 5
Date: Mar 3, 2019 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public abstract class BankAccount {
	// variables
	protected Random rnd = new Random();
	private boolean validInput;
	private Person accHolder;
	protected long accountNumber = 0;
	protected double balance;
	private String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" // https://stackoverflow.com/questions/3732809/how-can-a-string-be-validated-in-java
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; // used to validate email address
	Scanner sc = new Scanner(System.in);

	/*
	 * This is the super toString that the Savings and Chequing Account call. This
	 * prints out the proper information in the Print Accounts methods.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Account number: " + accountNumber + accHolder.toString() + " Balance: $" + this.balance;
	}

	/**
	 * This method creates a new bank account. It requires user input to fill out
	 * all the information needed to create an account. It initalizes the accHolder
	 * object with user input then adds it to the array.
	 * 
	 * @return
	 */
	public boolean addBankAccount() {

		System.out.println("Enter Account number: ");
		validInput = false;
		while (!validInput) { // while statement that checks if validInput is true.
			try {
				accountNumber = sc.nextLong();
				validInput = true;
				break;
			} catch (InputMismatchException e) { // catches Mismatch input
				System.out.println("Error, invalid number.\nPlease enter a correct account number: ");
				sc.next();
			}
		}

		String firstName = null;
		System.out.println("Enter your first name: ");
		validInput = false;
		while (!validInput) { // while statement that checks if validInput is true.
			try {
				firstName = sc.next();
				validInput = true;
				break;
			} catch (InputMismatchException e) { // catches Mismatch input
				System.out.println("Error, invalid name.\nPlease enter a valid name: ");
				sc.next();
			}
		}

		String lastName = null;
		System.out.println("Enter your last name: ");
		validInput = false;
		while (!validInput) { // while statement that checks if validInput is true.
			try {
				lastName = sc.next();

				validInput = true;
				break;
			} catch (InputMismatchException e) { // catches Mismatch input
				System.out.println("Error, invalid name.\nPlease enter a valid last name: ");
				sc.next();
			}
		}

		System.out.println("Enter your email address: ");
		String emailAddress = sc.next();

		if (!emailAddress.matches(email_pattern)) { // uses email pattern to error check.
			do {
				System.out.println("Error, please enter a valid email address.: ");
				emailAddress = sc.next();
			} while (!emailAddress.matches(email_pattern));
		}
		System.out.println("Enter a balance: ");
		validInput = false;
		while (!validInput) { // while statement that checks if validInput is true.
			try {
				this.balance = sc.nextDouble();
				validInput = true;
				break;
			} catch (InputMismatchException e) { // catches Mismatch input
				System.out.println("Error, invalid number.\nPlease enter a valid number: ");
				sc.next();
			}
		}
		this.accHolder = new Person(firstName, lastName, emailAddress); // creates accHolder with user
																						// input given above.

		return true;

	}

	/**
	 * This method updates the balance for the accounts.
	 * 
	 * @param balance
	 */
	public void updateBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * This is an abstract method. More can be seen in the #SavingsAccount and
	 * #ChequingAccount classes.
	 */
	abstract void monthlyAccountUpdate();
}