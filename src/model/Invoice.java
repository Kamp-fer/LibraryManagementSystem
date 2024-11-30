package model;

/**@author Abdullah Mohammad Shoeb
* @Date 2024-25-11
* @Course CMPS 251
* @Assignment Final Project
* @File_Name Invoice.java
* @version 2.0
*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for generating the invoice for the member
 *
 */
public class Invoice {
    private String invoiceId;
    private Member member;
    private List<LibraryItem> item;
    private LocalDate transactionDate;

    /**
     * Default constructor
     * @param invoiceId
     * @param member
     * @param item
     * @param transactionDate
     */
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

    /**
     * This method generates the invoice for the member
     * @return void
     */
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
