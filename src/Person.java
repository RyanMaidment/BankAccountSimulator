/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 5
Date: Mar 3, 2019 */
public class Person {
	// variables
	private String firstName;
	private String lastName;
	private String emailAddress;

	/**
	 * This parameterized contruster is used to initialize the varibles associated
	 * with Person.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 */
	public Person(String firstName, String lastName, String emailAddress) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;

	}

	/*
	 * To string used to print Person variables
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return " Name: " + firstName + " " + lastName + " Email Address: "
				+ emailAddress;

	}

}