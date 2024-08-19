package com.example.climatehopefund_trial1;

public class VolunteerCategory {
    private String CategoryId;
    private String Organizations_CategoryName;
    private String VolunteerOrgId;

    public VolunteerCategory(String categoryId, String organizations_CategoryName, String volunteerOrgId) {
        CategoryId = categoryId;
        Organizations_CategoryName = organizations_CategoryName;
        VolunteerOrgId = volunteerOrgId;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getOrganizations_CategoryName() {
        return Organizations_CategoryName;
    }

    public void setOrganizations_CategoryName(String organizations_CategoryName) {
        Organizations_CategoryName = organizations_CategoryName;
    }

    public String getVolunteerOrgId() {
        return VolunteerOrgId;
    }

    public void setVolunteerOrgId(String volunteerOrgId) {
        VolunteerOrgId = volunteerOrgId;
    }
}
