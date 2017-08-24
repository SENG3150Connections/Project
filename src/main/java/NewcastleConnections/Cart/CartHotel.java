package NewcastleConnections.Cart;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.InvoicehotelRecord;
import NewcastleConnections.packagedeals.tables.records.RoomofferingsRecord;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Scott on 22/08/2017.
 */
public class CartHotel {

    private HotelsRecord hotel = null;
    private RoomofferingsRecord room = null;
    private InvoicehotelRecord invoice = null;
    private int adults = 0;
    private int children = 0;
    private Timestamp checkIn = null;
    private Timestamp checkOut = null;
    private Double price = null;

    public CartHotel(int hotelID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            hotel = connection.getDSL().selectFrom(HOTELS).where(HOTELS.ID.eq(UInteger.valueOf(hotelID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isPrepared() {
        return room != null && adults > 0 && children >= 0 && checkIn != null && checkOut != null;
    }

    public InvoicehotelRecord getInvoice() {
        if (!isPrepared()) {
            return null;
        }

        if (invoice == null) {
            invoice = new InvoicehotelRecord();
        }

        invoice.setRoomid(room.getId());
        invoice.setAdults(adults);
        invoice.setChildren(children);
        invoice.setCheckin(checkIn);
        invoice.setCheckout(checkOut);
        invoice.setPrice(price);

        return invoice;
    }

    public void updatePrice() {
        double rate = 150.0;
        long divisor = 1000 * 60 * 60 * 24;

        if (checkIn == null || checkOut == null) {
            setPrice(0.0);
            return;
        }

        long nights = checkOut.getTime() - checkIn.getTime();
        nights /= divisor;
        nights++;
        setPrice(rate * nights);
    }

    // -- Getters and Setters --

    public HotelsRecord getHotel() {
        return hotel;
    }

    public void setHotel(HotelsRecord hotel) {
        this.hotel = hotel;
    }

    public RoomofferingsRecord getRoom() {
        return room;
    }

    public void setRoom(RoomofferingsRecord room) {
        this.room = room;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
        updatePrice();
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
        updatePrice();
    }

    public Double getPrice() {
        return price;
    }

    private void setPrice(Double price) {
        this.price = price;
    }
}
