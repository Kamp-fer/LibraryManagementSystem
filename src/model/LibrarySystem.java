package model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;



public class LibrarySystem {
    private static ArrayList<LibraryItem> libraryItems = new ArrayList<LibraryItem>();
    private static ArrayList<Member> members = new ArrayList<Member>();

    public LibrarySystem() {
    }

    public LibrarySystem(ArrayList<LibraryItem> libraryItems, ArrayList<Member> members) {
        setLibraryItems(libraryItems);
        setMembers(members);
    }

    public static ArrayList<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public void setLibraryItems(ArrayList<LibraryItem> libraryItems) {
        LibrarySystem.libraryItems = libraryItems;
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        LibrarySystem.members = members;
    }

    public void addLibraryItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void updateLibraryItem(LibraryItem item) {
        for (int i = 0; i < libraryItems.size(); i++) {
            if (libraryItems.get(i).getItemId() == item.getItemId()) {
                libraryItems.set(i, item);
                System.out.println("Library Item updated successfully" + item.getItemId());
            } else {
                System.out.println("Library Item not found");
            }
        }
    }

    public void deleteLibraryItem(int itemId) {
        for (int i = 0; i < libraryItems.size(); i++) {
            if (libraryItems.get(i).getItemId() == itemId) {
                libraryItems.remove(i);
                System.out.println("Library Item deleted successfully" + itemId);
                return;
            }
        }
        System.out.println("Library Item not found");
    }

    public static void addMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId() == member.getMemberId()) {
                System.out.println("Member already exists");
                return;
            }
        }
        members.add(member);
    }

    public void updateMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId() == member.getMemberId()) {
                members.set(i, member);
                System.out.println("Member updated successfully" + member.getMemberId());
                return;
            }
        }
        System.out.println("member not found");
    }

    public void deleteMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId() == member.getMemberId()) {
                members.remove(i);
                System.out.println("Member deleted successfully" + member.getMemberId());
                return;
            }
        }
        System.out.println("Member not found");
    }

    public void borrowLibraryItem(int memberId, int itemId) {
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getItemId() == itemId) {
                if (libraryItem.getItemAvailability()) {
                    for (Member member : members) {
                        if (member.getMemberId() == memberId) {
                            if (member.checkBorrowingLimit()) {
                                Scanner scanner = new Scanner(System.in);
                                LocalDate borrowDate;
                                System.out.println("Enter borrow date (yyyy/MM/dd): ");
                                try {
                                    borrowDate = LocalDate.parse(scanner.next());
                                } catch (Exception e) {
                                    System.err.println("Invalid date format. ");
                                    break;
                                }
                                LocalDate dueDate = borrowDate.plusDays(21);
                                BorrowTransaction borrowTransaction = new BorrowTransaction(BorrowTransaction.generateBorrowId(), memberId, itemId, borrowDate, dueDate);
                                borrowTransaction.recordBorrow();
                                member.addBorrowTransaction(borrowTransaction);
                                libraryItem.borrowItem();
                                System.out.println("Item borrowed successfully");
                                return;
                            } else {
                                System.out.println("Borrowing limit reached");
                                return;
                            }
                        }
                        else{
                            System.out.println("Member not found");
                            return;
                        }
                    }
                }else {
                    System.out.println("Item not available");
                    return;
                }
            }
        }
    }


    public Invoice returnLibraryItem(int borrowId) {
        for (Member member : members) {
            for (BorrowTransaction borrowTransaction : member.getBorrowTransactions()) {
                if (borrowTransaction.getBorrowId() == borrowId) {
                    for (LibraryItem libraryItem : libraryItems) {
                        if (libraryItem.getItemId() == borrowTransaction.getItemId()) {
                            libraryItem.returnItem();
                            borrowTransaction.recordReturn();
                            member.removeBorrowItem(libraryItem);
                            Invoice invoice = new Invoice(Integer.toString(borrowTransaction.getBorrowId()), member, List.of(libraryItem), borrowTransaction.getDueDate());
                            System.out.println("Item returned successfully");
                            return invoice;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void generateReport(ReportType type) {
        switch (type) {
            case BORROWED_BOOKS -> {
                for (LibraryItem libraryItem : libraryItems) {
                    if (libraryItem instanceof Book) {
                        if (!libraryItem.getItemAvailability()) {
                            libraryItem.displayDetails();
                        }
                    }
                }
            }
            case OVERDUE_BOOKS -> {
                for (Member member : members) {
                    for (BorrowTransaction borrowTransaction : member.getBorrowTransactions()) {
                        if (borrowTransaction.getDueDate().isBefore(LocalDate.now()) && !borrowTransaction.getItem().getItemAvailability()) {
                            for (LibraryItem libraryItem : libraryItems) {
                                if (libraryItem.getItemId() == borrowTransaction.getItemId()) {
                                    libraryItem.displayDetails();
                                }
                            }
                        }
                    }
                }
            }
            case MEMBER_ACTIVITY -> {
                for (Member member : members) {
                    member.generateMembershipReport();
                }
            }
            case GENRE_POPULARITY -> {
                List<String> genres = new ArrayList<>();
                List<Integer> counts = new ArrayList<>();

                for (LibraryItem libraryItem : libraryItems) {
                    if (libraryItem instanceof Book) {
                        String genre = String.valueOf(((Book) libraryItem).getGenre());
                        int index = genres.indexOf(genre);
                        if (index != -1) {
                            counts.set(index, counts.get(index) + 1);
                        } else {
                            genres.add(genre);
                            counts.add(1);
                        }
                    }
                }

                for (int i = 0; i < genres.size(); i++) {
                    System.out.println("Genre: " + genres.get(i) + ", Count: " + counts.get(i));
                }
            }
            case FINANCIAL_SUMMARY -> {
                double totalRevenue = 0;
                for (Member member : members) {
                    for (BorrowTransaction borrowTransaction : member.getBorrowTransactions()) {
                        for (LibraryItem libraryItem : libraryItems) {
                            if (libraryItem.getItemId() == borrowTransaction.getItemId()) {
                                int overDueDays = (int)Duration.between(borrowTransaction.getDueDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
                                totalRevenue += libraryItem.getLatePenalty()*overDueDays;
                            }
                        }
                    }
                }
                System.out.println("Total Revenue: " + totalRevenue);
            }
            case INACTIVE_MEMBERS -> {
                for (Member member : members) {
                    if (member.getBorrowTransactions().isEmpty()) {
                        member.displayMemberDetails();
                    }
                }
            }

            case TOP_BORROWERS -> {
                Member topBorrower = null;
                int maxBorrowTransactions = 0;

                for (Member member : members) {
                    int borrowCount = member.getBorrowTransactions().size();
                    if (borrowCount > maxBorrowTransactions) {
                        maxBorrowTransactions = borrowCount;
                        topBorrower = member;
                    }
                }

                if (topBorrower != null) {
                    System.out.println("Top Borrower:");
                    topBorrower.displayMemberDetails();
                    System.out.println("Total Borrowed Items: " + maxBorrowTransactions);
                } else {
                    System.out.println("No borrowing transactions found.");
                }
            }

        }
    }
}

