package NewcastleConnections.Cart;

import NewcastleConnections.packagedeals.tables.records.*;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    private CartExperience cartExperience = new CartExperience(001);
    private ExperiencesRecord experience = new ExperiencesRecord(UInteger.valueOf(1),"TestName","TestOverview","TestDescription","TestLocation","TestInfo","TestGuidlines",UInteger.valueOf(2),100.0,-100.0,"TestImageID",1.0,"TestCategory",b,b,date);
    private ExperiencevoucherofferingsRecord voucher = new ExperiencevoucherofferingsRecord(UInteger.valueOf(5),UInteger.valueOf(6),20.0,UInteger.valueOf(1),timestamp,timestamp);


    private CartHotel cartHotel = new CartHotel(001);
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
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", "TestUserID");

        ActionProxy proxy = getActionProxy("/payment.action");
        String result = proxy.execute();

        cart.createInvoice();
    }

    @Ignore("Method is private and invoices cannot be set")
    @Test
    public void storeSubInvoices() throws Exception {
    }


    @Test
    public void getReadyToPayEmptyCart() throws Exception {
        assertFalse(cart.getReadyToPay());
    }

    @Test
    public void getReadyToPay() throws Exception {
        cart.addExperience(cartExperience);
        assertFalse(cart.getReadyToPay());
        cartExperience.setVoucher(voucher);
        assertTrue(cart.getReadyToPay());
    }

    @Test
    public void getCurrentPrice() throws Exception {
        assertTrue(0.0 == cart.getCurrentPrice());
        cart.addExperience(cartExperience);
        cartExperience.setVoucher(voucher);
        assertTrue(20.0 == cart.getCurrentPrice());
    }

    @Test
    public void removeExperience() throws Exception {
        cart.addExperience(cartExperience);
        assertFalse(cart.getExperiences().isEmpty());
        cart.removeExperience(cartExperience);
        assertTrue(cart.getExperiences().isEmpty());
    }

    @Test
    public void removeHotel() throws Exception {
        cart.addRoom(cartHotel);
        assertFalse(cart.getHotels().isEmpty());
        cart.removeHotel(cartHotel);
        assertTrue(cart.getHotels().isEmpty());
    }

    @Test
    public void removeRestaurant() throws Exception {
        cart.addRestaurant(cartRestaurant);
        assertFalse(cart.getRestaurants().isEmpty());
        cart.removeRestaurant(cartRestaurant);
        assertTrue(cart.getRestaurants().isEmpty());
    }

    @Test
    public void removeTransport() throws Exception {
        cart.addTransport(cartTransport);
        assertFalse(cart.getTransport().isEmpty());
        cart.removeTransport(001);
        assertTrue(cart.getTransport().isEmpty());
    }

    @Test
    public void removeExperienceById() throws Exception {
        cart.addExperience(cartExperience);
        assertFalse(cart.getExperiences().isEmpty());
        cart.removeExperience(001);
        assertTrue(cart.getExperiences().isEmpty());
    }

    @Test
    public void removeHotelById() throws Exception {
        cart.addRoom(cartHotel);
        assertFalse(cart.getHotels().isEmpty());
        cart.removeHotel(001);
        assertTrue(cart.getHotels().isEmpty());
    }

    @Test
    public void removeRestaurantById() throws Exception {
        cart.addRestaurant(cartRestaurant);
        assertFalse(cart.getRestaurants().isEmpty());
        cart.removeRestaurant(001);
        assertTrue(cart.getRestaurants().isEmpty());
    }

    @Test
    public void removeTransportById() throws Exception {
        cart.addTransport(cartTransport);
        assertFalse(cart.getTransport().isEmpty());
        cart.removeTransport(cartTransport);
        assertTrue(cart.getTransport().isEmpty());
    }


    @Test
    public void removeExperienceNotInCart() throws Exception {
        List<CartExperience> testList = cart.getExperiences();
        cart.removeExperience(001);
        assertEquals(testList,cart.getExperiences());
        cart.removeExperience(cartExperience);
        assertEquals(testList,cart.getExperiences());
    }

    @Test
    public void removeHotelNotInCart() throws Exception {
        List<CartHotel> testList = cart.getHotels();
        cart.removeHotel(001);
        assertEquals(testList,cart.getRestaurants());
        cart.removeHotel(cartHotel);
        assertEquals(testList,cart.getHotels());
    }

    @Test
    public void removeRestaurantNotInCart() throws Exception {
        List<CartRestaurant> testList = cart.getRestaurants();
        cart.removeRestaurant(001);
        assertEquals(testList,cart.getRestaurants());
        cart.removeRestaurant(cartRestaurant);
        assertEquals(testList,cart.getRestaurants());
    }

    @Test
    public void removeTransportNotInCart() throws Exception {
        List<CartTransport> testList = cart.getTransport();
        cart.removeTransport(001);
        assertEquals(testList,cart.getTransport());
        cart.removeTransport(cartTransport);
        assertEquals(testList,cart.getTransport());
    }

    @Test
    public void getAll() throws Exception {
        cart.addExperience(cartExperience);
        cart.addRoom(cartHotel);
        cart.addRestaurant(cartRestaurant);
        cart.addTransport(cartTransport);
        List<CartItem> testList = cart.getAll();
        assertTrue(testList.contains(cartExperience));
        assertTrue(testList.contains(cartHotel));
        assertTrue(testList.contains(cartRestaurant));
        assertTrue(testList.contains(cartTransport));
    }

    @Test
    public void getSize() throws Exception {
        cart.addExperience(cartExperience);
        cart.addRoom(cartHotel);
        cart.addRestaurant(cartRestaurant);
        cart.addTransport(cartTransport);
        assertEquals(4, cart.getSize());
    }

    @Test
    public void addExperience() throws Exception {
        assertTrue(cart.getExperiences().isEmpty());
        cart.addExperience(cartExperience);
        List<CartItem> testList = cart.getAll();
        assertTrue(testList.contains(cartExperience));
    }

    @Test
    public void addRoom() throws Exception {
        assertTrue(cart.getHotels().isEmpty());
        cart.addRoom(cartHotel);
        List<CartItem> testList = cart.getAll();
        assertTrue(testList.contains(cartHotel));
    }

    @Test
    public void addRestaurant() throws Exception {
        assertTrue(cart.getRestaurants().isEmpty());
        cart.addRestaurant(cartRestaurant);
        List<CartItem> testList = cart.getAll();
        assertTrue(testList.contains(cartRestaurant));
    }

    @Test
    public void addTransport() throws Exception {
        assertTrue(cart.getTransport().isEmpty());
        cart.addTransport(cartTransport);
        List<CartItem> testList = cart.getAll();
        assertTrue(testList.contains(cartTransport));
    }

    @Test
    public void getExperiences() throws Exception {
        List<CartItem> testList = new ArrayList<>();
        testList.add(cartExperience);
        cart.addExperience(cartExperience);
        assertEquals(testList,cart.getExperiences());
    }

    @Test
    public void getHotels() throws Exception {
        List<CartItem> testList = new ArrayList<>();
        testList.add(cartHotel);
        cart.addRoom(cartHotel);
        assertEquals(testList,cart.getHotels());
    }

    @Test
    public void getRestaurants() throws Exception {
        List<CartItem> testList = new ArrayList<>();
        testList.add(cartRestaurant);
        cart.addRestaurant(cartRestaurant);
        assertEquals(testList,cart.getRestaurants());
    }

    @Test
    public void getTransport() throws Exception {
        List<CartItem> testList = new ArrayList<>();
        testList.add(cartTransport);
        cart.addTransport(cartTransport);
        assertEquals(testList,cart.getTransport());
    }

    @Test
    public void getLastExperience() throws Exception {
        cart.addExperience(cartExperience);
        assertEquals(cartExperience,cart.getLastExperience());
    }

    @Test
    public void getLastHotel() throws Exception {
        cart.addRoom(cartHotel);
        assertEquals(cartHotel,cart.getLastHotel());
    }

    @Test
    public void getLastRestaurant() throws Exception {
        cart.addRestaurant(cartRestaurant);
        assertEquals(cartRestaurant,cart.getLastRestaurant());
    }

    @Test
    public void getLastTransport() throws Exception {
        cart.addTransport(cartTransport);
        assertEquals(cartTransport,cart.getLastTransport());
    }

    @Test
    public void getPrice() throws Exception {
        assertTrue(0.0 == cart.getCurrentPrice());
        cart.addExperience(cartExperience);
        cartExperience.setVoucher(voucher);
        assertTrue(20.0 == cart.getCurrentPrice());
        assertTrue(20.0 == cart.getPrice());
    }

    @Test
    public void getSavings() throws Exception {
        assertTrue(0.0 == cart.getCurrentPrice());
        cart.addExperience(cartExperience);
        cartExperience.setVoucher(voucher);
        assertTrue(20.0 == cart.getCurrentPrice());
        assertTrue(5.0 == cart.getSavings());
    }

}