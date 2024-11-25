package model;

import java.util.*;

public class LibrarySystem {
    ArrayList<LibraryItem> libraryItems =new ArrayList<LibraryItem>();
    ArrayList<Member> members=new ArrayList<Member>();

    public void addLibraryItem(LibraryItem item){
        libraryItems.add(item);
    }

    public void updateLibraryItem(LibraryItem item){
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.equals(item)){
                libraryItem=item;
            }
        }
    }
    public void deleteLibraryItem(int itemId){
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.getItemId()==itemId){
                libraryItems.remove(libraryItem);
            }
        }
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void updateMember(Member member){
        for (Member member1 : members) {
            if(member1.equals(member)){
                member1=member;
            }
        }
    }

    public void deleteMember(Member member){
        members.remove(member);
    }

    public void borrowLibraryItem(int borrowId){
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.getItemId()==borrowId){
                libraryItem.borrowItem();
            }
        }
    }

    public void returnLibraryItem(int borrowId){
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.getItemId()==borrowId){
                libraryItem.returnItem();
            }
        }
    }
}
