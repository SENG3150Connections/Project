package NewcastleConnections.InvoiceInfo;

import org.jooq.types.UInteger;

/**
 * Created by Jack on 22/08/2017.
 */
public class ExperienceInvoiceInfo {
    //Experience Data from Invoiceexperience Table
    private UInteger experienceID;
    private double price;
    //Experience Data from Invoice Table
    private String name;
    private String location;
    private String imageID;

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
