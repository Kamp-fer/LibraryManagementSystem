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
		System.out.println(super.toString() + ", " + "Issue Number: " + getIssueNumber() + ", " + "Publisher: " + getPublisher());
	}
}
