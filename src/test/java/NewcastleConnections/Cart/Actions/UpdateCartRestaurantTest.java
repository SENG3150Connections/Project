package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.*;
import NewcastleConnections.Recommendations;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateCartRestaurantTest extends StrutsJUnit4TestCase<UpdateCartRestaurant> {

    UpdateCartRestaurant updateCartRestaurant = new UpdateCartRestaurant();
    Cart cart = new Cart();
    CartHotel cartHotel = new CartHotel(1);
    CartExperience cartExperience = new CartExperience(1);
    CartRestaurant cartRestaurant = new CartRestaurant(1);

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void execute() throws Exception {
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setSeats(1);
        updateCartRestaurant.setTime("2017-01-01 18:48:05.123456");
        assertEquals("done",updateCartRestaurant.execute());
    }

    @Test
    public void executeIllegalArgument() throws Exception {
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setSeats(1);
        updateCartRestaurant.setTime("TestTime");
        assertEquals(ActionSupport.ERROR,updateCartRestaurant.execute());
    }

    @Test
    public void executeTicketsNegative() throws Exception {
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setSeats(-1);
        assertEquals(ActionSupport.ERROR,updateCartRestaurant.execute());

    }

    @Ignore("Cannot be reached")
    @Test
    public void executeEditNotNull() throws Exception {
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartRestaurant.execute());
        assertTrue(updateCartRestaurant.getRecommendations().getHotels().isEmpty());
        assertTrue(updateCartRestaurant.getRecommendations().getExperiences().isEmpty());
        assertTrue(updateCartRestaurant.getRecommendations().getRestaurants().isEmpty());
    }

    @Test
    public void executeRecommendationHotel() throws Exception {
        cart.addRoom(cartHotel);
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartRestaurant.execute());

    }

    @Test
    public void executeRecommendationExperience() throws Exception {
        cart.addExperience(cartExperience);
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartRestaurant.execute());

    }


    @Test
    public void executeRecommendationRestaurant() throws Exception {
        cart.addRestaurant(cartRestaurant);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setEdit("TestEdit");
        assertEquals(ActionSupport.SUCCESS,updateCartRestaurant.execute());

    }

    @Test
    public void executeError() throws Exception {
        updateCartRestaurant.setCartIndex(-1);
        assertEquals(ActionSupport.ERROR,updateCartRestaurant.execute());
    }

    @Test
    public void getEdit() throws Exception {
        updateCartRestaurant.setEdit("TestEdit");
        assertEquals("TestEdit",updateCartRestaurant.getEdit());
    }

    @Test
    public void setEdit() throws Exception {
        updateCartRestaurant.setEdit("TestEdit");
        assertEquals("TestEdit",updateCartRestaurant.getEdit());
    }

    @Test
    public void getCart() throws Exception {
        updateCartRestaurant.setCart(cart);
        assertEquals(cart,updateCartRestaurant.getCart());
    }

    @Test
    public void setCart() throws Exception {
        updateCartRestaurant.setCart(cart);
        assertEquals(cart,updateCartRestaurant.getCart());
    }

    @Test
    public void getCartIndex() throws Exception {
        updateCartRestaurant.setCartIndex(1);
        assertEquals(1,updateCartRestaurant.getCartIndex());
    }

    @Test
    public void setCartIndex() throws Exception {
        updateCartRestaurant.setCartIndex(1);
        assertEquals(1,updateCartRestaurant.getCartIndex());
    }

    @Test
    public void getRestaurant() throws Exception {
        updateCartRestaurant.setRestaurant(cartRestaurant);
        assertEquals(cartRestaurant,updateCartRestaurant.getRestaurant());
    }

    @Test
    public void setRestaurant() throws Exception {
        updateCartRestaurant.setRestaurant(cartRestaurant);
        assertEquals(cartRestaurant,updateCartRestaurant.getRestaurant());
    }

    @Test
    public void getSeats() throws Exception {
        Integer testInt = 1;
        updateCartRestaurant.setSeats(testInt);
        assertEquals(testInt,updateCartRestaurant.getSeats());
    }

    @Test
    public void setSeats() throws Exception {
        Integer testInt = 1;
        updateCartRestaurant.setSeats(testInt);
        assertEquals(testInt,updateCartRestaurant.getSeats());
    }

    @Test
    public void getTime() throws Exception {
        updateCartRestaurant.setTime("11:00am");
        assertEquals("11:00am",updateCartRestaurant.getTime());
    }

    @Test
    public void setTime() throws Exception {
        updateCartRestaurant.setTime("11:00am");
        assertEquals("11:00am",updateCartRestaurant.getTime());
    }

    @Test
    public void getVoucherPrice() throws Exception {
        Double testDouble = 10.0;
        updateCartRestaurant.setVoucherPrice(testDouble);
        assertTrue(testDouble == updateCartRestaurant.getVoucherPrice());
    }

    @Test
    public void setVoucherPrice() throws Exception {
        Double testDouble = 10.0;
        updateCartRestaurant.setVoucherPrice(testDouble);
        assertTrue(testDouble == updateCartRestaurant.getVoucherPrice());
    }

    @Test
    public void getRecommendations() throws Exception {
        cart.addRestaurant(cartRestaurant);
        cart.addExperience(cartExperience);
        updateCartRestaurant.setCart(cart);
        updateCartRestaurant.setEdit("TestEdit");
        updateCartRestaurant.execute();
        Recommendations testRecommendations = new Recommendations(cartExperience.getExperience(),2);
        ExperiencesRecord testRecord = (ExperiencesRecord) testRecommendations.getExperiences().getFirst();
        assertEquals(testRecord, updateCartRestaurant.getRecommendations().getExperiences().getFirst());
    }
    
}
