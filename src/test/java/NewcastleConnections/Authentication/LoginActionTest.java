package NewcastleConnections.Authentication;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 21/10/2017.
 */
public class LoginActionTest extends StrutsJUnit4TestCase<LoginAction> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/login.action");
        LoginAction action = (LoginAction) proxy.getAction();
        String result = proxy.execute();

        assertEquals("Result is SUCCESS", result, ActionSupport.SUCCESS);

        String[] urlParts = response.getRedirectedUrl().split("\\?");
        assertEquals("Redirect domain is auth0", urlParts[0], "https://team1.au.auth0.com/authorize");
    }

}