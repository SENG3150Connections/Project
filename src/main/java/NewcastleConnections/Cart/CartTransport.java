package NewcastleConnections.Cart;

/*
CartExperience.java
Author: Scott Walker

Description:
    The cart item to store Transport.
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicetransportRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.*;

public class CartTransport implements CartItem {

    // private member data
    private TransportRecord transport = null;
    private InvoicetransportRecord invoice = null;
    private int tickets = 0;
    private Timestamp time = null;

    // -- Constructor --
    //   Role: Initialise the CartTransport of certain ID.
    //
    public CartTransport(int transportID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();

            try {
                Result<TransportRecord> records  = connection.getDSL().selectFrom(TRANSPORT).where(TRANSPORT.ID.eq(UInteger.valueOf(transportID))).fetch();
                if (records.size() > 0)
                    transport = records.get(0);
            } catch (NumberFormatException e) {
                return;
            }

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // -- Interface methods --

    public String getName() {
        return transport.getName();
    }

    public int getId() {
        return transport.getId().intValue();
    }

    public boolean getReady() {
        // Must have at least 1 ticket and a time booked.
        return tickets > 0 && time != null;
    }

    public double getPrice() {
        return tickets * transport.getTicketprice();
    }

    // -- Other methods --

    // -- Public --
    //   Role: Get the invoice for this cart item.
    //
    public InvoicetransportRecord getInvoice() {
        if (!getReady()) {
            return null;
        }

        if (invoice == null) {
            invoice = new InvoicetransportRecord();
        }

        invoice.setTransportid(transport.getId());
        invoice.setPrice(getPrice());
        invoice.setTime(time);

        return invoice;
    }

    // -- Getters and Setters --

    public TransportRecord getTransport() {
        return transport;
    }

    public void setTransport(TransportRecord transport) {
        this.transport = transport;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
