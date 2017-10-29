package NewcastleConnections.Actions;

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

public class CompleteTest extends StrutsJUnit4TestCase<Complete> {

    Complete complete = new Complete();
    Cart cart = new Cart();

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void execute() throws Exception {
        complete.setCart(cart);
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", "TestUserID");

        ActionProxy proxy = getActionProxy("/complete.action");
        String result = proxy.execute();

        complete.execute();
    }

    @Test
    public void getCart() throws Exception {
        complete.setCart(cart);
        assertEquals(cart,complete.getCart());
    }

    @Test
    public void setCart() throws Exception {
        complete.setCart(cart);
        assertEquals(cart,complete.getCart());
    }

    @Test
    public void getId() throws Exception {
        complete.setId(1);
        assertEquals(1,complete.getId());
    }

    @Test
    public void setID() throws Exception {
        complete.setId(1);
        assertEquals(1,complete.getId());
    }
}