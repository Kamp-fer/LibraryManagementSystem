package model;


/** @author Vael Fazelrahman
 * Date: 24/11/2024
 * @version 5.0
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExternalMember extends Member {

	private String externalId;
	private String organization;
	private double subscriptionFee;
	private LocalDate membershipExpiryDate;
	private List<String> notificationPreferences;

	public ExternalMember() {

	}

	/**
	 * @param externalId
	 * @param organization
	 * @param subscriptionFee
	 * @param membershipExpiryDate
	 * @param notificationPreferences
	 */
	public ExternalMember(String externalId, String organization, double subscriptionFee,
			LocalDate membershipExpiryDate, List<String> notificationPreferences) {
		setExternalId(externalId);
		setOrganization(organization);
		setSubscriptionFee(subscriptionFee);
		setMembershipExpiryDate(membershipExpiryDate);
		setNotificationPreferences(notificationPreferences);
	}

	/**
	 * @param memberId
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param membershipStartDate
	 * @param borrowTransactions
	 * @param borrowLimit
	 * @param externalId
	 * @param organization
	 * @param subscriptionFee
	 * @param membershipExpiryDate
	 * @param notificationPreferences
	 */
	public ExternalMember(int memberId, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTransactions, int borrowLimit,
			String externalId, String organization, double subscriptionFee, LocalDate membershipExpiryDate,
			List<String> notificationPreferences) {
		super(memberId, name, address, phoneNumber, email, membershipStartDate, borrowTransactions, borrowLimit);
		setExternalId(externalId);
		setOrganization(organization);
		setSubscriptionFee(subscriptionFee);
		setMembershipExpiryDate(membershipExpiryDate);
		setNotificationPreferences(notificationPreferences);
	}

	/**
	 * @param memberId
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param membershipStartDate
	 * @param borrowLimit
	 * @param externalId
	 * @param organization
	 * @param subscriptionFee
	 * @param membershipExpiryDate
	 */
	public ExternalMember(int memberId, String name, Address address, String phoneNumber, String email, LocalDate membershipStartDate, int borrowLimit, String externalId, String organization, double subscriptionFee, LocalDate membershipExpiryDate) {
		super(memberId, name, address, phoneNumber, email, membershipStartDate, borrowLimit);
		setExternalId(externalId);
		setOrganization(organization);
		setSubscriptionFee(subscriptionFee);
		setMembershipExpiryDate(membershipExpiryDate);
		setNotificationPreferences(new ArrayList<>());
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public double getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setSubscriptionFee(double subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	public LocalDate getMembershipExpiryDate() {
		return membershipExpiryDate;
	}

	public void setMembershipExpiryDate(LocalDate membershipExpiryDate) {
		this.membershipExpiryDate = membershipExpiryDate;
	}

	public List<String> getNotificationPreferences() {
		return notificationPreferences;
	}

	public void setNotificationPreferences(List<String> notificationPreferences) {
		this.notificationPreferences = notificationPreferences;
	}

	/**
	 * this method renews the membership expiry date of the external member
	 * @param newDate
	 */
	public void renewMembershipDate(LocalDate newDate) {
		if (newDate.isAfter(membershipExpiryDate)) {
			membershipExpiryDate = newDate;
			System.out.println("Membership renewed successfully. New expiry date: " + membershipExpiryDate);
		} else {
			System.out.println("The new expiry date must be after the current expiry date.");
		}
	}

	/**
	 * this method updates the notification preferences of the external member
	 * @param preferences
	 */
	public void updateNotificationPreferences(List<String> preferences) {
		if (preferences == null) {
			System.out.println("Notification preferences cannot be empty.");
			return;
		}
		notificationPreferences = preferences;
		System.out.println("Notification preferences updated successfully.");

	}

	/**
	 * this method pays the subscription fee of the external member
	 * @param amount
	 */
	public void paySubscriptionFee(double amount) {
		if (amount <= 0) {
			System.out.println("Payment amount must be greater than zero.");
			return;
		}

		if (amount < subscriptionFee) {
			System.out.println("Insufficient payment. Subscription fee is: $" + subscriptionFee);
		} else if (amount >= subscriptionFee) {
			double change = amount - subscriptionFee;
			subscriptionFee = 0;
			System.out.println("Subscription fee paid successfully.");
			if (change > 0) {
				System.out.println("Your Change: $" + change);
			}
		}
	}

	/**
	 * this method displays the details of the external member
	 */
	@Override
	public void displayMemberDetails() {
		System.out.println("Member ID: " + getMemberId() + ", Name: " + getName() + ", Type: "
				+ this.getClass().getSimpleName());
	}

	/**
	 * this method generates the membership report of the external member
	 */
	@Override
	public void generateMembershipReport() {
		System.out
				.println(" - Member: " + getName() + "," + " Total Borrowed Items: " + getBorrowTransactions().size());
	}

}
