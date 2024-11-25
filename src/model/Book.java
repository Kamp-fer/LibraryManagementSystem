package module;

public class Book extends LibraryItem {
	private String isbn;
	private Genre genre;

	public Book(int itemId, String title, Author author, boolean isAvailable, double latePenality, String isbn,
			Genre genre) {
		super(itemId, title, author, isAvailable, latePenality);
		this.isbn = isbn;
		this.genre = genre;

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
		System.out.println("Book Deatails:");
		System.out.println("Item ID: " + itemId);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author.getName());
		System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
		System.out.println("Late Penality: " + latePenality);
		System.out.println("isbn: " + isbn);
		System.out.println("Genre: " + genre);

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
