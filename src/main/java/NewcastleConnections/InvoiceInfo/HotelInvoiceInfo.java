package NewcastleConnections.InvoiceInfo;

import org.jooq.types.UInteger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Jack on 22/08/2017.
 */
public class HotelInvoiceInfo {
    //Hotel/Room Data from Invoicehotel table
    private UInteger roomID;
    private int adults;
    private int children;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private double hotelPrice;

    //Room data from Roomofferings table
    private UInteger hotelID;
    private UInteger roomTypeID;

    //Room data from Roomtypes table
    private String roomType;

    //Hotel data from Hotels table
    private String hotelName;
    private String hotelContact;
    private String hotelAddress;
    private String hotelImageID;

    public int getRoomID() {
        return roomID.intValue();
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

    public String getCheckIn() {
        return new SimpleDateFormat("hh:mm a dd/MM/yyyy").format(checkIn);
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return new SimpleDateFormat("hh:mm a dd/MM/yyyy").format(checkOut);
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public String getHotelPrice() {
        return "$" + String.format( "%.2f", hotelPrice );
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public int getHotelID() {
        return hotelID.intValue();
    }

    public void setHotelID(UInteger hotelID) {
        this.hotelID = hotelID;
    }

    public int getRoomTypeID() {
        return roomTypeID.intValue();
    }

    public void setRoomTypeID(UInteger roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
