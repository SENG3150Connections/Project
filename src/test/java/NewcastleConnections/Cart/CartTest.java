package NewcastleConnections.Cart;

import NewcastleConnections.packagedeals.tables.records.*;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Created by Jack on 22/10/2017.
 */
public class CartTest extends StrutsJUnit4TestCase<Cart> {

    Cart cart = new Cart();
    private java.sql.Date date =  new java.sql.Date(2017,1,1);
    private Byte b = 0;
    private java.sql.Timestamp timestamp = new Timestamp(1,1,1,1,1,1,1);
    private InvoicesRecord invoice = new InvoicesRecord(UInteger.valueOf(3),"TestCustomerID",timestamp,1.0,UInteger.valueOf(4));

    private CartExperience cartExperience = new CartExperience(007);
    private ExperiencesRecord experience = new ExperiencesRecord(UInteger.valueOf(1),"TestName","TestOverview","TestDescription","TestLocation","TestInfo","TestGuidlines",UInteger.valueOf(2),100.0,-100.0,"TestImageID",1.0,"TestCategory",b,b,date);

    private CartHotel cartHotel = new CartHotel(007);
    private HotelsRecord hotel = new HotelsRecord(UInteger.valueOf(1),"TestName","TestContact","TestEmail","TestAddress","TestWebsite","TestDescription",100.0,-100.0,b,b,date,"TestImageID","TestCategory");

    private RoomofferingsRecord room = new RoomofferingsRecord(UInteger.valueOf(2),UInteger.valueOf(3),UInteger.valueOf(4),UInteger.valueOf(10),"TestRoomDescription",UInteger.valueOf(5),UInteger.valueOf(6),"TestRoomTitle");

    private CartRestaurant cartRestaurant = new CartRestaurant(001);
    private Byte b2 = 1;
    private Byte b3 = 2;
    private Byte b4 = 3;
    private ResturantsRecord restaurant = new ResturantsRecord(UInteger.valueOf(1), "TestName","TestAddress","TestContact","TestEmail","TestWebsite","TestDescription",b,b2,100.0,50.0,"TestImageID","TestCategory",b3,b4,date);

    private CartTransport cartTransport = new CartTransport(001);
    private TransportRecord transport = new TransportRecord(UInteger.valueOf(1), "TestName",10.0,b,"TestDescription",100.0,50.0,25.0,10.0);

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void createInvoice() throws Exception {
    }

    @Test
    public void storeSubInvoices() throws Exception {

    }

    @Test
    public void getReadyToPay() throws Exception {
    }

    @Test
    public void getCurrentPrice() throws Exception {
    }

    @Test
    public void removeExperience() throws Exception {
    }

    @Test
    public void removeHotel() throws Exception {
    }

    @Test
    public void removeRestaurant() throws Exception {
    }

    @Test
    public void removeTransport() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void getSize() throws Exception {
    }

    @Test
    public void addExperience() throws Exception {
    }

    @Test
    public void addRoom() throws Exception {
    }

    @Test
    public void addRestaurant() throws Exception {
    }

    @Test
    public void addTransport() throws Exception {
    }

    @Test
    public void removeExperience1() throws Exception {
    }

    @Test
    public void removeHotel1() throws Exception {
    }

    @Test
    public void removeRestaurant1() throws Exception {
    }

    @Test
    public void removeTransport1() throws Exception {
    }

    @Test
    public void getExperiences() throws Exception {
    }

    @Test
    public void getHotels() throws Exception {
    }

    @Test
    public void getRestaurants() throws Exception {
    }

    @Test
    public void getTransport() throws Exception {
    }

    @Test
    public void getLastExperience() throws Exception {
    }

    @Test
    public void getLastHotel() throws Exception {
    }

    @Test
    public void getLastRestaurant() throws Exception {
    }

    @Test
    public void getLastTransport() throws Exception {
    }

    @Test
    public void getPrice() throws Exception {
    }

    @Test
    public void getSavings() throws Exception {
    }

}