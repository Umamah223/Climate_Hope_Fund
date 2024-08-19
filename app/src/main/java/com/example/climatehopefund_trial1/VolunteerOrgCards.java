package com.example.climatehopefund_trial1;

import android.widget.ImageView;
import android.widget.Button;

public class VolunteerOrgCards {
//    Model Class
    private int volunteer_img;
    private String volunteer_org_name;
    private String info_volunteer;
    private String know_more;

    private int volunteer_category_1;
    private int volunteer_category_2;

    private String volunteer_category_title;
    private String volunteer_category_location;

    private Button volunteerButton;

    public Button getVolunteerButton() {
        return volunteerButton;
    }

    public void setVolunteerButton(Button volunteerButton) {
        this.volunteerButton = volunteerButton;
    }

    public VolunteerOrgCards(Button volunteerButton) {
        this.volunteerButton = volunteerButton;
    }

    public String getVolunteer_category_location() {
        return volunteer_category_location;
    }

    public void setVolunteer_category_location(String volunteer_category_location) {
        this.volunteer_category_location = volunteer_category_location;
    }

    public VolunteerOrgCards(String volunteer_category_title) {
        this.volunteer_category_title = volunteer_category_title;
    }

    public String getVolunteer_category_title() {
        return volunteer_category_title;
    }

    public void setVolunteer_category_title(String volunteer_category_title) {
        this.volunteer_category_title = volunteer_category_title;
    }

    public int getVolunteer_category_2() {
        return volunteer_category_2;
    }

    public void setVolunteer_category_2(int volunteer_category_2) {
        this.volunteer_category_2 = volunteer_category_2;
    }

    public VolunteerOrgCards(int volunteer_category_1) {
        this.volunteer_category_1 = volunteer_category_1;
    }

    public int getVolunteer_category_1() {
        return volunteer_category_1;
    }

    public void setVolunteer_category_1(int volunteer_category_1) {
        this.volunteer_category_1 = volunteer_category_1;
    }

    //    Constructor
    public VolunteerOrgCards(int volunteer_img, String volunteer_org_name, String info_volunteer, String know_more) {
        this.volunteer_img = volunteer_img;
        this.volunteer_org_name = volunteer_org_name;
        this.info_volunteer = info_volunteer;
        this.know_more = know_more;
    }

    public int getVolunteer_img() {
        return volunteer_img;
    }

    public void setVolunteer_img(int volunteer_img) {
        this.volunteer_img = volunteer_img;
    }

    public String getVolunteer_org_name() {
        return volunteer_org_name;
    }

    public void setVolunteer_org_name(String volunteer_org_name) {
        this.volunteer_org_name = volunteer_org_name;
    }

    public String getInfo_volunteer() {
        return info_volunteer;
    }

    public void setInfo_volunteer(String info_volunteer) {
        this.info_volunteer = info_volunteer;
    }

    public String getKnow_more() {
        return know_more;
    }

    public void setKnow_more(String know_more) {
        this.know_more = know_more;
    }
}
