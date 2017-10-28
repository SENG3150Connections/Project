package NewcastleConnections.Invoices.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by seb on 28/10/17.
 */
public class GetUserInvoicesTest extends StrutsJUnit4TestCase<GetUserInvoices> {



    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/customerPortal-AuthDisabled.action");
        GetUserInvoices action = (GetUserInvoices) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertTrue("Invoice list should be empty", action.getInvoices().isEmpty());
    }

    @Test
    public void getInvoices() {

    }
}
