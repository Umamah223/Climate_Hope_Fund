package com.example.climatehopefund_trial1;

import android.os.Parcelable;

public class Donation {
    private String userId;
    private String DonationCategory;
    private String OrganizationDonatedTo;
    private String AmountDonated;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmountDonated() {
        return AmountDonated;
    }

    public void setAmountDonated(String amountDonated) {
        AmountDonated = amountDonated;
    }

    public String getDonationCategory() {
        return DonationCategory;
    }

    public void setDonationCategory(String donationCategory) {
        DonationCategory = donationCategory;
    }

    public String getOrganizationDonatedTo() {
        return OrganizationDonatedTo;
    }

    public void setOrganizationDonatedTo(String organizationDonatedTo) {
        OrganizationDonatedTo = organizationDonatedTo;
    }

    public Donation(String userId, String donationCategory, String organizationDonatedTo, String amountDonated) {
        this.userId = userId;
        DonationCategory = donationCategory;
        OrganizationDonatedTo = organizationDonatedTo;
        AmountDonated = amountDonated;
    }

}
