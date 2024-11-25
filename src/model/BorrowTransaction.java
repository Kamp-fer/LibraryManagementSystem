package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BorrowTransaction {
	private int borrowId;
	private int memberId;
	private int itemId;
	private Date borrowDate;
	private Date dueDate;

	public BorrowTransaction() {

	}

	public BorrowTransaction(int borrowId, int memberId, int itemId, Date borrowDate, Date dueDate) {

		setBorrowId(borrowId);
		setMemberId(memberId);
		setItemId(itemId);
		setBorrowDate(borrowDate);
		setDueDate(dueDate);
	}

	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void recordBorrow() {
		try {
			PrintWriter writer = new PrintWriter("borrowTransactions.csv");
			writer.println(borrowId + "," + memberId + "," + itemId + "," + borrowDate + "," + dueDate);
			writer.close();
			System.out.println("Borrow transaction recorded successfully.");

		} catch (IOException e) {
			System.err.println("An error occurred while recording the borrow transaction: " + e.getMessage());
		}
	}

	public void recordReturn() {

	}

}
