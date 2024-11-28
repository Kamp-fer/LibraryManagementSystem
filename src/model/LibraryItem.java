package model;

public abstract class LibraryItem implements Borrowable {
	protected int itemId;
	protected String title;
	protected Author author;
	protected boolean isAvailable;
	protected double latePenalty;

	public LibraryItem(int itemId, String title, Author author, boolean isAvailable, double latePenalty) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
		this.latePenalty = latePenalty;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getLatePenalty() {
		return latePenalty;
	}

	public void setLatePenalty(double latePenalty) {
		this.latePenalty = latePenalty;
	}

	public abstract void displayDetails();
}
