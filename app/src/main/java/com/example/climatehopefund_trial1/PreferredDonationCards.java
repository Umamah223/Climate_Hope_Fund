package com.example.climatehopefund_trial1;

public class PreferredDonationCards {
//    private String imageUrl;
    private int Image;
    private String organizationName;
    private String info;
    private String know_more;

    public PreferredDonationCards(int Image, String organizationName, String info, String know_more) {
        this.Image = Image;
        this.organizationName = organizationName;
        this.info = info;
        this.know_more = know_more;
    }

    public int getImage() {
        return Image ;
    }

    public void setImage(int Image) {
        this.Image = Image;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getKnow_more() {
        return know_more;
    }

    public void setKnow_more(String know_more) {
        this.know_more = know_more;
    }
}
