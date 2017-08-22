package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.records.InvoicetransportRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Scott on 22/08/2017.
 */
public class CartTransport {

    private TransportRecord transport = null;
    private InvoicetransportRecord invoice = null;
    private Timestamp time = null;

    public CartTransport(int transportID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            transport = connection.getDSL().selectFrom(TRANSPORT).where(TRANSPORT.ID.eq(UInteger.valueOf(transportID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isPrepared() {
        return time != null;
    }

    public InvoicetransportRecord getInvoice() {
        if (!isPrepared()) {
            return null;
        }

        if (invoice == null) {
            invoice = new InvoicetransportRecord();
        }

        invoice.setTransportid(transport.getId());
        invoice.setPrice(transport.getTicketprice());
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
