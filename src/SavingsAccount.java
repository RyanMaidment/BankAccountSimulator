/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 7
Date: Mar 31, 2019 */
public class SavingsAccount extends BankAccount {
	// variables
	private double min = 0;
	private double max = 1;
	private double interestRate = min + (max - min) * rnd.nextDouble();

	/*
	 * This two string updates the Super.tostring
	 * 
	 * @see BankAccount#toString()
	 */
	public String toString() {
		return "\nS " + super.toString() + " Interest rate: " + this.interestRate;

	}

	/*
	 * This method initalizes a minimum balance and initalizes interest rate.
	 * 
	 * @see BankAccount#addBankAccount()
	 */
	public boolean addBankAccount() {
		super.addBankAccount();
		return true;
	}

	/*
	 * This method takes the balance and subtracts the interest rate.
	 * 
	 * @see BankAccount#monthlyAccountUpdate()
	 * 
	 * @Override
	 */
	@Override
	public void monthlyAccountUpdate() {
		this.balance -= this.interestRate;
	}

}
