/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 7
Date: Mar 31, 2019 */
public class ChequingAccount extends BankAccount {
	private double fee = rnd.nextInt(10 - 5 + 1) + 5;

	/*
	 * This two string updates the Super.tostring
	 * 
	 * @see BankAccount#toString()
	 */
	public String toString() {
		return "\nC "+ super.toString() + " Fee: $" + this.fee;

	}

	/*
	 * This method initalizes the monthly fee.
	 * 
	 * @see BankAccount#addBankAccount()
	 */
	public boolean addBankAccount() {
		super.addBankAccount();
		return true;

	}

	/*
	 * This method takes the balance and subtracts the fee.
	 * 
	 * @see BankAccount#monthlyAccountUpdate()
	 */
	@Override
	public void monthlyAccountUpdate() {
		this.balance -= this.fee;
	}

}