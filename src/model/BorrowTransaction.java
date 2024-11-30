package model;



import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/** @author Vael Fazelrahman
 * Date: 24/11/2024
 * @version 2.0
 */
public class BorrowTransaction {
	private int borrowId;
	private int memberId;
	private int itemId;
	private LocalDate borrowDate;
	private LocalDate dueDate;

	public BorrowTransaction() {

	}

	/**
	 * @param borrowId
	 * @param memberId
	 * @param itemId
	 * @param borrowDate
	 * @param dueDate
	 */
	public BorrowTransaction(int borrowId, int memberId, int itemId, LocalDate borrowDate, LocalDate dueDate) {
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

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "Borrow ID: " + getBorrowId() + ", Member ID: " + getMemberId() + ", Item ID: " + getItemId() + ", Borrow Date: " + getBorrowDate() + ", Due Date: " + getDueDate();
	}

	/**
	 * This method records the borrow transaction in the borrowTransactions.csv file
	 * @return void
	 */
	public void recordBorrow() {
		try {
			FileWriter fileWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\borrowTransactions.csv", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(this.borrowId + "," + this.memberId + "," + this.itemId + "," + this.borrowDate + "," + this.dueDate);
			printWriter.close();
			System.out.println("Borrow transaction recorded successfully.");
		} catch (IOException e) {
			System.err.println("An error occurred while recording the borrow transaction: " + e.getMessage());
		}
	}

	/**
	 * This method records the return transaction and removes the borrow entry from the borrowTransactions.csv file
	 * @return void
	 */
	public void recordReturn() {
		try {
			// Read all lines from the file
			ArrayList<String> lines = new ArrayList<>();
			try (BufferedReader reader = new BufferedReader(new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\borrowTransactions.csv"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			}

			// Extract the header and data separately
			String header = lines.get(0); // First line is the header
			ArrayList<String> updatedLines = new ArrayList<>();
			updatedLines.add(header); // Add the header back

			boolean found = false;

			for (int i = 1; i < lines.size(); i++) { // Start from 1 to skip the header
				String line = lines.get(i);
				String[] columns = line.split(",");

				// Assuming borrowId is the first column in the CSV
				int fileBorrowId = Integer.parseInt(columns[0]);

				if (fileBorrowId == this.borrowId) {
					found = true; // Skip this line (do not add it to updatedLines)
				} else {
					updatedLines.add(line); // Keep other lines
				}
			}

			// Overwrite the file with the updated content
			if (found) {
				try (PrintWriter writer = new PrintWriter(new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\borrowTransactions.csv"))) {
					for (String line : updatedLines) {
						writer.println(line);
					}
				}
				System.out.println("Return transaction recorded successfully.");
			} else {
				System.out.println("Transaction not found in the file.");
			}

		} catch (IOException | NumberFormatException e) {
			System.err.println("An error occurred while recording the return transaction: " + e.getMessage());
		}
	}

	/**
	 * This method generates a borrow ID for the borrow transaction
	 * @return int
	 */
	public static int generateBorrowId() {
		try{
			String data;
			String line;
			int lastBorrowId = 0;
			BufferedReader reader = new BufferedReader(new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\borrowTransactions.csv"));
			while ((line=reader.readLine()) != null) {
				data = line;
				int borrowId=Integer.parseInt(data.split(",")[0]);
				if (borrowId > lastBorrowId) {
					lastBorrowId = borrowId;
				}
			}
			reader.close();
			return lastBorrowId + 1;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * This method returns the LibraryItem object associated with the borrow transaction
	 * @return LibraryItem
	 */
	public LibraryItem getItem() {
		for (LibraryItem item : LibrarySystem.getLibraryItems()) {
			if (item.getItemId() == itemId) {
				return item;
			}
		}
		return null;
	}

}
