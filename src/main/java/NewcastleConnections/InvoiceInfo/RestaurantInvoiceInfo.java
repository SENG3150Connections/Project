package NewcastleConnections.InvoiceInfo;

import org.jooq.types.UInteger;

import java.sql.Timestamp;

/**
 * Created by Jack on 22/08/2017.
 */
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

    public UInteger getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(UInteger restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Timestamp getRestaurantTime() {
        return restaurantTime;
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

    public double getRestaurantPrice() {
        return restaurantPrice;
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
