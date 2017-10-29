package NewcastleConnections.Invoices;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

public class TransportInvoiceInfoTest extends StrutsJUnit4TestCase<TransportInvoiceInfo> {

    @Test
    public void getTransportID() {
        TransportInvoiceInfo object = new TransportInvoiceInfo();
        object.setTransportID(UInteger.valueOf(1));
        assertTrue(object.getTransportID() == 1);
    }

    @Test
    public void getTransportTime() {
        TransportInvoiceInfo object = new TransportInvoiceInfo();
        object.setTransportTime(Timestamp.valueOf("2017-10-01 00:00:00"));
        assertTrue(object.getTransportTime().matches("\\d{2}:\\d{2} .. \\d{2}\\/\\d{2}\\/\\d{4}"));
    }

    @Test
    public void getTransportName() {
        TransportInvoiceInfo object = new TransportInvoiceInfo();
        object.setTransportName("Name");
        assertTrue(object.getTransportName().equals("Name"));
    }

    @Test
    public void getTransportPrice() {
        TransportInvoiceInfo object = new TransportInvoiceInfo();
        object.setTransportPrice(100.0);
        assertTrue(object.getTransportPrice().matches("\\$\\d+.?\\d{2}"));
    }

}
