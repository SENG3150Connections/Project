package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.*;
import NewcastleConnections.Recommendations;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateCartTransportTest extends StrutsJUnit4TestCase<UpdateCartTransport> {

    UpdateCartTransport updateCartTransport = new UpdateCartTransport();
    Cart cart = new Cart();
    CartTransport cartTransport = new CartTransport(1);
    CartHotel cartHotel = new CartHotel(1);
    CartExperience cartExperience = new CartExperience(1);
    CartRestaurant cartRestaurant = new CartRestaurant(1);

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void execute() throws Exception {
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setTickets(1);
        updateCartTransport.setTime("2017-01-01 18:48:05.123456");
        assertEquals("done",updateCartTransport.execute());
    }

    @Test
    public void executeIllegalArgument() throws Exception {
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setTickets(1);
        updateCartTransport.setTime("TestTime");
        assertEquals(ActionSupport.ERROR,updateCartTransport.execute());
    }

    @Test
    public void executeTicketsNegative() throws Exception {
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setTickets(-1);
        assertEquals(ActionSupport.ERROR,updateCartTransport.execute());

    }

    @Test
    public void executeEditNotNull() throws Exception {
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartTransport.execute());
        assertTrue(updateCartTransport.getRecommendations().getHotels().isEmpty());
        assertTrue(updateCartTransport.getRecommendations().getExperiences().isEmpty());
        assertTrue(updateCartTransport.getRecommendations().getRestaurants().isEmpty());

    }

    @Test
    public void executeRecommendationHotel() throws Exception {
        cart.addRoom(cartHotel);
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartTransport.execute());

    }

    @Test
    public void executeRecommendationExperience() throws Exception {
        cart.addExperience(cartExperience);
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartTransport.execute());

    }

    @Test
    public void executeRecommendationRestaurant() throws Exception {
        cart.addRestaurant(cartRestaurant);
        cart.addTransport(cartTransport);
        updateCartTransport.setCart(cart);
        updateCartTransport.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartTransport.execute());

    }

    @Test
    public void executeError() throws Exception {
        updateCartTransport.setCartIndex(-1);
        assertEquals(ActionSupport.ERROR,updateCartTransport.execute());
    }

    @Test
    public void getEdit() throws Exception {
        updateCartTransport.setEdit("TestEdit");
        assertEquals("TestEdit",updateCartTransport.getEdit());
    }

    @Test
    public void setEdit() throws Exception {
        updateCartTransport.setEdit("TestEdit");
        assertEquals("TestEdit",updateCartTransport.getEdit());
    }

    @Test
    public void getCart() throws Exception {
        updateCartTransport.setCart(cart);
        assertEquals(cart,updateCartTransport.getCart());
    }

    @Test
    public void setCart() throws Exception {
        updateCartTransport.setCart(cart);
        assertEquals(cart,updateCartTransport.getCart());
    }

    @Test
    public void getCartIndex() throws Exception {
        updateCartTransport.setCartIndex(1);
        assertEquals(1,updateCartTransport.getCartIndex());
    }

    @Test
    public void setCartIndex() throws Exception {
        updateCartTransport.setCartIndex(1);
        assertEquals(1,updateCartTransport.getCartIndex());
    }

    @Test
    public void getTransport() throws Exception {
        updateCartTransport.setTransport(cartTransport);
        assertEquals(cartTransport,updateCartTransport.getTransport());
    }

    @Test
    public void setTransport() throws Exception {
        updateCartTransport.setTransport(cartTransport);
        assertEquals(cartTransport,updateCartTransport.getTransport());
    }

    @Test
    public void getTickets() throws Exception {
        Integer testInt = 1;
        updateCartTransport.setTickets(testInt);
        assertEquals(testInt,updateCartTransport.getTickets());
    }

    @Test
    public void setTickets() throws Exception {
        Integer testInt = 1;
        updateCartTransport.setTickets(testInt);
        assertEquals(testInt,updateCartTransport.getTickets());
    }

    @Test
    public void getTime() throws Exception {
        updateCartTransport.setTime("11:00am");
        assertEquals("11:00am",updateCartTransport.getTime());
    }

    @Test
    public void setTime() throws Exception {
        updateCartTransport.setTime("11:00am");
        assertEquals("11:00am",updateCartTransport.getTime());
    }

    @Test
    public void getRecommendations() throws Exception {
        cart.addTransport(cartTransport);
        cart.addExperience(cartExperience);
        updateCartTransport.setCart(cart);
        updateCartTransport.setEdit("TestEdit");
        updateCartTransport.execute();
        Recommendations testRecommendations = new Recommendations(cartExperience.getExperience(),2);
        ExperiencesRecord testRecord = (ExperiencesRecord) testRecommendations.getExperiences().getFirst();
        assertEquals(testRecord, updateCartTransport.getRecommendations().getExperiences().getFirst());
    }
    
}
