package NewcastleConnections.Cart.Actions;

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Harry on 16/10/2017.
 */
public class UpdateCartTransportTest extends StrutsJUnit4TestCase<UpdateCartTransport> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }
    
    // -----------------------
    // ----- ERROR TESTS -----
    // -----------------------

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/update-transport.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }
    
}
