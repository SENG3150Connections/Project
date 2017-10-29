package NewcastleConnections.Management.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 18/10/2017.
 */
public class GetInvoicesTest extends StrutsJUnit4TestCase<GetInvoices> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/invoice.action");
        GetInvoices action = (GetInvoices) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertNotNull("Invoices should not be null", action.getInvoices());
        assertFalse("Invoices should not be empty", action.getInvoices().isEmpty());
    }

}