package NewcastleConnections.Management.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 18/10/2017.
 */
public class GetOffersTest extends StrutsJUnit4TestCase<GetOffers> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/displayProducts.action");
        GetOffers action = (GetOffers) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));

        assertNotNull("Hotels should not be null", action.getHotels());
        assertFalse("Hotels should not be empty", action.getHotels().isEmpty());

        assertNotNull("Restaurants should not be null", action.getRestaurants());
        assertFalse("Restaurants should not be empty", action.getRestaurants().isEmpty());

        assertNotNull("Experiences should not be null", action.getExperiences());
        assertFalse("Experiences should not be empty", action.getExperiences().isEmpty());
    }

}