package model;

/**@author Adem Stiti
 * Date: 21/11/2024
 * @version 1.0
 */

public class Author {
	private String name;
	private String email;
	private Address address;
	/**
	 * This constructor initializes the author with the name, email and address
	 * @param name
	 * @param email
	 * @param address
	 */
	public Author(String name, String email, Address address) {
		super();
		setName(name);
		setEmail(email);
		setAddress(address);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * This method returns the author in a string format
	 * @return String
	 */
	@Override
	public String toString() {
		return "name=" + getName() + ", email=" + getEmail() + ", address=" + getAddress();
	}
	
	
}
