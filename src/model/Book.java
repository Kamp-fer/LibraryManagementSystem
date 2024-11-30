package model;

public class Book extends LibraryItem {
	private String isbn;
	private Genre genre;

	public Book(int itemId, String title, Author author, boolean isAvailable, double latePenalty, String isbn,
			Genre genre) {
		super(itemId, title, author, isAvailable, latePenalty);
		setIsbn(isbn);
		setGenre(genre);

	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public void displayDetails() {
		System.out.println(
				"Item ID: "+ getItemId()+ ", " +
				"Title: " + getTitle()+ ", "+
				"Author: " + getAuthor().getName()+ ", "+
				"Available: "+ getItemAvailability());

	}

	@Override
	public void borrowItem() {
		setItemAvailability( false);
	}

	@Override
	public void returnItem() {
		setItemAvailability(true);
 
	}
}
