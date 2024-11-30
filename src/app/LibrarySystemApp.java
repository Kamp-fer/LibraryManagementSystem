package app;

import model.*;

import java.io.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystemApp {

    static LibrarySystem librarySystem = new LibrarySystem();
    public static void main(String[] args) {
        startSystem();
        int memberId;
        int itemId;
        int choice=0;
        while (choice!=9) {
            System.out.println("---Library Management System---");
            System.out.println("1. View All Library Items");
            System.out.println("2. View Available Library Items");
            System.out.println("3. View Members");
            System.out.println("4. Manage Members");
            System.out.println("5. Manage Library Items");
            System.out.println("6. Borrow Library Item");
            System.out.println("7. Return Library Item");
            System.out.println("8. Generate Report");
            System.out.println("9. Save & Exit");
            System.out.println("Enter your choice:");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:{
                    if(LibrarySystem.getLibraryItems().isEmpty()){
                        System.out.println("No Library Items Available");
                    }
                    else {
                        System.out.println("--All Library Items--");
                        for (LibraryItem libraryItem : LibrarySystem.getLibraryItems()) {
                            libraryItem.displayDetails();
                        }
                    }
                }
                    break;
                case 2:
                    System.out.println("--Available Library Items--");
                    for (LibraryItem libraryItem : LibrarySystem.getLibraryItems()) {
                        if (libraryItem.isAvailable()) {
                            libraryItem.displayDetails();
                        }
                    }
                    break;
                case 3:{
                    System.out.println("--All Members--");
                    if(LibrarySystem.getMembers().isEmpty()){
                        System.out.println("No Members Available");
                    }
                    else {
                        for (Member member : LibrarySystem.getMembers()) {
                            member.displayMemberDetails();
                        }
                    }
                }
                    break;
                case 4:
                    System.out.println("--Manage Members--");
                    manageMembers();
                    break;
                case 5:
                    System.out.println("--Manage Library Items--");
                    manageLibraryItems();
                    break;
                case 6:
                    System.out.println("--Borrow Library Item--");
                    System.out.println("Enter Member ID:");
                    memberId=scanner.nextInt();
                    System.out.println("Enter Item ID:");
                    itemId=scanner.nextInt();
                    librarySystem.borrowLibraryItem(memberId,itemId);
                    break;
                case 7:
                    System.out.println("--Return Library Item--");
                    System.out.println("Enter Borrow ID:");
                    int borrowId=scanner.nextInt();
                    librarySystem.returnLibraryItem(borrowId);
                    break;
                case 8: {
                    System.out.println("--Generate Report--");
                    System.out.println("Enter Report Type:");
                    System.out.println("1. Borrowed Books");
                    System.out.println("2. Overdue Books");
                    System.out.println("3. Members Activity");
                    System.out.println("4. Genre Popularity");
                    System.out.println("5. Financial Summary");
                    System.out.println("6. Inactive Members");
                    System.out.println("7. Top Borrowers");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            librarySystem.generateReport(ReportType.BORROWED_BOOKS);
                            break;
                        case 2:
                            librarySystem.generateReport(ReportType.OVERDUE_BOOKS);
                            break;
                        case 3:
                            librarySystem.generateReport(ReportType.MEMBER_ACTIVITY);
                            break;
                        case 4:
                            librarySystem.generateReport(ReportType.GENRE_POPULARITY);
                            break;
                        case 5:
                            librarySystem.generateReport(ReportType.FINANCIAL_SUMMARY);
                            break;
                        case 6:
                            librarySystem.generateReport(ReportType.INACTIVE_MEMBERS);
                            break;
                        case 7:
                            librarySystem.generateReport(ReportType.TOP_BORROWERS);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                };
                break;
                case 9:
                    saveAndExit();
                    System.out.println("--System saved and exited successfully--");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }


    public static void manageMembers() {
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. Delete Member");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:{
                System.out.println("Choose Member Type:");
                System.out.println("1.Student");
                System.out.println("2.Faculty");
                System.out.println("1.External Member");
                choice=scanner.nextInt();
                switch (choice){
                    case 1:{System.out.println("Enter Member ID:");
                        int memberId= scanner.nextInt();
                        System.out.println("Enter Name:");
                        String name=scanner.next();
                        System.out.println("ADDRESS");
                        System.out.println("Enter Street:");
                        String street=scanner.next();
                        System.out.println("Enter City:");
                        String city=scanner.next();
                        System.out.println("Enter State:");
                        String state=scanner.next();
                        System.out.println("Enter ZIP Code:");
                        String zipCode=scanner.next();
                        Address address=new Address(street,city,state,zipCode);
                        System.out.println("Enter Phone Number:");
                        String phoneNumber=scanner.next();
                        System.out.println("Enter Email:");
                        String email=scanner.next();
                        System.out.println("Enter Membership Start Date(yyyy-MM-dd):");
                        LocalDate membershipStartDate;
                        try {
                            membershipStartDate = LocalDate.parse(scanner.next());
                        } catch (Exception e) {
                            System.err.println("Invalid date format. ");
                            break;
                        }
                        System.out.println("Enter Borrow Limit:");
                        int borrowLimit=scanner.nextInt();
                        System.out.println("Enter Student ID:");
                        int studentId=scanner.nextInt();
                        System.out.println("Enter Specialization:");
                        String specialization=scanner.next();
                        System.out.println("Enter Enrollment Date(yyyy-MM-dd):");
                        LocalDate enrollmentDate;
                        try {
                            enrollmentDate= LocalDate.parse(scanner.next());
                        }catch (Exception e){
                            System.err.println("Invalid date format.");
                            break;
                        }
                        System.out.println("Enter Academic Standing");
                        String academicStanding=scanner.next();
                        Student member=new Student(memberId,
                                name,
                                address,
                                phoneNumber,
                                email,
                                membershipStartDate,
                                borrowLimit,
                                studentId,
                                specialization,
                                enrollmentDate,
                                academicStanding);
                        librarySystem.addMember(member);
                        System.out.println("Member added successfully."+member.getName());
                    };
                    break;
                    case 2:{
                        System.out.println("Enter Member ID:");
                        int memberId= scanner.nextInt();
                        System.out.println("Enter Name:");
                        String name=scanner.next();
                        System.out.println("Enter Address:");
                        System.out.println("Enter Street:");
                        String street=scanner.next();
                        System.out.println("Enter City:");
                        String city=scanner.next();
                        System.out.println("Enter State:");
                        String state=scanner.next();
                        System.out.println("Enter ZIP Code:");
                        String zipCode=scanner.next();
                        Address address=new Address(street,city,state,zipCode);
                        System.out.println("Enter Phone Number:");
                        String phoneNumber=scanner.next();
                        System.out.println("Enter Email:");
                        String email=scanner.next();
                        System.out.println("Enter Membership Start Date(yyyy-MM-dd):");
                        LocalDate membershipStartDate;
                        try {
                            membershipStartDate = LocalDate.parse(scanner.next());
                        } catch (Exception e) {
                            System.err.println("Invalid date format. ");
                            break;
                        }
                        System.out.println("Enter Borrow Limit:");
                        int borrowLimit=scanner.nextInt();
                        System.out.println("Enter Faculty ID:");
                        String facultyId=scanner.next();
                        System.out.println("Enter Faculty Type:");
                        String facultyType=scanner.next();
                        System.out.println("Enter Research Area");
                        String researchArea=scanner.next();
                        System.out.println("Enter Publication Count:");
                        int publicationCount=scanner.nextInt();
                        Faculty member=new Faculty(memberId,
                                name,
                                address,
                                phoneNumber,
                                email,
                                membershipStartDate,
                                borrowLimit,
                                facultyId,
                                facultyType,
                                researchArea,
                                publicationCount);
                        librarySystem.addMember(member);
                        System.out.println("Member added successfully."+member.getName());
                    };
                    break;
                    case 3:{
                        System.out.println("Enter Member ID:");
                        int memberId= scanner.nextInt();
                        System.out.println("Enter Name:");
                        String name=scanner.next();
                        System.out.println("Enter Address:");
                        System.out.println("Enter Street:");
                        String street=scanner.next();
                        System.out.println("Enter City:");
                        String city=scanner.next();
                        System.out.println("Enter State:");
                        String state=scanner.next();
                        System.out.println("Enter ZIP Code:");
                        String zipCode=scanner.next();
                        Address address=new Address(street,city,state,zipCode);
                        System.out.println("Enter Phone Number:");
                        String phoneNumber=scanner.next();
                        System.out.println("Enter Email:");
                        String email=scanner.next();
                        System.out.println("Enter Membership Start Date(yyyy-MM-dd):");
                        LocalDate membershipStartDate;
                        try {
                            membershipStartDate = LocalDate.parse(scanner.next());
                        } catch (Exception e) {
                            System.err.println("Invalid date format. ");
                            break;
                        }
                        System.out.println("Enter Borrow Limit:");
                        int borrowLimit=scanner.nextInt();
                        System.out.println("Enter External ID:");
                        String externalId=scanner.next();
                        System.out.println("Enter Organization:");
                        String organization=scanner.next();
                        System.out.println("Enter Subscription Fee:");
                        double subscriptionFee=scanner.nextDouble();
                        System.out.println("Enter Membership Expiry Date:");
                        LocalDate membershipExpiryDate;
                        try {
                            membershipExpiryDate = LocalDate.parse(scanner.next());
                        } catch (Exception e) {
                            System.err.println("Invalid date format. ");
                            break;
                        }
                        ExternalMember member=new ExternalMember(memberId,
                                name,
                                address,
                                phoneNumber,
                                email,
                                membershipStartDate,
                                borrowLimit,
                                externalId,
                                organization,
                                subscriptionFee,
                                membershipExpiryDate);
                        librarySystem.addMember(member);
                        System.out.println("Member added successfully."+member.getName());
                    };
                    break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            };
            break;
            case 2:{
                System.out.println("Enter Member ID:");
                int memberId= scanner.nextInt();
                for (int i=0;i<librarySystem.getMembers().size();i++){
                    if(librarySystem.getMembers().get(i).getMemberId()==memberId) {
                        if (librarySystem.getMembers().get(i) instanceof Student) {
                            choice = 1;
                        }
                        if (librarySystem.getMembers().get(i) instanceof Faculty) {
                            choice = 2;
                        }
                        if (librarySystem.getMembers().get(i) instanceof ExternalMember) {
                            choice = 3;
                        }

                        switch (choice) {
                            case 1: {
                                System.out.println("Enter Name:");
                                String name = scanner.next();
                                System.out.println("Enter Address:");
                                System.out.println("Enter Street:");
                                String street = scanner.next();
                                System.out.println("Enter City:");
                                String city = scanner.next();
                                System.out.println("Enter State:");
                                String state = scanner.next();
                                System.out.println("Enter ZIP Code:");
                                String zipCode = scanner.next();
                                Address address = new Address(street, city, state, zipCode);
                                System.out.println("Enter Phone Number:");
                                String phoneNumber = scanner.next();
                                System.out.println("Enter Email:");
                                String email = scanner.next();
                                System.out.println("Enter Membership Start Date(yyyy-MM-dd):");
                                LocalDate membershipStartDate;
                                try {
                                    membershipStartDate = LocalDate.parse(scanner.next());
                                } catch (Exception e) {
                                    System.err.println("Invalid date format. ");
                                    break;
                                }
                                System.out.println("Enter Borrow Limit:");
                                int borrowLimit = scanner.nextInt();
                                System.out.println("Enter Student ID:");
                                int studentId = scanner.nextInt();
                                System.out.println("Enter Specialization:");
                                String specialization = scanner.next();
                                System.out.println("Enter Enrollment Date(yyyy-MM-dd):");
                                LocalDate enrollmentDate;
                                try {
                                    enrollmentDate= LocalDate.parse(scanner.next());
                                }catch (Exception e){
                                    System.err.println("Invalid date format.");
                                    break;
                                }
                                System.out.println("Enter Academic Standing");
                                String academicStanding=scanner.next();
                                Student member = new Student(memberId,
                                        name,
                                        address,
                                        phoneNumber,
                                        email,
                                        membershipStartDate,
                                        borrowLimit,
                                        studentId,
                                        specialization,
                                        enrollmentDate,
                                        academicStanding);
                                librarySystem.updateMember(member);
                                System.out.println("Member updated successfully."+member.getName());
                            };
                            break;
                            case 2: {
                                System.out.println("Enter Name:");
                                String name = scanner.next();
                                System.out.println("Enter Address:");
                                System.out.println("Enter Street:");
                                String street = scanner.next();
                                System.out.println("Enter City:");
                                String city = scanner.next();
                                System.out.println("Enter State:");
                                String state = scanner.next();
                                System.out.println("Enter ZIP Code:");
                                String zipCode = scanner.next();
                                Address address = new Address(street, city, state, zipCode);
                                System.out.println("Enter Phone Number:");
                                String phoneNumber = scanner.next();
                                System.out.println("Enter Email:");
                                String email = scanner.next();
                                System.out.println("Enter Membership Start Date(yyyy-MM-dd):");
                                LocalDate membershipStartDate;
                                try {
                                    membershipStartDate = LocalDate.parse(scanner.next());
                                } catch (Exception e) {
                                    System.err.println("Invalid date format. ");
                                    break;
                                }
                                System.out.println("Enter Borrow Limit:");
                                int borrowLimit = scanner.nextInt();
                                System.out.println("Enter Faculty ID:");
                                String facultyId = scanner.next();
                                System.out.println("Enter Faculty Type:");
                                String facultyType=scanner.next();
                                System.out.println("Enter Research Area");
                                String researchArea=scanner.next();
                                System.out.println("Enter Publication Count:");
                                int publicationCount=scanner.nextInt();
                                Faculty member = new Faculty(memberId,
                                        name,
                                        address,
                                        phoneNumber,
                                        email,
                                        membershipStartDate,
                                        borrowLimit,
                                        facultyId,
                                        facultyType,
                                        researchArea,
                                        publicationCount);
                                librarySystem.updateMember(member);
                                System.out.println("Member updated successfully."+member.getName());
                            };
                            break;
                            case 3: {
                                System.out.println("Enter Name:");
                                String name = scanner.next();
                                System.out.println("Enter Address:");
                                System.out.println("Enter Street:");
                                String street = scanner.next();
                                System.out.println("Enter City:");
                                String city = scanner.next();
                                System.out.println("Enter State:");
                                String state = scanner.next();
                                System.out.println("Enter ZIP Code:");
                                String zipCode = scanner.next();
                                Address address = new Address(street, city, state, zipCode);
                                System.out.println("Enter Phone Number:");
                                String phoneNumber = scanner.next();
                                System.out.println("Enter Email:");
                                String email = scanner.next();
                                System.out.println("Enter Membership Start Date(yyyy-MM-dd):");
                                LocalDate membershipStartDate;
                                try {
                                    membershipStartDate = LocalDate.parse(scanner.next());
                                } catch (Exception e) {
                                    System.err.println("Invalid date format. ");
                                    break;
                                }
                                System.out.println("Enter Borrow Limit:");
                                int borrowLimit = scanner.nextInt();
                                System.out.println("Enter External ID:");
                                String externalId = scanner.next();
                                System.out.println("Enter Organization:");
                                String organization = scanner.next();
                                System.out.println("Enter Subscription Fee:");
                                double subscriptionFee = scanner.nextDouble();
                                System.out.println("Enter Membership Expiry Date(yyyy-MM-dd):");
                                LocalDate membershipExpiryDate;
                                try {
                                    membershipExpiryDate = LocalDate.parse(scanner.next());
                                } catch (Exception e) {
                                    System.err.println("Invalid date format. ");
                                    break;
                                }
                                ExternalMember member = new ExternalMember(memberId,
                                        name,
                                        address,
                                        phoneNumber,
                                        email,
                                        membershipStartDate,
                                        borrowLimit,
                                        externalId,
                                        organization,
                                        subscriptionFee,
                                        membershipExpiryDate);
                                librarySystem.updateMember(member);
                                System.out.println("Member updated successfully."+member.getName());
                            };
                            break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }
                    else{
                        System.out.println("Member does not exists.");
                        break;
                    }
                }
            };
            break;
            case 3:{
                System.out.println("Enter Member ID:");
                int memberId= scanner.nextInt();
                for (int i=0;i<LibrarySystem.getMembers().size();i++){
                    if(LibrarySystem.getMembers().get(i).getMemberId()==memberId) {
                        librarySystem.deleteMember(LibrarySystem.getMembers().get(i));
                    }
                }
            };
            break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public static void manageLibraryItems() {
        System.out.println("1. Add Library Item");
        System.out.println("2. Update Library Item");
        System.out.println("3. Delete Library Item");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("Choose Library Item Type:");
                System.out.println("1.Book");
                System.out.println("2.Journal");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Enter Library Item ID:");
                        int libraryItemId = scanner.nextInt();
                        System.out.println("Enter Title:");
                        String title = scanner.next();
                        System.out.println("Enter Author's Name:");
                        String name = scanner.next();
                        System.out.println("Enter Author's Email:");
                        String email = scanner.next();
                        System.out.println("Enter Author's Address:");
                        System.out.println("Enter Street:");
                        String street = scanner.next();
                        System.out.println("Enter City:");
                        String city = scanner.next();
                        System.out.println("Enter State:");
                        String state = scanner.next();
                        System.out.println("Enter ZIP Code:");
                        String zipCode = scanner.next();
                        Address address = new Address(street, city, state, zipCode);
                        Author author = new Author(name, email, address);
                        System.out.println("Enter ISBN:");
                        String isbn = scanner.next();
                        System.out.println("Choose Genre:");
                        System.out.println("1.FICTION");
                        System.out.println("2.NON_FICTION");
                        System.out.println("3.TEXTBOOK");
                        choice = scanner.nextInt();
                        Genre genre = null;
                        switch (choice) {
                            case 1:
                                genre = Genre.FICTION;
                                break;
                            case 2:
                                genre = Genre.NON_FICTION;
                                break;
                            case 3:
                                genre = Genre.TEXTBOOK;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                        Book libraryItem = new Book(
                                libraryItemId,
                                title,
                                author,
                                Boolean.TRUE,
                                0.0,
                                isbn,
                                genre);
                        librarySystem.addLibraryItem(libraryItem);
                        System.out.println("Library Item added successfully." + libraryItem.getTitle());
                    }
                    ;
                    break;
                    case 2: {
                        System.out.println("Enter Library Item ID:");
                        int libraryItemId = scanner.nextInt();
                        System.out.println("Enter Title:");
                        String title = scanner.next();
                        System.out.println("Enter Author's Name:");
                        String name = scanner.next();
                        System.out.println("Enter Author's Email:");
                        String email = scanner.next();
                        System.out.println("Enter Author's Address:");
                        System.out.println("Enter Street:");
                        String street = scanner.next();
                        System.out.println("Enter City:");
                        String city = scanner.next();
                        System.out.println("Enter State:");
                        String state = scanner.next();
                        System.out.println("Enter ZIP Code:");
                        String zipCode = scanner.next();
                        Address address = new Address(street, city, state, zipCode);
                        Author author = new Author(name, email, address);
                        System.out.println("Enter Issue Number:");
                        int issueNumber = scanner.nextInt();
                        System.out.println("Enter Publisher:");
                        String publisher = scanner.next();
                        Journal libraryItem = new Journal(
                                libraryItemId,
                                title,
                                author,
                                Boolean.TRUE,
                                0.0,
                                issueNumber,
                                publisher);
                        librarySystem.addLibraryItem(libraryItem);
                        System.out.println("Library Item added successfully." + libraryItem.getTitle());
                    };
                    break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            };
            break;
            case 2: {
                System.out.println("Enter Library Item ID:");
                int itemId = scanner.nextInt();
                for (int i = 0; i < LibrarySystem.getLibraryItems().size(); i++) {
                    if (LibrarySystem.getLibraryItems().get(i).getItemId() == itemId) {
                        if (LibrarySystem.getLibraryItems().get(i) instanceof Book) {
                            choice = 1;
                        }
                        if (LibrarySystem.getLibraryItems().get(i) instanceof Journal) {
                            choice = 2;
                        }
                        switch (choice) {
                            case 1: {
                                System.out.println("Enter Title:");
                                String title = scanner.next();
                                System.out.println("Enter Author's Name:");
                                String name = scanner.next();
                                System.out.println("Enter Author's Email:");
                                String email = scanner.next();
                                System.out.println("Enter Author's Address:");
                                System.out.println("Enter Street:");
                                String street = scanner.next();
                                System.out.println("Enter City:");
                                String city = scanner.next();
                                System.out.println("Enter State:");
                                String state = scanner.next();
                                System.out.println("Enter ZIP Code:");
                                String zipCode = scanner.next();
                                Address address = new Address(street, city, state, zipCode);
                                Author author = new Author(name, email, address);
                                System.out.println("Enter ISBN:");
                                String isbn = scanner.next();
                                System.out.println("Choose Genre:");
                                System.out.println("1.FICTION");
                                System.out.println("2.NON_FICTION");
                                System.out.println("3.TEXTBOOK");
                                choice = scanner.nextInt();
                                Genre genre = null;
                                switch (choice) {
                                    case 1:
                                        genre = Genre.FICTION;
                                        break;
                                    case 2:
                                        genre = Genre.NON_FICTION;
                                        break;
                                    case 3:
                                        genre = Genre.TEXTBOOK;
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                        break;
                                }
                                Book libraryItem = new Book(
                                        itemId,
                                        title,
                                        author,
                                        Boolean.TRUE,
                                        0.0,
                                        isbn,
                                        genre);
                                librarySystem.updateLibraryItem(libraryItem);
                                System.out.println("Library Item updated successfully." + libraryItem.getTitle());
                            }
                            ;
                            break;
                            case 2: {
                                System.out.println("Enter Library Item ID:");
                                int libraryItemId = scanner.nextInt();
                                System.out.println("Enter Title:");
                                String title = scanner.next();
                                System.out.println("Enter Author's Name:");
                                String name = scanner.next();
                                System.out.println("Enter Author's Email:");
                                String email = scanner.next();
                                System.out.println("Enter Author's Address:");
                                System.out.println("Enter Street:");
                                String street = scanner.next();
                                System.out.println("Enter City:");
                                String city = scanner.next();
                                System.out.println("Enter State:");
                                String state = scanner.next();
                                System.out.println("Enter ZIP Code:");
                                String zipCode = scanner.next();
                                Address address = new Address(street, city, state, zipCode);
                                Author author = new Author(name, email, address);
                                System.out.println("Enter Issue Number:");
                                int issueNumber = scanner.nextInt();
                                System.out.println("Enter Publisher:");
                                String publisher = scanner.next();
                                Journal libraryItem = new Journal(
                                        libraryItemId,
                                        title,
                                        author,
                                        Boolean.TRUE,
                                        0.0,
                                        issueNumber,
                                        publisher);
                                librarySystem.updateLibraryItem(libraryItem);
                                System.out.println("Library Item updated successfully." + libraryItem.getTitle());
                            };
                            break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                    }
                }
            };
            break;
            case 3: {
                System.out.println("Enter Library Item ID:");
                int itemId = scanner.nextInt();
                for (int i = 0; i < LibrarySystem.getLibraryItems().size(); i++) {
                    if (LibrarySystem.getLibraryItems().get(i).getItemId() == itemId) {
                        librarySystem.deleteLibraryItem(LibrarySystem.getLibraryItems().get(i).getItemId());
                    }
                }
            };
            break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    public static void startSystem() {
        try{
            FileReader bookReader = new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\book.csv");
            Scanner scanner = new Scanner(bookReader);
            String data;
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                String[] values = data.split(",");
                int itemId = Integer.parseInt(values[0]);
                String title = values[1];
                String authorName = values[2];
                Author author=new Author(authorName,"",new Address("","","",""));
                boolean isAvailable = Boolean.parseBoolean(values[3]);
                double latePenalty = Double.parseDouble(values[4]);
                String isbn = values[5];
                Genre genre = Genre.valueOf(values[6]);
                Book book = new Book(
                        itemId,
                        title,
                        author,
                        isAvailable,
                        latePenalty,
                        isbn,
                        genre);
                librarySystem.addLibraryItem(book);
            }
            FileReader journalReader = new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\journal.csv");
            scanner = new Scanner(journalReader);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                String[] values = data.split(",");
                int itemId = Integer.parseInt(values[0]);
                String title = values[1];
                String authorName = values[2];
                Author author=new Author(authorName,"",new Address("","","",""));
                boolean isAvailable = Boolean.parseBoolean(values[3]);
                double latePenalty = Double.parseDouble(values[4]);
                int issueNumber = Integer.parseInt(values[5]);
                String publisher = values[6];
                Journal journal = new Journal(
                        itemId,
                        title,
                        author,
                        isAvailable,
                        latePenalty,
                        issueNumber,
                        publisher);
                librarySystem.addLibraryItem(journal);
            }
            FileReader memberReader = new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\external.csv");
            scanner = new Scanner(memberReader);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                String[] values = data.split(",");
                int memberId = Integer.parseInt(values[0]);
                String name = values[1];
                String street = values[2];
                Address address = new Address(street,"","","");
                String phoneNumber = values[3];
                String email = values[4];
                LocalDate membershipStartDate = LocalDate.parse(values[5]);
                int borrowLimit = Integer.parseInt(values[6]);
                String membershipType = values[7];
                String externalId = values[8];
                String organization = values[9];
                double subscriptionFee = Double.parseDouble(values[10]);
                LocalDate membershipExpiryDate = LocalDate.parse(values[11]);
                ExternalMember externalMember = new ExternalMember(
                        memberId,
                        name,
                        address,
                        phoneNumber,
                        email,
                        membershipStartDate,
                        borrowLimit,
                        externalId,
                        organization,
                        subscriptionFee,
                        membershipExpiryDate);
                librarySystem.addMember(externalMember);
            }
            FileReader studentReader = new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\student.csv");
            scanner = new Scanner(studentReader);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                String[] values = data.split(",");
                int memberId = Integer.parseInt(values[0]);
                String name = values[1];
                String street = values[2];
                Address address = new Address(street,"","","");
                String phoneNumber = values[3];
                String email = values[4];
                LocalDate membershipStartDate = LocalDate.parse(values[5]);
                int borrowLimit = Integer.parseInt(values[6]);
                String membershipType = values[7];
                int studentId = Integer.parseInt(values[8]);
                String specialization = values[9];
                LocalDate enrollmentDate = LocalDate.parse(values[10]);
                String academicStanding = values[11];
                Student student = new Student(
                        memberId,
                        name,
                        address,
                        phoneNumber,
                        email,
                        membershipStartDate,
                        borrowLimit,
                        studentId,
                        specialization,
                        enrollmentDate,
                        academicStanding);
                librarySystem.addMember(student);
            }
            FileReader facultyReader = new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\faculty.csv");
            scanner = new Scanner(facultyReader);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                String[] values = data.split(",");
                int memberId = Integer.parseInt(values[0]);
                String name = values[1];
                String street = values[2];
                Address address = new Address(street,"","","");
                String phoneNumber = values[3];
                String email = values[4];
                LocalDate membershipStartDate = LocalDate.parse(values[5]);
                int borrowLimit = Integer.parseInt(values[6]);
                String membershipType = values[7];
                String facultyType= values[8];
                String researchArea = values[9];
                int publicationCount= Integer.parseInt(values[10]);
                Faculty faculty = new Faculty(
                        memberId,
                        name,
                        address,
                        phoneNumber,
                        email,
                        membershipStartDate,
                        borrowLimit,
                        null,
                        facultyType,
                        researchArea,
                        publicationCount);
                librarySystem.addMember(faculty);
            }
            FileReader borrowReader = new FileReader("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\borrowTransactions.csv");
            scanner = new Scanner(borrowReader);
            while (scanner.hasNextLine()){
                data = scanner.nextLine();
                String[] values = data.split(",");
                int borrowId = Integer.parseInt(values[0]);
                int memberId = Integer.parseInt(values[1]);
                int itemId = Integer.parseInt(values[2]);
                LocalDate borrowDate = LocalDate.parse(values[3]);
                LocalDate dueDate = LocalDate.parse(values[4]);
                BorrowTransaction borrowTransaction = new BorrowTransaction(
                        borrowId,
                        memberId,
                        itemId,
                        borrowDate,
                        dueDate);
                for (Member member:LibrarySystem.getMembers()){
                    if(member.getMemberId()==memberId){
                        member.addBorrowTransaction(borrowTransaction);
                        break;
                    }
                }
            }
            System.out.println("System started successfully");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }


    public static void saveAndExit() {
        try{
            FileWriter bookWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\book.csv");
            for (LibraryItem libraryItem:LibrarySystem.getLibraryItems()){
                if(libraryItem instanceof Book){
                    Book book = (Book) libraryItem;
                    bookWriter.write(book.getItemId()+","+
                            book.getTitle()+","+
                            book.getAuthor().getName()+","+
                            book.isAvailable()+","+
                            book.getLatePenalty()+","+
                            book.getIsbn()+","+
                            book.getGenre()+"\n");
                }
            }
            bookWriter.close();
            FileWriter journalWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\journal.csv");
            for (LibraryItem libraryItem:LibrarySystem.getLibraryItems()){
                if(libraryItem instanceof Journal){
                    Journal journal = (Journal) libraryItem;
                    journalWriter.write(journal.getItemId() +","+
                            journal.getTitle()+","+
                            journal.getAuthor().getName()+","+
                            journal.isAvailable() +","+
                            journal.getLatePenalty()+","+
                            journal.getIssueNumber()+","+
                            journal.getPublisher()+"\n");
                }
            }
            journalWriter.close();
            FileWriter studentWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\student.csv");
            for (Member member:LibrarySystem.getMembers()){
                if(member instanceof Student){
                    Student student = (Student) member;
                    studentWriter.write(student.getMemberId()+","+
                            student.getName()+","+
                            student.getAddress().getStreet()+","+
                            student.getPhoneNumber()+","+
                            student.getEmail()+","+
                            student.getMembershipStartDate()+","+
                            student.getBorrowLimit()+","+
                            "Student" +","+
                            student.getStudentId()+","+
                            student.getSpecialization()+","+
                            student.getEnrollmentDate()+","+
                            student.getAcademicStanding()+"\n");
                }
            }
            studentWriter.close();
            FileWriter facultyWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\faculty.csv");
            for (Member member:LibrarySystem.getMembers()){
                if(member instanceof Faculty){
                    Faculty faculty = (Faculty) member;
                    facultyWriter.write(faculty.getMemberId()+","+
                            faculty.getName()+","+
                            faculty.getAddress().getStreet()+","+
                            faculty.getPhoneNumber()+","+
                            faculty.getEmail()+","+
                            faculty.getMembershipStartDate()+","+
                            faculty.getBorrowLimit()+","+
                            "Faculty"+","+
                            faculty.getFacultyType()+","+
                            faculty.getResearchArea()+","+
                            faculty.getPublicationCount()+"\n");
                }
            }
            facultyWriter.close();
            FileWriter externalWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\external.csv");
            for (Member member:LibrarySystem.getMembers()){
                if(member instanceof ExternalMember){
                    ExternalMember externalMember = (ExternalMember) member;
                    externalWriter.write(externalMember.getMemberId()+","+
                            externalMember.getName()+","+
                            externalMember.getAddress().getStreet()+","+
                            externalMember.getPhoneNumber()+","+
                            externalMember.getEmail()+","+
                            externalMember.getMembershipStartDate()+","+
                            externalMember.getBorrowLimit()+","+
                            "External"+","+
                            externalMember.getExternalId()+","+
                            externalMember.getOrganization()+","+
                            externalMember.getSubscriptionFee()+","+
                            externalMember.getMembershipExpiryDate()+"\n");
                }
            }
            externalWriter.close();
            FileWriter borrowWriter = new FileWriter("E:\\QU\\Fall-2024\\Cmps-251\\LibraryManagementSystem\\src\\app\\borrowTransactions.csv");
            for (Member member:LibrarySystem.getMembers()){
                for (BorrowTransaction borrowTransaction:member.getBorrowTransactions()){
                    borrowWriter.write(borrowTransaction.getBorrowId()+","+
                            borrowTransaction.getMemberId()+","+
                            borrowTransaction.getItemId()+","+
                            borrowTransaction.getBorrowDate()+","+
                            borrowTransaction.getDueDate()+"\n");
                }
            }

        }catch (Exception e){
            System.out.println("Error in saving data");
        }
    }

}
