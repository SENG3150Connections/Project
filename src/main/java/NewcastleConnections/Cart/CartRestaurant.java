package NewcastleConnections.Cart;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicerestaurantRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Scott on 22/08/2017.
 */
public class CartRestaurant {

    private ResturantsRecord restaurant = null;
    private InvoicerestaurantRecord invoice = null;
    private int seats = 0;
    private Timestamp time = null;
    private Double voucherPrice = null;

    public CartRestaurant(int restaurantID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            restaurant = connection.getDSL().selectFrom(RESTURANTS).where(RESTURANTS.ID.eq(UInteger.valueOf(restaurantID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isPrepared() {
        return time != null && seats > 0;
    }

    public InvoicerestaurantRecord getInvoice() {
        if (!isPrepared()) {
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
