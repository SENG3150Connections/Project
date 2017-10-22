package NewcastleConnections.Cart;

import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.InvoicehotelRecord;
import NewcastleConnections.packagedeals.tables.records.RoomofferingsRecord;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Jack on 22/10/2017.
 */
public class CartHotelTest extends StrutsJUnit4TestCase<CartHotel>{

    private CartHotel cartHotel = new CartHotel(007);
    private java.sql.Date date =  new java.sql.Date(2017,1,1);
    private Byte b = 0;
    private HotelsRecord hotel = new HotelsRecord(UInteger.valueOf(1),"TestName","TestContact","TestEmail","TestAddress","TestWebsite","TestDescription",100.0,-100.0,b,b,date,"TestImageID","TestCategory");

    private RoomofferingsRecord room = new RoomofferingsRecord(UInteger.valueOf(2),UInteger.valueOf(3),UInteger.valueOf(4),UInteger.valueOf(10),"TestRoomDescription",UInteger.valueOf(5),UInteger.valueOf(6),"TestRoomTitle");
    private java.sql.Timestamp timestamp = new Timestamp(1,1,1,1,1,1,1);
    private java.sql.Timestamp timestamp2 = new Timestamp(2,2,2,2,2,2,2);
    private java.sql.Timestamp timestamp3 = new Timestamp(2,2,12,2,2,2,2);
    private InvoicehotelRecord invoice = new InvoicehotelRecord(UInteger.valueOf(7),UInteger.valueOf(8),1,2,timestamp,timestamp,100.0);

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void getName() throws Exception {
        cartHotel.setHotel(hotel);
        assertEquals("TestName", cartHotel.getName());
    }

    @Test
    public void getId() throws Exception {
        cartHotel.setHotel(hotel);
        assertEquals(1, cartHotel.getId());
    }

    @Test
    public void getReady() throws Exception {
        assertEquals(false, cartHotel.getReady());
        cartHotel.setAdults(1);
        cartHotel.setCheckIn(timestamp2);
        cartHotel.setCheckOut(timestamp3);
        //Room is null
        assertEquals(false, cartHotel.getReady());
        //Room is not null
        cartHotel.setRoom(room);
        assertEquals(true, cartHotel.getReady());
        //Adults > 0
        assertEquals(true, cartHotel.getReady());
        //Adults <=0
        cartHotel.setAdults(-1);
        assertEquals(false, cartHotel.getReady());
        //Children <=0
        cartHotel.setChildren(-1);
        assertEquals(false, cartHotel.getReady());
        //Checkin == null
        cartHotel.setCheckIn(null);
        assertEquals(false, cartHotel.getReady());
        //Checkout == null
        cartHotel.setCheckOut(null);
        assertEquals(false, cartHotel.getReady());
    }

    @Test
    public void getInvoiceNotReady() throws Exception {
        assertEquals(null,cartHotel.getInvoice());
    }

    @Test
    public void getInvoiceInvoiceNull() throws Exception {
        cartHotel.setAdults(1);
        cartHotel.setCheckIn(timestamp2);
        cartHotel.setCheckOut(timestamp3);
        cartHotel.setRoom(room);
        InvoicehotelRecord testInvoice = cartHotel.getInvoice();
        assertEquals(room.getId(),testInvoice.getRoomid());
        assertTrue(cartHotel.getAdults() == testInvoice.getAdults());
        assertTrue(cartHotel.getChildren() == testInvoice.getChildren());
        assertTrue(cartHotel.getCheckIn() == testInvoice.getCheckin());
        assertTrue(cartHotel.getCheckOut() == testInvoice.getCheckout());
        assertTrue(cartHotel.getPrice() == testInvoice.getPrice());
    }

    @Ignore("Cannot set invoice")
    @Test
    public void getInvoiceInvoiceNotNull() throws Exception {
        assertEquals(null, cartHotel.getInvoice());
    }

    @Ignore("price is stored as Double returned as double")
    @Test
    public void getPrice() throws Exception{

    }

    @Test
    public void updatePrice() throws Exception {
        cartHotel.updatePrice();
        assertTrue(0.0 == cartHotel.getPrice());
        cartHotel.setCheckIn(timestamp2);
        cartHotel.updatePrice();
        assertTrue(0.0 == cartHotel.getPrice());
        cartHotel.setCheckOut(timestamp3);
        cartHotel.updatePrice();
        assertEquals(true,true);
        double testPrice = cartHotel.getPrice();
        double expectedPrice = 1650;
        System.out.print(testPrice);
        assertTrue(expectedPrice == testPrice);
    }

    @Test
    public void updatePriceOutBeforeIn() throws Exception {
        cartHotel.setCheckIn(timestamp3);
        cartHotel.setCheckOut(timestamp2);
        assertTrue(-1350.0 == cartHotel.getPrice());
    }

    @Test
    public void updatePriceOutEqualIn() throws Exception {
        cartHotel.setCheckIn(timestamp2);
        cartHotel.setCheckOut(timestamp2);
        assertTrue(150.0 == cartHotel.getPrice());
    }

    @Test
    public void getHotel() throws Exception {
        cartHotel.setHotel(hotel);
        assertEquals(hotel,cartHotel.getHotel());
    }

    @Test
    public void setHotel() throws Exception {
        cartHotel.setHotel(hotel);
        assertEquals(hotel,cartHotel.getHotel());
    }

    @Test
    public void getRoom() throws Exception {
        assertEquals(null,cartHotel.getRoom());
        cartHotel.setRoom(room);
        assertEquals(room,cartHotel.getRoom());
    }

    @Test
    public void setRoom() throws Exception {
        cartHotel.setRoom(room);
        assertEquals(room,cartHotel.getRoom());
    }

    @Test
    public void getAdults() throws Exception {
        assertEquals(0,cartHotel.getAdults());
        cartHotel.setAdults(5);
        assertEquals(5,cartHotel.getAdults());
    }

    @Test
    public void setAdults() throws Exception {
        cartHotel.setAdults(5);
        assertEquals(5,cartHotel.getAdults());
    }

    @Test
    public void getChildren() throws Exception {
        assertEquals(0,cartHotel.getChildren());
        cartHotel.setChildren(8);
        assertEquals(8,cartHotel.getChildren());
    }

    @Test
    public void setChildren() throws Exception {
        cartHotel.setChildren(8);
        assertEquals(8,cartHotel.getChildren());
    }

    @Test
    public void getCheckIn() throws Exception {
        assertEquals(null,cartHotel.getCheckIn());
        cartHotel.setCheckIn(timestamp2);
        assertEquals(timestamp2,cartHotel.getCheckIn());
    }

    @Test
    public void setCheckIn() throws Exception {
        cartHotel.setCheckIn(timestamp2);
        assertEquals(timestamp2,cartHotel.getCheckIn());
    }

    @Test
    public void getCheckOut() throws Exception {
        assertEquals(null,cartHotel.getCheckOut());
        cartHotel.setCheckOut(timestamp3);
        assertEquals(timestamp3,cartHotel.getCheckOut());
    }

    @Test
    public void setCheckOut() throws Exception {
        cartHotel.setCheckOut(timestamp3);
        assertEquals(timestamp3,cartHotel.getCheckOut());
    }

}