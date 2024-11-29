package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String invoiceId;
    private Member member;
    private List<LibraryItem> item;
    private LocalDate transactionDate;

    public Invoice(String invoiceId, Member member, List<LibraryItem> item, LocalDate transactionDate) {
            setInvoiceId(invoiceId);
            setMember(member);
            setItem(item);
            setTransactionDate(transactionDate);
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

    public void setItem(List<LibraryItem> item) {
        this.item = item;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<LibraryItem> getItem() {
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
        System.out.println(", Member: "+member);
        System.out.println(", Transaction Date: "+transactionDate);
        System.out.println(", Items: ");
        for (LibraryItem libraryItem : item) {
            libraryItem.displayDetails();
        }
    }
}
