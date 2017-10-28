package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.*;
import NewcastleConnections.packagedeals.tables.records.RoomofferingratesRecord;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateCartHotelTest extends StrutsJUnit4TestCase<UpdateCartHotel> {

    UpdateCartHotel updateCartHotel = new UpdateCartHotel();
    Cart cart;
    CartHotel cartHotel = new CartHotel(1);
    CartExperience cartExperience = new CartExperience(1);
    CartRestaurant cartRestaurant = new CartRestaurant(1);

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void executeHotel() throws Exception {
        cart = new Cart();
        cart.addRoom(cartHotel);
        request.setParameter("cartIndex", "0");
        request.setParameter("edit", "true");

        ActionProxy proxy = getActionProxy("/update-hotel.action");
        UpdateCartHotel action = (UpdateCartHotel) proxy.getAction();

        action.setCart(cart);
        action.setHotel(cartHotel);

        String result = proxy.execute();
        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
    }

    @Test
    public void checkParams() throws Exception {
        request.setParameter("edit", "edit");
        request.setParameter("cartIndex", "1");
        request.setParameter("roomId", "1");
        request.setParameter("adults", "1");
        request.setParameter("children", "1");
        request.setParameter("checkIn", "checkIn");
        request.setParameter("checkOut", "checkOut");

        ActionProxy proxy = getActionProxy("/update-hotel.action");
        UpdateCartHotel action = (UpdateCartHotel) proxy.getAction();
        String result = proxy.execute();

        action.setCart(cart);
        action.setHotel(cartHotel);

        assertEquals("Test Edit", "edit", action.getEdit());
        assertEquals("Test CartIndex", 1, action.getCartIndex());
        assertEquals("Test roomId", (Integer) 1, action.getRoomId());
        assertEquals("Test adults", (Integer) 1, action.getAdults());
        assertEquals("Test children", (Integer) 1, action.getChildren());
        assertEquals("Test checkIn", "checkIn", action.getCheckIn());
        assertEquals("Test checkOut", "checkOut", action.getCheckOut());
        assertEquals("Test Cart", cart, action.getCart());
        assertEquals("Test cartHotel", cartHotel, action.getHotel());
    }

    @Test
    public void getOfferings() throws Exception {
    }

    @Test
    public void setOfferings() throws Exception {
    }

    @Test
    public void getCart() throws Exception {
    }

    @Test
    public void setCart() throws Exception {
    }

    @Test
    public void getHotel() throws Exception {
    }

    @Test
    public void setHotel() throws Exception {
    }

    @Test
    public void getRecommendations() throws Exception {
    }
}
