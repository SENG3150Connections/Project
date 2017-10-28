package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartExperience;
import NewcastleConnections.Recommendations;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Harry on 16/10/2017.
 */
public class UpdateCartExperienceTest extends StrutsJUnit4TestCase<UpdateCartExperience> {

    UpdateCartExperience updateCartExperience = new UpdateCartExperience();
    Cart cart = new Cart();
    CartExperience cartExperience = new CartExperience(1);

    @Override
    protected String getConfigPath() { return "struts-test.xml"; }


    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/update-experience.action");
        UpdateCartExperience action = (UpdateCartExperience) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }


    @Test
    public void testAllParams() throws Exception {
        updateCartExperience.setCart(cart);
        updateCartExperience.setExperience(cartExperience);

        request.setParameter("edit", "edit");
        request.setParameter("cartIndex", "1");
        request.setParameter("voucherId", "1");

        ActionProxy proxy = getActionProxy("/update-experience.action");
        UpdateCartExperience action = (UpdateCartExperience) proxy.getAction();
        String result = proxy.execute();

        action.setCart(cart);
        action.setExperience(cartExperience);

        assertEquals("Test Edit", "edit", action.getEdit());
        assertEquals("Test CartIndex", 1, action.getCartIndex());
        assertEquals("Test VoucherId", (Integer)1, action.getVoucherId());
        assertEquals("Test Cart", cart, action.getCart());
        assertEquals("Test cartHotel", cartExperience, action.getExperience());
    }

    @Test
    public void getRecommendations() throws Exception {
        cart.addExperience(cartExperience);
        updateCartExperience.setCart(cart);
        updateCartExperience.setEdit("TestEdit");
        updateCartExperience.execute();
        Recommendations testRecommendations = new Recommendations(cartExperience.getExperience(),2);
        //ExperiencesRecord testRecord = (ExperiencesRecord) testRecommendations.getExperiences().getFirst();
        //assertEquals(testRecord, updateCartRestaurant.getRecommendations().getExperiences().getFirst());
    }
}
