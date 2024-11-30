package model;

/**@author Adem Stiti
 * Date: 21/11/2024
* @version 2.0
*/
public class Journal extends LibraryItem {

	private int issueNumber;
	private String publisher;

	/**
	 * This constructor initializes the journal with the item ID, title, author, availability, late penalty, issue number and publisher
	 * @param itemId
	 * @param title
	 * @param author
	 * @param isAvailable
	 * @param latePenalty
	 * @param issueNumber
	 * @param publisher
	 */
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

	/**
	 * This method sets the item availability to false
	 * @return void
	 */
	@Override
	public void borrowItem() {
		setItemAvailability(false);
	}


	/**
	 * This method sets the item availability to true
	 * @return void
	 */
	@Override
	public void returnItem() {
		setItemAvailability(true);
	}

	/**
	 * This method displays the details of the journal
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
}
