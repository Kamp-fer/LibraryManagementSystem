package model;

/**@author Adem Stiti
 * Date: 21/11/2024
 * @version 2.0
 */

public abstract class LibraryItem implements Borrowable {
	private int itemId;
	private String title;
	private Author author;
	private boolean isAvailable;
	private double latePenalty;

	/**
	 * This constructor initializes the library item with the item ID, title, author, availability and late penalty
	 * @param itemId
	 * @param title
	 * @param author
	 * @param isAvailable
	 * @param latePenalty
	 */
	public LibraryItem(int itemId, String title, Author author, boolean isAvailable, double latePenalty) {
		setItemId(itemId);
		setTitle(title);
		setAuthor(author);
		setAvailable(isAvailable);
		setLatePenalty(latePenalty);
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public boolean getItemAvailability() {
		return isAvailable;
	}

	public void setItemAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getLatePenalty() {
		return latePenalty;
	}

	/**
	 * This method returns the library item in a string format
	 * @return String
	 */
	@Override
	public String toString() {
		return "Item ID: " + getItemId() + ", Title: " + getTitle() + ", Author: " + author.getName() + ", Availability: "
				+ (isAvailable ? "Yes" : "No") + ", Late Penalty: " + getLatePenalty();
	}

	public void setLatePenalty(double latePenalty) {
		this.latePenalty = latePenalty;
	}

	/**
	 * This method displays the details of the library item
	 * @return void
	 */
	public abstract void displayDetails();
}
