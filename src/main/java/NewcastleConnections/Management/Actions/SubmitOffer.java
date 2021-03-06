package NewcastleConnections.Management.Actions;

/*
SubmitOffer.java
Author: Harry Barden

Description:
    Submit a new offer to the database
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.sql.SQLException;

public class SubmitOffer extends ActionSupport {
    HotelsRecord hotel;

    private String name;
    private String contact;
    private String email;
    private String address;
    private String website;
    private String description;
    private double latitude;
    private double longitude;
    private byte publicallyvisible;
    private byte releaseondate;
    private Date releasedate;
    private String imageid;
    private String category;

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
    @Override
    public String execute() {
        hotel = new HotelsRecord();

        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            connection.getDSL().attach(hotel);

            // query
            hotel.setName(name);
            hotel.setContact(contact);
            hotel.setEmail(email);
            hotel.setAddress(address);
            hotel.setWebsite(website);
            hotel.setDescription(description);
            hotel.setLatitude(latitude);
            hotel.setLongitude(longitude);
            hotel.setPublicallyvisible(publicallyvisible);
            hotel.setReleaseondate(releaseondate);
            hotel.setReleasedate(releasedate);
            hotel.setImageid(imageid);
            hotel.setCategory(category);
            hotel.store();

            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

    // -- Getters and Setters --

    public HotelsRecord getHotel() {
        return hotel;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPublicallyvisible(byte publicallyvisible) {
        this.publicallyvisible = publicallyvisible;
    }

    public void setReleaseondate(byte releaseondate) {
        this.releaseondate = releaseondate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
