package NewcastleConnections.Management.Actions;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Scott on 18/10/2017.
 */
public class GetOfferByIDTest extends StrutsJUnit4TestCase<GetOfferByID> {

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/editOffer.action");
        GetOfferByID action = (GetOfferByID) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
        assertTrue("ID should be empty", action.getId() == null || action.getId().isEmpty());
        assertNull("Result should be empty", action.getHotel());
    }

    @Test
    public void testIdNoMatch() throws Exception {
        request.setParameter("id", "-1");
        ActionProxy proxy = getActionProxy("/editOffer.action");
        GetOfferByID action = (GetOfferByID) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
        assertEquals("ID should be -1", action.getId(), "-1");
        assertNull("Result should be empty", action.getHotel());
    }

    @Test
    public void testIdMatch() throws Exception {
        request.setParameter("id", "1");
        ActionProxy proxy = getActionProxy("/editOffer.action");
        GetOfferByID action = (GetOfferByID) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertEquals("ID should be 1", action.getId(), "1");
        assertNotNull("Result should not be empty", action.getHotel());

        // Assert hotel properties
        assertEquals("ID should match", action.getHotel().getId().intValue(), 1);
        assertEquals("Name should match", action.getHotel().getName(), "Novotel Newcastle Beach");
        assertEquals("Contact should match", action.getHotel().getContact(), "(02) 4032 3700");
        assertEquals("Email should match", action.getHotel().getEmail(), "H8771@accor.com");
    }

}