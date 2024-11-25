package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Member {
	private int studentId;
	private String specialization;
	private ArrayList<Book> reservedBooks;

	public Student() {

	}

	public Student(int studentId, String specialization, ArrayList<Book> reservedBooks) {
		setStudentId(studentId);
		setSpecialization(specialization);
		setReservedBooks(reservedBooks);
	}

	public Student(int memberid, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTranscations, int borrowLimit,
			int studentId, String specialization, ArrayList<Book> reservedBooks) {
		super(memberid, name, address, phoneNumber, email, membershipStartDate, borrowTranscations, borrowLimit);
		setStudentId(studentId);
		setSpecialization(specialization);
		setReservedBooks(reservedBooks);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ArrayList<Book> getReservedBooks() {
		return reservedBooks;
	}

	public void setReservedBooks(List<Book> reservedBooks) {
		this.reservedBooks = reservedBooks;
	}

	public void reserveBook(Book book) {
		if (book.isAvailable()) {
			reservedBooks.add(book);
			System.out.println("The book " + book.getTitle() + " has been successfully reserved. ");
		} else {
			System.out.println("The book " + book.getTitle() + " is not available for reservation. ");
		}
	}

	public void cancelBookReservation(Book book) {
		if (reservedBooks.contains(book)) {
			reservedBooks.remove(book);
			System.out.println("The reservation for the book " + book.getTitle() + " has been successfully canceled. ");
		} else {
			System.out.println("The book " + book.getTitle() + " was not reserved by you. ");
		}

	}

	public List<Book> viewReservedBooks() {
		if (reservedBooks.isEmpty()) {
			System.out.println("You have no reserved books. ");

		} else {
			System.out.println("Reserved Books: ");
			for (Book book : reservedBooks) {
				System.out.println("  " + book.getTitle());
			}
		}
		return reservedBooks;
	}

	@Override
	public void displayMemberDetails() {
		System.out.println("Student ID: " + getStudentId());
		System.out.println("Student Name: " + getName());
		System.out.println("Specialization: " + getSpecialization());

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
