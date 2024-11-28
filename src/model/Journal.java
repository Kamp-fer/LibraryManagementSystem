package model;

public class Journal extends LibraryItem {

	private int issueNumber;
	private String publisher;

	public Journal(int itemId, String title, Author author, boolean isAvailable, double latePenalty, int issueNumber,
			String publisher) {
		super(itemId, title, author, isAvailable, latePenalty);
		setIssueNumber(issueNumber);
		setPublisher(publisher);
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
		System.out.println("Journal Details:");
		System.out.println("Item ID: " + getItemId());
		System.out.println("Title: " + getTitle());
		System.out.println("Author: " + author.getName());
		System.out.println("Availability: " + (isAvailable ? "Yes" : "No"));
		System.out.println("Late Penalty: " + getLatePenalty());
		System.out.println("Issue Number: " + getIssueNumber());
		System.out.println("Publisher: " + getPublisher());
	}
}
