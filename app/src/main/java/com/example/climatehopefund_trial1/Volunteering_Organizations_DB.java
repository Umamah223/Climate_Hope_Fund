
package com.example.climatehopefund_trial1;
public class Volunteering_Organizations_DB {
    private String OrganizationId;
    private String Volunteering_Organization_Name;

    public String getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(String organizationId) {
        OrganizationId = organizationId;
    }

    public String getVolunteering_Organization_Name() {
        return Volunteering_Organization_Name;
    }

    public void setVolunteering_Organization_Name(String volunteering_Organization_Name) {
        Volunteering_Organization_Name = volunteering_Organization_Name;
    }

    public Volunteering_Organizations_DB(String organizationId, String volunteering_Organization_Name) {
        OrganizationId = organizationId;
        Volunteering_Organization_Name = volunteering_Organization_Name;
    }
}
