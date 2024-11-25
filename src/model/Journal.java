package module;

public class Journal extends LibraryItem {

	private int issueNumber;
	private String publisher;

	public Journal(int itemId, String title, Author author, boolean isAvailable, double latePenality, int issueNumber,
			String publisher) {
		super(itemId, title, author, isAvailable, latePenality);
		this.issueNumber = issueNumber;
		this.publisher = publisher;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public void borrowItem() {
		isAvailable = false;
	}


	@Override
	public void returnItem() {
		isAvailable = true;
	}

	@Override
	public void displayDetails() {
		System.out.println("Journal Deatails:");
		System.out.println("Item ID: " + itemId);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author.getName());
		System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
		System.out.println("Late Penality: " + latePenality);
		System.out.println("Issue Number: " + issueNumber);
		System.out.println("Publisher: " + publisher);
	}
}
