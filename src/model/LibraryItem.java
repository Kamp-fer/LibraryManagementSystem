package model;

public abstract class LibraryItem implements Borrowable {
	protected int itemId;
	protected String title;
	protected Author author;
	protected boolean isAvailable;
	protected double latePenality;

	public LibraryItem(int itemId, String title, Author author, boolean isAvailable, double latePenality) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
		this.latePenality = latePenality;
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

	public double getLatePenality() {
		return latePenality;
	}

	public void setLatePenality(double latePenality) {
		this.latePenality = latePenality;
	}

	abstract void displayDetails();
}
