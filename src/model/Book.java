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
		System.out.println("Book Details:");
		System.out.println("Item ID: " + getItemId());
		System.out.println("Title: " + getTitle());
		System.out.println("Author: " + author.getName());
		System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
		System.out.println("Late Penalty: " + getLatePenalty());
		System.out.println("isbn: " + getIsbn());
		System.out.println("Genre: " + getGenre());

	}

	@Override
	public void borrowItem() {
		isAvailable = false;
	}

	@Override
	public void returnItem() {
		isAvailable = true;
 
	}
}
