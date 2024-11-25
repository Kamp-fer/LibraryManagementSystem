package model;

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

	public ExternalMember(String externalId, String organization, double subscriptionFee,
			LocalDate membershipExpiryDate, List<String> notificationPreferences) {
		setExternalId(externalId);
		setOrganization(organization);
		setSubscriptionFee(subscriptionFee);
		setMembershipExpiryDate(membershipExpiryDate);
		setNotificationPreferences(notificationPreferences);
	}

	public ExternalMember(int memberid, String name, Address address, String phoneNumber, String email,
			LocalDate membershipStartDate, ArrayList<BorrowTransaction> borrowTranscations, int borrowLimit,
			String externalId, String organization, double subscriptionFee, LocalDate membershipExpiryDate,
			List<String> notificationPreferences) {
		super(memberid, name, address, phoneNumber, email, membershipStartDate, borrowTranscations, borrowLimit);
		setExternalId(externalId);
		setOrganization(organization);
		setSubscriptionFee(subscriptionFee);
		setMembershipExpiryDate(membershipExpiryDate);
		setNotificationPreferences(notificationPreferences);
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

	public void renewMembershipDate(LocalDate newDate) {
		if (newDate.isAfter(membershipExpiryDate)) {
			membershipExpiryDate = newDate;
			System.out.println("Membership renewed successfully. New expiry date: " + membershipExpiryDate);
		} else {
			System.out.println("The new expiry date must be after the current expiry date.");
		}
	}

	public void updateNotificationPreferences(List<String> preferences) {
		if (preferences == null) {
			System.out.println("Notification preferences cannot be empty.");
			return;
		}
		notificationPreferences = preferences;
		System.out.println("Notification preferences updated successfully.");

	}

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

}
