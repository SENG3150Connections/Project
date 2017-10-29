package NewcastleConnections.Authentication;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

/**
 * Created by Scott on 10/10/2017.
 */
public class AuthenticationInterceptorTest extends StrutsJUnit4TestCase<AuthenticationInterceptor> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testLoggedIn() throws Exception {
        // Set user loggedin
        HttpSession session = request.getSession(true);
        session.setAttribute("accessToken", "abc");
        session.setAttribute("idToken", "123");
        session.setAttribute("userPermissions", "0");

        ActionProxy proxy = getActionProxy("/authenticationTest.action");
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
    }

    @Test
    public void testNotLoggedIn() throws Exception {
        ActionProxy proxy = getActionProxy("/authenticationTest.action");
        String result = proxy.execute();
        assertTrue("Action should return LOGIN", result.equals(AuthenticationInterceptor.LOGIN));
    }

}