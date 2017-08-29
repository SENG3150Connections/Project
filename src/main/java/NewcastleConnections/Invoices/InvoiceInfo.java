package NewcastleConnections.Invoices;

import org.jooq.types.UInteger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Jack on 27/08/2017.
 */
public class InvoiceInfo {
    private UInteger id;
    private Timestamp purchasedate;
    private double price;
    private UInteger status;

    public UInteger getId() {
        return id;
    }

    public void setId(UInteger id) {
        this.id = id;
    }

    public String getPurchasedate() {
        return new SimpleDateFormat("hh:mm a dd/MM/yyyy").format(purchasedate);
    }

    public void setPurchasedate(Timestamp purchasedate) {
        this.purchasedate = purchasedate;
    }

    public String getPrice() {
        return "$" + String.format( "%.2f", price );
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UInteger getStatus() {
        return status;
    }

    public void setStatus(UInteger status) {
        this.status = status;
    }
}
