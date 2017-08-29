package NewcastleConnections.Invoices;

/*
RestaurantInvoiceInfo.java
Author: Jack Ratcliffe

Description:
    Class to store all raw data for an invoice
*/

import org.jooq.types.UInteger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RestaurantInvoiceInfo {

    //Restaurant Data from Invoicerestaurant table
    private UInteger restaurantID;
    private Timestamp restaurantTime;
    private int restaurantSeats;
    private double restaurantPrice;

    //Restaurant data from restaurant table
    private String restaurantName;
    private String restaurantContact;
    private String restaurantAddress;
    private String restaurantImageID;

    // -- Getters and Setters --

    public int getRestaurantID() {
        return restaurantID.intValue();
    }

    public void setRestaurantID(UInteger restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantTime() {
        return new SimpleDateFormat("hh:mm a dd/MM/yyyy").format(restaurantTime);
    }

    public void setRestaurantTime(Timestamp restaurantTime) {
        this.restaurantTime = restaurantTime;
    }

    public int getRestaurantSeats() {
        return restaurantSeats;
    }

    public void setRestaurantSeats(int restaurantSeats) {
        this.restaurantSeats = restaurantSeats;
    }

    public String getRestaurantPrice() {
        return "$" + String.format( "%.2f", restaurantPrice );
    }

    public void setRestaurantPrice(double restaurantPrice) {
        this.restaurantPrice = restaurantPrice;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantContact() {
        return restaurantContact;
    }

    public void setRestaurantContact(String restaurantContact) {
        this.restaurantContact = restaurantContact;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantImageID() {
        return restaurantImageID;
    }

    public void setRestaurantImageID(String restaurantImageID) {
        this.restaurantImageID = restaurantImageID;
    }
}
