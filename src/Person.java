/*
Name: Ryan Maidment
Course & Section: CST8132 310
Assignment: Lab 7
Date: Mar 31, 2019 */
public class Person {
	// variables
	private String firstName;
	private String lastName;
	private String email;

	/**
	 * This parameterized contruster is used to initialize the varibles associated
	 * with Person.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 */
	public Person(String firstName, String lastName, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	/*
	 * To string used to print Person variables
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return " Name: " + firstName + " " + lastName + " Email Address: "
				+ email;

	}

}