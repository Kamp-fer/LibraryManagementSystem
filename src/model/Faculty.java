package model;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** @author Vael Fazelrahman
 * Date: 24/11/2024
 * @version 5.0
 */
public class Faculty extends Member {
	private String facultyId;
	private List<Journal> reservedJournals;
	private String facultyType;
	private String researchArea;
	private int publicationCount;

	public Faculty() {

	}

	/**
	 * @param facultyId
	 * @param reservedJournals
	 */
	public Faculty(String facultyId, List<Journal> reservedJournals) {
		setFacultyId(facultyId);
		setReservedJournals(reservedJournals);
	}

	/**
	 * @param memberId
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param membershipStartDate
	 * @param borrowTransactions
	 * @param borrowLimit
	 * @param facultyId
	 * @param reservedJournals
	 * @param facultyType
	 * @param researchArea
	 * @param publicationCount
	 */
	public Faculty(int memberId, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTransactions, int borrowLimit,
			String facultyId, List<Journal> reservedJournals,String facultyType, String researchArea, int publicationCount) {
		super(memberId, name, address, phoneNumber, email, membershipStartDate, borrowTransactions, borrowLimit);
		setFacultyId(facultyId);
		setReservedJournals(reservedJournals);
		setFacultyType(facultyType);
		setResearchArea(researchArea);
		setPublicationCount(publicationCount);
	}

	/**
	 * @param memberId
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param membershipStartDate
	 * @param borrowLimit
	 * @param facultyId
	 * @param facultyType
	 * @param researchArea
	 * @param publicationCount
	 */
	public Faculty(int memberId, String name, Address address, String phoneNumber, String email, LocalDate membershipStartDate, int borrowLimit, String facultyId, String facultyType, String researchArea, int publicationCount) {
		super(memberId, name, address, phoneNumber, email, membershipStartDate, borrowLimit);
		setFacultyId(facultyId);
		setReservedJournals(new ArrayList<>());
		setFacultyType(facultyType);
		setResearchArea(researchArea);
		setPublicationCount(publicationCount);
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public List<Journal> getReservedJournals() {
		return reservedJournals;
	}

	public void setReservedJournals(List<Journal> reservedJournals) {
		this.reservedJournals = reservedJournals;
	}

	public String getResearchArea() {
		return researchArea;
	}

	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}

	public int getPublicationCount() {
		return publicationCount;
	}

	public void setPublicationCount(int publicationCount) {
		this.publicationCount = publicationCount;
	}

	public String getFacultyType() {
		return facultyType;
	}

	public void setFacultyType(String facultyType) {
		this.facultyType = facultyType;
	}

	/**
	 * @param journal
	 */
	public void reserveJournal(Journal journal) {
		if (journal.getItemAvailability()) {
			reservedJournals.add(journal);
			System.out.println("The journal " + journal.getTitle() + " has been successfully reserved. ");
		} else {
			System.out.println("The journal " + journal.getTitle() + " is not available for reservation. ");
		}
	}

	public void cancelJournalReservation(Journal journal) {
		if (reservedJournals.contains(journal)) {
			reservedJournals.remove(journal);
			System.out.println(
					"The reservation for the journal " + journal.getTitle() + " has been successfully canceled. ");
		} else {
			System.out.println("The journal " + journal.getTitle() + " was not reserved by you. ");
		}
	}

	/**
	 * This method displays the details of the faculty
	 * @return void
	 */
	@Override
	public void displayMemberDetails() {
		System.out.println("Member ID: " + getMemberId()+", Name: " + getName()+", Type: "+ this.getClass().getSimpleName());

	}

	/**
	 * This method generates the membership report of the faculty
	 * @return void
	 */
	@Override
	public void generateMembershipReport() {
		System.out
				.println(" - Member: " + getName() + "," + " Total Borrowed Items: " + getBorrowTransactions().size());
	}

}
