package NewcastleConnections.Management.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 10/10/2017.
 */
public class CreateOfferTest extends StrutsJUnit4TestCase<CreateOffer> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/createOffer.action");
        CreateOffer action = (CreateOffer) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertTrue("OfferType should be empty", action.getOfferType().isEmpty());
    }

    @Test
    public void testOfferType() throws Exception {
        request.setParameter("offerType", "hotel");
        ActionProxy proxy = getActionProxy("/createOffer.action");
        CreateOffer action = (CreateOffer) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertTrue("OfferType should be 'hotel'", action.getOfferType().equals("hotel"));
    }

}