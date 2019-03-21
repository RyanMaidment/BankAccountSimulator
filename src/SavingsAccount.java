/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 5
Date: Mar 3, 2019 */
public class SavingsAccount extends BankAccount {
	// variables
	private double minBalance;
	private double interestRate = rnd.nextInt(0-1);

	/*
	 * This two string updates the Super.tostring
	 * 
	 * @see BankAccount#toString()
	 */
	public String toString() {
		return super.toString() + " Minimum balance $" + minBalance + " Interest rate: " + interestRate;

	}

	/*
	 * This method initalizes a minimum balance and initalizes interest rate.
	 * 
	 * @see BankAccount#addBankAccount()
	 */
	public boolean addBankAccount() {
		super.addBankAccount();

		System.out.println("Enter minimum balance: ");
		this.minBalance = sc.nextDouble();

		System.out.println("Enter interest Rate (should be a number between (0-1)): ");
		this.interestRate = sc.nextDouble();
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