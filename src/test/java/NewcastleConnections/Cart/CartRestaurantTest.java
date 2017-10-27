package NewcastleConnections.Cart;

import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Jack on 22/10/2017.
 */
public class CartRestaurantTest extends StrutsJUnit4TestCase<CartRestaurant> {

    private CartRestaurant cartRestaurant = new CartRestaurant(001);
    private java.sql.Date date =  new java.sql.Date(2017,1,1);
    private Byte b = 0;
    private Byte b2 = 1;
    private Byte b3 = 2;
    private Byte b4 = 3;
    private ResturantsRecord restaurant = new ResturantsRecord(UInteger.valueOf(1), "TestName","TestAddress","TestContact","TestEmail","TestWebsite","TestDescription",b,b2,100.0,50.0,"TestImageID","TestCategory",b3,b4,date);

    private java.sql.Timestamp timestamp = new Timestamp(1,1,1,1,1,1,1);
    private InvoicesRecord invoice = new InvoicesRecord(UInteger.valueOf(3),"TestCustomerID",timestamp,1.0,UInteger.valueOf(4));


    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void getName() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        assertEquals("TestName", cartRestaurant.getName());
    }

    @Test
    public void getId() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        assertEquals(1, cartRestaurant.getId());
    }

    @Test
    public void getReady() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        assertEquals(false, cartRestaurant.getReady());
        cartRestaurant.setTime(timestamp);
        cartRestaurant.setSeats(1);
        assertEquals(true, cartRestaurant.getReady());
        cartRestaurant.setTime(null);
        assertEquals(false, cartRestaurant.getReady());

    }

    @Test
    public void getPrice() throws Exception {
        double testDouble = 1;
        cartRestaurant.setVoucherPrice(testDouble);
        assertTrue(testDouble == cartRestaurant.getPrice());
    }

    @Ignore("Cannot set invoice to test")
    @Test
    public void getInvoice() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        //cartRestaurant.setInvoice(invoice);
    }

    @Test
    public void getInvoiceIsNull() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        assertNull(cartRestaurant.getInvoice());
    }

    @Test
    public void getRestaurant() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        assertEquals(restaurant, cartRestaurant.getRestaurant());
    }

    @Test
    public void setRestaurant() throws Exception {
        cartRestaurant.setRestaurant(restaurant);
        assertEquals(restaurant, cartRestaurant.getRestaurant());
    }

    @Test
    public void getTime() throws Exception {
        cartRestaurant.setTime(timestamp);
        assertEquals(timestamp, cartRestaurant.getTime());
    }

    @Test
    public void setTime() throws Exception {
        cartRestaurant.setTime(timestamp);
        assertEquals(timestamp, cartRestaurant.getTime());
    }

    @Test
    public void getSeats() throws Exception {
        cartRestaurant.setSeats(3);
        assertEquals(3, cartRestaurant.getSeats());
    }

    @Test
    public void setSeats() throws Exception {
        cartRestaurant.setSeats(3);
        assertEquals(3, cartRestaurant.getSeats());
    }

    @Test
    public void getVoucherPrice() throws Exception {
        double testDouble = 1;
        cartRestaurant.setVoucherPrice(testDouble);
        assertTrue(testDouble == cartRestaurant.getPrice());

    }

    @Test
    public void setVoucherPrice() throws Exception {
        double testDouble = 1;
        cartRestaurant.setVoucherPrice(testDouble);
        assertTrue(testDouble == cartRestaurant.getPrice());
    }

}