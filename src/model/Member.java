package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Member {
	private int memberid;
	private String name;
	private Address address;
	private String phoneNumber;
	private String email;
	private LocalDate membershipStartDate;
	private ArrayList<BorrowTransaction> borrowTransactions;
	private int borrowLimit;

	public Member() {

	}

	public Member(int memberid, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTranscations, int borrowLimit) {
		setMemberid(memberid);
		setName(name);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setMembershipStartDate(membershipStartDate);
		setBorrowTranscations(borrowTransactions);
		setBorrowLimit(borrowLimit);
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getMembershipStartDate() {
		return membershipStartDate;
	}

	public void setMembershipStartDate(LocalDate membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}

	public ArrayList<BorrowTransaction> getBorrowTranscations() {
		return borrowTransactions;
	}

	public void setBorrowTranscations(ArrayList<BorrowTransaction> borrowTranscations) {
		this.borrowTransactions = borrowTranscations;
	}

	public int getBorrowLimit() {
		return borrowLimit;
	}

	public void setBorrowLimit(int borrowLimit) {
		this.borrowLimit = borrowLimit;
	}

	public boolean checkBorrowingLimit() {
		int validBorrow = 0;
		for (BorrowTransaction transaction : borrowTransactions) {
			if (transaction.getDueDate().after(transaction.getBorrowDate())) {
				validBorrow += 1;
			}
		}
		return validBorrow < borrowLimit;
	}

	public List<Invoice> viewTransactionHistory(){
		ArrayList<Invoice> invoices = new ArrayList<>();
		 for (BorrowTransaction transaction : borrowTransactions) {
			 Invoice invoice = new Invoice(transaction.getBorrowId(),this, List.of(transaction.getItem()), transaction.getBorrowDate());
			 invoices.add(invoice);
			 
		 }
		 return invoices;
	}

	public void addBorrowTransaction(BorrowTransaction borrow) {
		if (borrowTransactions == null) {
			System.out.println("The borrow transactions list is not yet initialized.");
		}

		borrowTransactions.add(borrow);
		System.out.println("The transaction has been added successfully");

	}

	public BorrowTransaction removeBorrowItem(LibraryItem item) {
		if (borrowTransactions == null) {
			System.out.println("No borrowing transactions was found. ");
			return null;
		}

		for (int i = 0; i < borrowTransactions.size(); i++) {

			if (borrowTransactions.get(i).getItemId() == item.getItemId()) {
				BorrowTransaction removedTransaction = borrowTransactions.remove(i);
				System.out.println("The borrowed item was removed successfully: ");
				return removedTransaction;
			}
		}
        return null;
    }

	public abstract void displayMemberDetails();

	public abstract void generateMembershipReport();

}
