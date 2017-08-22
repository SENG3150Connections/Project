package NewcastleConnections.InvoiceInfo;

import org.jooq.types.UInteger;

import java.sql.Timestamp;

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

    public UInteger getTransportID() {
        return transportID;
    }

    public void setTransportID(UInteger transportID) {
        this.transportID = transportID;
    }

    public Timestamp getTransportTime() {
        return transportTime;
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

    public double getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
    }
}
