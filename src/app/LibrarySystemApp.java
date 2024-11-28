package app;

import model.*;

import java.time.*;
import java.time.format.*;
import java.util.Random;
import java.util.Scanner;

public class LibrarySystemApp {

    static LibrarySystem librarySystem = new LibrarySystem();
    public static void main(String[] args) {
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

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:{
                for (LibraryItem libraryItem : LibrarySystem.getLibraryItems()) {
                    libraryItem.displayDetails();
                }
            }
                break;
            case 2:
                for (LibraryItem libraryItem : LibrarySystem.getLibraryItems()) {
                    if (libraryItem.isAvailable()) {
                        libraryItem.displayDetails();
                    }
                }
                break;
            case 3:{
                for (Member member : librarySystem.getMembers()) {
                    member.displayMemberDetails();
                }
            }
                break;
            case 4:
                manageMembers();
                break;
            case 5:
                manageLibraryItems();
                break;
//            case 6:
//                librarySystem.borrowLibraryItem();
//                break;
//            case 7:
//                librarySystem.returnLibraryItem();
//                break;
//            case 8:
//                librarySystem.generateReport();
//                break;
//            case 9:
//                saveAndExit();
//                break;
            default:
                System.out.println("Invalid choice. Please try again.");
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
                        String date =scanner.next();;
                        LocalDate membershipStartDate=LocalDate.parse(date);
                        System.out.println("Enter Borrow Limit:");
                        int borrowLimit=scanner.nextInt();
                        System.out.println("Enter Student ID:");
                        int studentId=scanner.nextInt();
                        System.out.println("Enter Specialization:");
                        String specialization=scanner.next();
                        Student member=new Student(memberId,
                                name,
                                address,
                                phoneNumber,
                                email,
                                membershipStartDate,
                                null,
                                borrowLimit,
                                studentId,
                                specialization,
                                null);
                        librarySystem.addMember(member);
                    }
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
                        LocalDate membershipStartDate=LocalDate.parse(scanner.next());
                        System.out.println("Enter Borrow Limit:");
                        int borrowLimit=scanner.nextInt();
                        System.out.println("Enter Faculty ID:");
                        String facultyId=scanner.next();
                        Faculty member=new Faculty(memberId,
                                name,
                                address,
                                phoneNumber,
                                email,
                                membershipStartDate,
                                null ,
                                borrowLimit,
                                facultyId,
                                null);
                        librarySystem.addMember(member);
                    }
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
                        LocalDate membershipStartDate=LocalDate.parse(scanner.next());
                        System.out.println("Enter Borrow Limit:");
                        int borrowLimit=scanner.nextInt();
                        System.out.println("Enter External ID:");
                        String externalId=scanner.next();
                        System.out.println("Enter Organization:");
                        String organization=scanner.next();
                        System.out.println("Enter Subscription Fee:");
                        double subscriptionFee=scanner.nextDouble();
                        System.out.println("Enter Membership Expiry Date:");
                        LocalDate membershipExpiryDate=LocalDate.parse(scanner.next("yyyy-MM-dd"));
                        ExternalMember member=new ExternalMember(memberId,
                                name,
                                address,
                                phoneNumber,
                                email,
                                membershipStartDate,
                                null ,
                                borrowLimit,
                                externalId,
                                organization,
                                subscriptionFee,
                                membershipExpiryDate,
                                null);
                        librarySystem.addMember(member);
                    }
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            case 2:{
                System.out.println("Enter Member ID:");
                int memberId= scanner.nextInt();
                for (int i=0;i<LibrarySystem.getMembers().size();i++){
                    if(LibrarySystem.getMembers().get(i).getMemberId()==memberId) {
                        if (LibrarySystem.getMembers().get(i) instanceof Student) {
                            choice = 1;
                        }
                        if (LibrarySystem.getMembers().get(i) instanceof Faculty) {
                            choice = 2;
                        }
                        if (LibrarySystem.getMembers().get(i) instanceof ExternalMember) {
                            choice = 3;
                        }
                        switch (choice) {
                            case 1: {
                                System.out.println("Enter Member ID:");
                                int memberId1 = scanner.nextInt();
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
                                LocalDate membershipStartDate = LocalDate.parse(scanner.next());
                                System.out.println("Enter Borrow Limit:");
                                int borrowLimit = scanner.nextInt();
                                System.out.println("Enter Student ID:");
                                int studentId = scanner.nextInt();
                                System.out.println("Enter Specialization:");
                                String specialization = scanner.next();
                                Student member = new Student(memberId,
                                        name,
                                        address,
                                        phoneNumber,
                                        email,
                                        membershipStartDate,
                                        null,
                                        borrowLimit,
                                        studentId,
                                        specialization,
                                        null);
                                librarySystem.updateMember(member);
                            }
                            case 2: {
                                System.out.println("Enter Member ID:");
                                int memberId1 = scanner.nextInt();
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
                                LocalDate membershipStartDate = LocalDate.parse(scanner.next());
                                System.out.println("Enter Borrow Limit:");
                                int borrowLimit = scanner.nextInt();
                                System.out.println("Enter Faculty ID:");
                                String facultyId = scanner.next();
                                Faculty member = new Faculty(memberId,
                                        name,
                                        address,
                                        phoneNumber,
                                        email,
                                        membershipStartDate,
                                        null,
                                        borrowLimit,
                                        facultyId,
                                        null);
                                librarySystem.updateMember(member);
                            }
                            case 3: {
                                System.out.println("Enter Member ID:");
                                int memberId1 = scanner.nextInt();
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
                                LocalDate membershipStartDate = LocalDate.parse(scanner.next());
                                System.out.println("Enter Borrow Limit:");
                                int borrowLimit = scanner.nextInt();
                                System.out.println("Enter External ID:");
                                String externalId = scanner.next();
                                System.out.println("Enter Organization:");
                                String organization = scanner.next();
                                System.out.println("Enter Subscription Fee:");
                                double subscriptionFee = scanner.nextDouble();
                                System.out.println("Enter Membership Expiry Date:");
                                LocalDate membershipExpiryDate = LocalDate.parse(scanner.next("yyyy-MM-dd"));
                                ExternalMember member = new ExternalMember(memberId,
                                        name,
                                        address,
                                        phoneNumber,
                                        email,
                                        membershipStartDate,
                                        null,
                                        borrowLimit,
                                        externalId,
                                        organization,
                                        subscriptionFee,
                                        membershipExpiryDate,
                                        null);
                                librarySystem.updateMember(member);
                            }
                        }
                    }
                }
            }
            case 3:{
                System.out.println("Enter Member ID:");
                int memberId= scanner.nextInt();
                for (int i=0;i<LibrarySystem.getMembers().size();i++){
                    if(LibrarySystem.getMembers().get(i).getMemberId()==memberId) {
                        librarySystem.deleteMember(LibrarySystem.getMembers().get(i));
                    }
                }
            }
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void manageLibraryItems() {
    }

    public static void saveAndExit() {
    }

}
