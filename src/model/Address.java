package model;

/**@author Adem Stiti
 * Date: 21/11/2024
 * @version 1.0
 */

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipCode;

	/**
	 * This constructor initializes the address with the street, city, state and zipCode
	 * @param street
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public Address(String street, String city, String state, String zipCode) {
		super();
		setStreet(street);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * This method returns the address in a string format
	 * @return String
	 */
	@Override
	public String toString() {
		return "street=" + getStreet() + ", city=" + getCity() + ", state=" + getState() + ", zipCode=" + getZipCode() ;
	}

}
