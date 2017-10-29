package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewCartTest extends StrutsJUnit4TestCase<ViewCart> {

    ViewCart viewCart = new ViewCart();
    Cart cart = new Cart();

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void execute() throws Exception {
        assertEquals(ActionSupport.SUCCESS,viewCart.execute());
    }

    @Test
    public void getCart() throws Exception {
        viewCart.setCart(cart);
        assertEquals(cart,viewCart.getCart());
    }

    @Test
    public void setCart() throws Exception {
        viewCart.setCart(cart);
        assertEquals(cart,viewCart.getCart());
    }
    
}
