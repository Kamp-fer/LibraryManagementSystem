package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		try {
			ArrayList<String> lines = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader(new FileReader("borrowTransactions.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			}

			String header = lines.get(0);
			ArrayList<String> updatedLines = new ArrayList<>();
			updatedLines.add(header);

			boolean found = false;

			for (int i = 1; i < lines.size(); i++) {
				String line = lines.get(i);
				String[] columns = line.split(",");

				int borrowId = Integer.parseInt(columns[0]);

				if (borrowId == this.borrowId) {
					found = true;
				} else {
					updatedLines.add(line);
				}
			}

			if (found == true) {
				try (PrintWriter writer = new PrintWriter(new FileWriter("borrowTransactions.csv"))) {
					for (String line : updatedLines) {
						writer.println(line);
					}
				}
				System.out.println("The return transaction has been recorded successfully.");
			} else {
				System.out.println("The transaction was not found in the file.");
			}

		} catch (IOException e) {
			System.err.println("The return transaction could not be recorded due to an error. : " + e.getMessage());
		}
	}

	public static int generateBorrowId() {
		try{
			String data;
			String line;
			BufferedReader reader = new BufferedReader(new FileReader("borrowTransactions.csv"));
			while ((line=reader.readLine()) != null) {
				data = line;

				int lastBorrowId = Integer.parseInt(data.split(",")[0]);
				return lastBorrowId + 1;
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	public LibraryItem getItem() {
		for (LibraryItem item : LibrarySystem.getLibraryItems()) {
			if (item.getItemId() == itemId) {
				return item;
			}
		}
		return null;
	}

}
