package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.InvoicehotelRecord;
import NewcastleConnections.packagedeals.tables.records.RoomofferingsRecord;
import org.jooq.types.UInteger;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Scott on 22/08/2017.
 */
public class CartHotel {

    private HotelsRecord hotel = null;
    private RoomofferingsRecord room = null;
    private InvoicehotelRecord invoice = null;
    // check in/out vars?

    public CartHotel(int hotelID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            hotel = connection.getDSL().selectFrom(HOTELS).where(HOTELS.ID.eq(UInteger.valueOf(hotelID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CartHotel(int hotelID, int roomID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            hotel = connection.getDSL().selectFrom(HOTELS).where(HOTELS.ID.eq(UInteger.valueOf(hotelID))).fetch().get(0);
            room = connection.getDSL().selectFrom(ROOMOFFERINGS).where(ROOMOFFERINGS.ID.eq(UInteger.valueOf(roomID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean isPrepared() {
        return room != null;
    }

    public InvoicehotelRecord getInvoice() {
        if (!isPrepared()) {
            return null;
        }

        if (invoice == null) {
            invoice = new InvoicehotelRecord();
        }

        invoice.setRoomid(room.getId());
        // todo the rest

        return invoice;
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
}
