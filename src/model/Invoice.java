package model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private String invoiceId;
    private Member member;
    private ArrayList<LibraryItem> item=new ArrayList<LibraryItem>();
    private Date transactionDate;

    public Invoice(String invoiceId, Member member, ArrayList<LibraryItem> item, Date transactionDate) {
        this.invoiceId = invoiceId;
        this.member = member;
        this.item = item;
        this.transactionDate = transactionDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setItem(ArrayList<LibraryItem> item) {
        this.item = item;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public ArrayList<LibraryItem> getItem() {
        return item;
    }

    public void addItem(LibraryItem item){
        this.item.add(item);
    }

    public void removeItem(LibraryItem item){
        this.item.remove(item);
    }

    public void generateInvoice(){
        System.out.println("Invoice ID: "+invoiceId);
        System.out.println("Member: "+member);
        System.out.println("Transaction Date: "+transactionDate);
        System.out.println("Items: ");
        for (LibraryItem libraryItem : item) {
            System.out.println(libraryItem);
        }
    }
}
