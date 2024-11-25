package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends Member {
	private String facultyId;
	private List<Journals> reservedJournals;

	public Faculty() {

	}

	public Faculty(String facultyId, List<Journals> reservedJournals) {
		setFacultyId(facultyId);
		setReservedJournals(reservedJournals);
	}

	public Faculty(int memberid, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTranscations, int borrowLimit,
			String facultyId, List<Journals> reservedJournals) {
		super(memberid, name, address, phoneNumber, email, membershipStartDate, borrowTranscations, borrowLimit);
		setFacultyId(facultyId);
		setReservedJournals(reservedJournals);
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public List<Journals> getReservedJournals() {
		return reservedJournals;
	}

	public void setReservedJournals(List<Journals> reservedJournals) {
		this.reservedJournals = reservedJournals;
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
		System.out.println("Faculty ID: " + getFacultyId());
		System.out.println("Faculty Name: " + getName());

		if (getAddress() != null) {
			System.out.println("Address: ");
			System.out.println("  Street: " + getAddress().getStreet());
			System.out.println("  City: " + getAddress().getCity());
			System.out.println("  State: " + getAddress().getState());
			System.out.println("  Zip Code: " + getAddress().getZipCode());
		} else {
			System.out.println("Address is not available. ");
		}

		System.out.println("Phone Number: " + getPhoneNumber());
		System.out.println("Email: " + getEmail());
		System.out.println("Membership Start Date: " + getMembershipStartDate());
		System.out.println("Borrow Limit: " + getBorrowLimit());

		if (getBorrowTranscations() != null) {
			System.out.println("Borrowed Items: ");
			for (BorrowTransaction transaction : getBorrowTranscations()) {
				System.out.println("  Borrow ID: " + transaction.getBorrowId());
				System.out.println("  Item ID: " + transaction.getItemId());
				System.out.println("  Borrow Date: " + transaction.getBorrowDate());
				System.out.println("  Due Date: " + transaction.getDueDate());
			}
		} else {
			System.out.println("No borrowed items. ");
		}
	}

	@Override
	public void generateMembershipReport() {
		System.out
				.println(" - Member: " + getName() + "," + " Total Borrowed Items: " + getBorrowTranscations().size());
	}

}
