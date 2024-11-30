package model;

public abstract class LibraryItem implements Borrowable {
	private int itemId;
	private String title;
	private Author author;
	private boolean isAvailable;
	private double latePenalty;

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

	@Override
	public String toString() {
		return "Item ID: " + getItemId() + ", Title: " + getTitle() + ", Author: " + author.getName() + ", Availability: "
				+ (isAvailable ? "Yes" : "No") + ", Late Penalty: " + getLatePenalty();
	}

	public void setLatePenalty(double latePenalty) {
		this.latePenalty = latePenalty;
	}

	public abstract void displayDetails();
}
