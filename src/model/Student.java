package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** @author Vael Fazelrahman
 * Date: 24/11/2024
 * @version 4.0
 */

public class Student extends Member {
	private int studentId;
	private String specialization;
	private ArrayList<Book> reservedBooks;
	private LocalDate enrollmentDate;
	private String academicStanding;

	public Student() {

	}

	/**
	 * @param studentId
	 * @param specialization
	 * @param reservedBooks
	 * @param enrollmentDate
	 * @param academicStanding
	 */
	public Student(int studentId, String specialization, ArrayList<Book> reservedBooks,LocalDate enrollmentDate, String academicStanding) {
		setStudentId(studentId);
		setSpecialization(specialization);
		setReservedBooks(reservedBooks);
		setEnrollmentDate(enrollmentDate);
		setAcademicStanding(academicStanding);
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
	 * @param studentId
	 * @param specialization
	 * @param reservedBooks
	 * @param enrollmentDate
	 * @param academicStanding
	 */
	public Student(int memberId, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTransactions, int borrowLimit,
			int studentId, String specialization, ArrayList<Book> reservedBooks, LocalDate enrollmentDate, String academicStanding) {
		super(memberId, name, address, phoneNumber, email, membershipStartDate, borrowTransactions, borrowLimit);
		setStudentId(studentId);
		setSpecialization(specialization);
		setReservedBooks(reservedBooks);
		setEnrollmentDate(enrollmentDate);
		setAcademicStanding(academicStanding);
	}

	/**
	 * @param memberId
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param membershipStartDate
	 * @param borrowLimit
	 * @param studentId
	 * @param specialization
	 * @param enrollmentDate
	 * @param academicStanding
	 */
	public Student(int memberId, String name, Address address, String phoneNumber, String email, LocalDate membershipStartDate, int borrowLimit, int studentId, String specialization, LocalDate enrollmentDate, String academicStanding) {
		super(memberId, name, address, phoneNumber, email, membershipStartDate, borrowLimit);
		setStudentId(studentId);
		setSpecialization(specialization);
		setReservedBooks(new ArrayList<>());
		setEnrollmentDate(enrollmentDate);
		setAcademicStanding(academicStanding);
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
		this.reservedBooks = new ArrayList<>(reservedBooks);
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getAcademicStanding() {
		return academicStanding;
	}

	public void setAcademicStanding(String academicStanding) {
		this.academicStanding = academicStanding;
	}

	/**
	 * this method allows a student to reserve a book
	 * @param book
	 */
	public void reserveBook(Book book) {
		if (book.getItemAvailability()) {
			reservedBooks.add(book);
			System.out.println("The book " + book.getTitle() + " has been successfully reserved. ");
		} else {
			System.out.println("The book " + book.getTitle() + " is not available for reservation. ");
		}
	}

	/**
	 * this method allows a student to cancel a book reservation
	 * @param book
	 */
	public void cancelBookReservation(Book book) {
		if (reservedBooks.contains(book)) {
			reservedBooks.remove(book);
			System.out.println("The reservation for the book " + book.getTitle() + " has been successfully canceled. ");
		} else {
			System.out.println("The book " + book.getTitle() + " was not reserved by you. ");
		}

	}

	/**
	 * this method allows a student to view reserved books
	 * @return List<Book>
	 */
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
		System.out.println("Member ID: " + getMemberId() + ", Name: " + getName() + ", Type: " + this.getClass().getSimpleName());
	}

	@Override
	public void generateMembershipReport() {
		System.out
				.println(" - Member: " + getName() + "," + " Total Borrowed Items: " + getBorrowTransactions().size());
	}
}
