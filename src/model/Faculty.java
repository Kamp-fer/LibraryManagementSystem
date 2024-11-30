package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends Member {
	private String facultyId;
	private List<Journal> reservedJournals;
	private String facultyType;
	private String researchArea;
	private int publicationCount;

	public Faculty() {

	}

	public Faculty(String facultyId, List<Journal> reservedJournals) {
		setFacultyId(facultyId);
		setReservedJournals(reservedJournals);
	}

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

	public void reserveJournal(Journal journal) {
		if (journal.isAvailable()) {
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

	@Override
	public void displayMemberDetails() {
		System.out.println("Member ID: " + getMemberId()+", Name: " + getName()+", Type: "+ this.getClass().getSimpleName());

	}

	@Override
	public void generateMembershipReport() {
		System.out
				.println(" - Member: " + getName() + "," + " Total Borrowed Items: " + getBorrowTransactions().size());
	}

}
