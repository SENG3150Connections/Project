package NewcastleConnections.Cart.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Harry on 15/10/2017.
 */
public class UpdateCartTest extends StrutsJUnit4TestCase<UpdateCart> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/updateCart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testMethod() throws Exception {
        request.setParameter("method", "add");
        ActionProxy proxy = getActionProxy("/updateCart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testType() throws Exception {
        request.setParameter("type", "experience");
        ActionProxy proxy = getActionProxy("/updateCart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testId() throws Exception {
        request.setParameter("id", "1");
        ActionProxy proxy = getActionProxy("/updateCart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
    }

    @Test
    public void testAllParams() throws Exception {
        request.setParameter("method", "add");
        request.setParameter("type", "experience");
        request.setParameter("id", "1");
        ActionProxy proxy = getActionProxy("/updateCart.action");
        UpdateCart action = (UpdateCart) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertTrue("Method should be 'add'", action.getMethod().equals("add"));
        assertTrue("Type should be 'experience'", action.getMethod().equals("experience"));
        assertTrue("Id should be '1'", action.getMethod().equals(1));
    }

}