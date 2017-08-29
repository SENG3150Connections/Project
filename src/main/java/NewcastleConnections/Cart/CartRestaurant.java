package NewcastleConnections.Cart;

/*
CartRestaurant.java
Author: Scott Walker

Description:
    The cart item to store Restaurants.
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicerestaurantRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.*;

public class CartRestaurant implements CartItem {

    // Private member data
    private ResturantsRecord restaurant = null;
    private InvoicerestaurantRecord invoice = null;
    private int seats = 0;
    private Timestamp time = null;
    private Double voucherPrice = null;

    // -- Constructor --
    //   Role: Initialise the CartRestaurant of certain ID.
    //
    public CartRestaurant(int restaurantID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            restaurant = connection.getDSL().selectFrom(RESTURANTS).where(RESTURANTS.ID.eq(UInteger.valueOf(restaurantID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // -- Interface methods --

    public String getName() {
        return restaurant.getName();
    }

    public int getId() {
        return restaurant.getId().intValue();
    }

    public boolean getReady() {
        // Must have a booking time and at least 1 seat booked.
        return time != null && seats > 0;
    }

    public double getPrice() {
        return voucherPrice;
    }

    // -- Other methods --

    // -- Public --
    //   Role: Get the invoice for this cart item.
    //
    public InvoicerestaurantRecord getInvoice() {
        if (!getReady()) {
            return null;
        }

        if (invoice == null) {
            invoice = new InvoicerestaurantRecord();
        }

        invoice.setRestaurantid(restaurant.getId());
        invoice.setTime(time);
        invoice.setSeats(seats);
        invoice.setVoucherprice(voucherPrice);

        return invoice;
    }

    // -- Getters and Setters --

    public ResturantsRecord getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(ResturantsRecord restaurant) {
        this.restaurant = restaurant;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Double getVoucherPrice() {
        return voucherPrice;
    }

    public void setVoucherPrice(Double voucherPrice) {
        this.voucherPrice = voucherPrice;
    }
}
