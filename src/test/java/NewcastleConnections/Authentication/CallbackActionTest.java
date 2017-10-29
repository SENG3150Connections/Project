package NewcastleConnections.Authentication;

import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 20/10/2017.
 */
public class CallbackActionTest extends StrutsJUnit4TestCase<CallbackAction> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/callback.action");
        CallbackAction action = (CallbackAction) proxy.getAction();
        String result = proxy.execute();

        assertEquals("Result must be LOGIN", result, CallbackAction.LOGIN);
    }

}