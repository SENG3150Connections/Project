package NewcastleConnections.InvoiceInfo;

import org.jooq.types.UInteger;

import java.sql.Timestamp;

/**
 * Created by Jack on 22/08/2017.
 */
public class HotelInvoiceInfo {
    //Hotel/Room Data from Invoicehotel table
    private UInteger roomID;
    private int adults;
    private int children;
    private Timestamp checkin;
    private Timestamp checkout;
    private double hotelPrice;

    //Room data from Roomofferings table
    private UInteger hotelID;
    private UInteger roomTypeID;

    //Room data from Roomtypes table
    private String roomtype;

    //Hotel data from Hotels table
    private String hotelName;
    private String hotelContact;
    private String hotelAddress;
    private String hotelImageID;

    public UInteger getRoomID() {
        return roomID;
    }

    public void setRoomID(UInteger roomID) {
        this.roomID = roomID;
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

    public Timestamp getCheckin() {
        return checkin;
    }

    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }

    public Timestamp getCheckout() {
        return checkout;
    }

    public void setCheckout(Timestamp checkout) {
        this.checkout = checkout;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public UInteger getHotelID() {
        return hotelID;
    }

    public void setHotelID(UInteger hotelID) {
        this.hotelID = hotelID;
    }

    public UInteger getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(UInteger roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelContact() {
        return hotelContact;
    }

    public void setHotelContact(String hotelContact) {
        this.hotelContact = hotelContact;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelImageID() {
        return hotelImageID;
    }

    public void setHotelImageID(String hotelImageID) {
        this.hotelImageID = hotelImageID;
    }
}
