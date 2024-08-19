package com.example.climatehopefund_trial1;

public class Volunteer {
    private String UserId;
    private String Volunteering_Org_Name;
    private String Volunteering_Org_Id;
    private String Volunteering_Org_CategoryId;
    private String Volunteering_Org_CategoryName;

    public Volunteer(String  UserId, String volunteering_Org_Name, String volunteering_Org_Id, String volunteering_Org_CategoryId, String volunteering_Org_CategoryName) {
        this.UserId = UserId;
        Volunteering_Org_Name = volunteering_Org_Name;
        Volunteering_Org_Id = volunteering_Org_Id;
        Volunteering_Org_CategoryId = volunteering_Org_CategoryId;
        Volunteering_Org_CategoryName = volunteering_Org_CategoryName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String  UserId) {
        this.UserId = UserId;
    }

    public String getVolunteering_Org_Name() {
        return Volunteering_Org_Name;
    }

    public void setVolunteering_Org_Name(String volunteering_Org_Name) {
        Volunteering_Org_Name = volunteering_Org_Name;
    }

    public String  getVolunteering_Org_Id() {
        return Volunteering_Org_Id;
    }

    public void setVolunteering_Org_Id(String  volunteering_Org_Id) {
        Volunteering_Org_Id = volunteering_Org_Id;
    }

    public String  getVolunteering_Org_CategoryId() {
        return Volunteering_Org_CategoryId;
    }

    public void setVolunteering_Org_CategoryId(String  volunteering_Org_CategoryId) {
        Volunteering_Org_CategoryId = volunteering_Org_CategoryId;
    }

    public String getVolunteering_Org_CategoryName() {
        return Volunteering_Org_CategoryName;
    }

    public void setVolunteering_Org_CategoryName(String volunteering_Org_CategoryName) {
        Volunteering_Org_CategoryName = volunteering_Org_CategoryName;
    }
}
