package NewcastleConnections.Invoices;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

public class RestaurantInvoiceInfoTest extends StrutsJUnit4TestCase<RestaurantInvoiceInfo> {


    @Test
    public void getRestaurantID() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantID(UInteger.valueOf(1));
        assertTrue(object.getRestaurantID() == 1);
    }

    @Test
    public void getRestaurantTime() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantTime(Timestamp.valueOf("2017-10-01 00:00:00"));
        assertTrue(object.getRestaurantTime().matches("\\d{2}:\\d{2} .. \\d{2}\\/\\d{2}\\/\\d{4}"));
    }

    @Test
    public void getRestaurantSeats() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantSeats(50);
        assertTrue(object.getRestaurantSeats() == 50);
    }

    @Test
    public void getRestaurantPrice() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantPrice(100.0);
        assertTrue(object.getRestaurantPrice().matches("\\$\\d+.?\\d{2}"));
    }

    @Test
    public void getRestaurantName() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantName("Name");
        assertTrue(object.getRestaurantName().equals("Name"));
    }

    @Test
    public void getRestaurantContact() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantContact("Name");
        assertTrue(object.getRestaurantContact().equals("Name"));
    }

    @Test
    public void getRestaurantAddress() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantContact("Name");
        assertTrue(object.getRestaurantContact().equals("Name"));
    }

    @Test
    public void getRestaurantImageID() {
        RestaurantInvoiceInfo object = new RestaurantInvoiceInfo();
        object.setRestaurantImageID("ImageId");
        assertTrue(object.getRestaurantImageID().equals("ImageId"));
    }




}
