package com.example.climatehopefund_trial1;

public class DonationCards {
    private int donation_img;
    private String donation_org_name;
    private String info_donation;
    private String know_more_donation;
    private int donation_amount_total;



    public DonationCards(int donation_amount_total) {
        this.donation_amount_total = donation_amount_total;
    }

    public int getDonation_amount_total() {
        return donation_amount_total;
    }

    public void setDonation_amount_total(int donation_amount_total) {
        this.donation_amount_total = donation_amount_total;
    }

    public int getDonation_img() {
        return donation_img;
    }

    public void setDonation_img(int donation_img) {
        this.donation_img = donation_img;
    }

    public String getDonation_org_name() {
        return donation_org_name;
    }

    public void setDonation_org_name(String donation_org_name) {
        this.donation_org_name = donation_org_name;
    }

    public String getInfo_donation() {
        return info_donation;
    }

    public void setInfo_donation(String info_donation) {
        this.info_donation = info_donation;
    }

    public String getKnow_more_donation() {
        return know_more_donation;
    }

    public void setKnow_more_donation(String know_more_donation) {
        this.know_more_donation = know_more_donation;
    }

    public DonationCards(int donation_img, String donation_org_name,String info_donation , String know_more_donation) {
        this.donation_img = donation_img;
        this.donation_org_name = donation_org_name;
        this.info_donation = info_donation;
        this.know_more_donation = know_more_donation;
    }
}
