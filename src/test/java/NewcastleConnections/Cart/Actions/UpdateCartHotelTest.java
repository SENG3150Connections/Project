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
    }

    @Test
    public void getEdit() throws Exception {
    }

    @Test
    public void setEdit() throws Exception {
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
    public void getCartIndex() throws Exception {
    }

    @Test
    public void setCartIndex() throws Exception {
    }

    @Test
    public void getHotel() throws Exception {
    }

    @Test
    public void setHotel() throws Exception {
    }

    @Test
    public void getRoomId() throws Exception {
    }

    @Test
    public void setRoomId() throws Exception {
    }

    @Test
    public void getAdults() throws Exception {
    }

    @Test
    public void setAdults() throws Exception {
    }

    @Test
    public void getChildren() throws Exception {
    }

    @Test
    public void setChildren() throws Exception {
    }

    @Test
    public void getCheckIn() throws Exception {
    }

    @Test
    public void setCheckIn() throws Exception {
    }

    @Test
    public void getCheckOut() throws Exception {
    }

    @Test
    public void setCheckOut() throws Exception {
    }

    @Test
    public void getRecommendations() throws Exception {
    }
}
