package NewcastleConnections.Invoices;

import org.jooq.types.UInteger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Jack on 22/08/2017.
 */
public class TransportInvoiceInfo {
    //Transport Data from Invoicetransport table
    private UInteger transportID;
    private Timestamp transportTime;

    //Transport data from transport table
    private String transportName;
    private double transportPrice;

    public int getTransportID() {
        return transportID.intValue();
    }

    public void setTransportID(UInteger transportID) {
        this.transportID = transportID;
    }

    public String getTransportTime() {
        return new SimpleDateFormat("hh:mm a dd/MM/yyyy").format(transportTime);
    }

    public void setTransportTime(Timestamp transportTime) {
        this.transportTime = transportTime;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportPrice() {
        return "$" + String.format( "%.2f", transportPrice );
    }

    public void setTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
    }
}
