package NewcastleConnections.Invoices;

/*
ExperienceInvoiceInfo.java
Author: Jack Ratcliffe

Description:
    Class to store all raw data for an invoice
*/

import org.jooq.types.UInteger;

public class ExperienceInvoiceInfo {

    //Experience Data from Invoiceexperience Table
    private UInteger experienceID;
    private double price;

    //Experience Data from Invoice Table
    private String name;
    private String location;
    private String imageID;

    // -- Getters and Setters --

    public int getExperienceID() {
        return experienceID.intValue();
    }

    public void setExperienceID(UInteger experienceID) {
        this.experienceID = experienceID;
    }

    public String getPrice() {
        return "$" + String.format( "%.2f", price );
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
