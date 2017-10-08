package NewcastleConnections.Authentication;

import NewcastleConnections.Management.Actions.CreateOffer;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

public class ManagementInterceptorTest extends StrutsJUnit4TestCase<CreateOffer> {
    @Test
    public void testLoggedIn() throws Exception {
        // Set user loggedin
        HttpSession session = request.getSession(true);
        session.setAttribute("accessToken", "abc");
        session.setAttribute("idToken", "123");
        session.setAttribute("userPermissions", "1");

        ActionProxy proxy = getActionProxy("/createOffer.action");
        CreateOffer action = (CreateOffer) proxy.getAction();

        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
    }

    @Test
    public void testNotLoggedInAdmin() throws Exception {
        // Set user loggedin
        HttpSession session = request.getSession(true);
        session.setAttribute("accessToken", "abc");
        session.setAttribute("idToken", "123");
        session.setAttribute("userPermissions", "0");

        ActionProxy proxy = getActionProxy("/createOffer.action");
        CreateOffer action = (CreateOffer) proxy.getAction();

        String result = proxy.execute();

        assertTrue("Action should return DENIED", result.equals(ManagementInterceptor.DENIED));
    }

    @Test
    public void testNotLoggedIn() throws Exception {
        // Set user loggedin
        HttpSession session = request.getSession(true);

        ActionProxy proxy = getActionProxy("/createOffer.action");
        CreateOffer action = (CreateOffer) proxy.getAction();

        String result = proxy.execute();

        assertTrue("Action should return LOGIN", result.equals(ManagementInterceptor.LOGIN));
    }

}