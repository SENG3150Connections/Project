package NewcastleConnections.Cart;

import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Jack on 27/10/2017.
 */
public class CartTransportTest extends StrutsJUnit4TestCase<Cart> {

    private CartTransport cartTransport = new CartTransport(001);
    private java.sql.Date date =  new java.sql.Date(2017,1,1);
    private Byte b = 0;
    private TransportRecord transport = new TransportRecord(UInteger.valueOf(1), "TestName",10.0,b,"TestDescription",100.0,50.0,25.0,10.0);

    private java.sql.Timestamp timestamp = new Timestamp(1,1,1,1,1,1,1);
    private InvoicesRecord invoice = new InvoicesRecord(UInteger.valueOf(3),"TestCustomerID",timestamp,1.0,UInteger.valueOf(4));
    
    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void getName() throws Exception {
        cartTransport.setTransport(transport);
        assertEquals("TestName", cartTransport.getName());
    }

    @Test
    public void getId() throws Exception {
        cartTransport.setTransport(transport);
        assertEquals(1, cartTransport.getId());
    }

    @Test
    public void getReady() throws Exception {
        cartTransport.setTransport(transport);
        assertEquals(false, cartTransport.getReady());
        cartTransport.setTime(timestamp);
        cartTransport.setTickets(1);
        assertEquals(true, cartTransport.getReady());
        cartTransport.setTime(null);
        assertEquals(false, cartTransport.getReady());
    }

    @Ignore("Cannot set price to test")
    @Test
    public void getPrice() throws Exception {
        double testDouble = 1;
        //cartTransport.setPrice(testDouble);
        assertTrue(testDouble == cartTransport.getPrice());
    }

    @Ignore("Cannot set invoice to test")
    @Test
    public void getInvoice() throws Exception {
        cartTransport.setTransport(transport);
        //cartTransport.setInvoice(invoice);
    }

    @Test
    public void getInvoiceIsNull() throws Exception {
        cartTransport.setTransport(transport);
        assertNull(cartTransport.getInvoice());
    }

    @Test
    public void getTransport() throws Exception {
        cartTransport.setTransport(transport);
        assertEquals(transport, cartTransport.getTransport());
    }

    @Test
    public void setTransport() throws Exception {
        cartTransport.setTransport(transport);
        assertEquals(transport, cartTransport.getTransport());
    }

    @Test
    public void getTickets() throws Exception {
        cartTransport.setTickets(1);
        assertEquals(1, cartTransport.getTickets());
    }

    @Test
    public void setTickets() throws Exception {
        cartTransport.setTickets(1);
        assertEquals(1, cartTransport.getTickets());
    }

    @Test
    public void getTime() throws Exception {
        cartTransport.setTime(timestamp);
        assertEquals(timestamp, cartTransport.getTime());
    }

    @Test
    public void setTime() throws Exception {
        cartTransport.setTime(timestamp);
        assertEquals(timestamp, cartTransport.getTime());
    }

}