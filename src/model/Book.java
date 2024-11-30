package model;

/**@author Adem Stiti
 * Date: 21/11/2024
 * @version 2.0
 */

public class Book extends LibraryItem {
	private String isbn;
	private Genre genre;

	/**
	 * This constructor initializes the book with the item ID, title, author, availability, late penalty, ISBN and genre
	 * @param itemId
	 * @param title
	 * @param author
	 * @param isAvailable
	 * @param latePenalty
	 * @param isbn
	 * @param genre
	 */
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

	/**
	 * This method displays the details of the book
	 * @return void
	 */
	@Override
	public void displayDetails() {
		System.out.println(
				"Item ID: "+ getItemId()+ ", " +
				"Title: " + getTitle()+ ", "+
				"Author: " + getAuthor().getName()+ ", "+
				"Available: "+ getItemAvailability());

	}

	/**
	 * This method changes availability of the book to unavailable
	 * @return void
	 */
	@Override
	public void borrowItem() {
		setItemAvailability( false);
	}

	/**
	 * This method changes availability of the book to available
	 * @return void
	 */
	@Override
	public void returnItem() {
		setItemAvailability(true);
 
	}
}
