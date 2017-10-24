package NewcastleConnections.Invoices;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Test;
import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

public class HotelInvoiceInfoTest extends StrutsJUnit4TestCase<HotelInvoiceInfo> {

    @Test
    public void getRoomID() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setRoomID(UInteger.valueOf(1));
        assertTrue(object.getRoomID() == 1);
    }

    @Test
    public void getAdults() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setAdults(2);
        assertTrue(object.getAdults() == 2);
    }

    @Test
    public void getChildren() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setChildren(1);
        assertTrue(object.getChildren() == 1);
    }

    @Test
    public void getCheckIn() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setCheckIn(Timestamp.valueOf("2017-10-01 00:00:00"));
        assertTrue(object.getCheckIn().matches("\\d{2}:\\d{2} .. \\d{2}\\/\\d{2}\\/\\d{4}"));
    }

    @Test
    public void getCheckOut() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setCheckOut(Timestamp.valueOf("2017-10-01 00:00:00"));
        assertTrue(object.getCheckOut().matches("\\d{2}:\\d{2} .. \\d{2}\\/\\d{2}\\/\\d{4}"));
    }

    @Test
    public void getHotelPrice() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setHotelPrice(100.0);
        assertTrue(object.getHotelPrice().matches("\\$\\d+.?\\d{2}"));
    }

    @Test
    public void getHotelID() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setHotelID(UInteger.valueOf(1));
        assertTrue(object.getHotelID() == 1);
    }

    @Test
    public void getRoomTypeID() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setRoomTypeID(UInteger.valueOf(1));
        assertTrue(object.getRoomTypeID() == 1);
    }

    @Test
    public void getRoomType() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setRoomType("RoomType");
        assertTrue(object.getRoomType().equals("RoomType"));

    }

    @Test
    public void getHotelName() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setHotelName("Hotel");
        assertTrue(object.getHotelName().equals("Hotel"));
    }

    @Test
    public void getHotelContact() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setHotelContact("Contact");
        assertTrue(object.getHotelContact().equals("Contact"));
    }

    @Test
    public void getHotelAddress() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setHotelAddress("Address");
        assertTrue(object.getHotelAddress().equals("Address"));
    }

    @Test
    public void getHotelImageID() {
        HotelInvoiceInfo object = new HotelInvoiceInfo();
        object.setHotelImageID("ImageID");
        assertTrue(object.getHotelImageID().equals("ImageID"));


    }



}
