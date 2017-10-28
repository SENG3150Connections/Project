package NewcastleConnections.Invoices.Actions;

import NewcastleConnections.Invoices.HotelInvoiceInfo;
import NewcastleConnections.Invoices.InvoiceInfo;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by seb on 28/10/17.
 */
public class GetUserBookingTest extends StrutsJUnit4TestCase<GetUserBooking> {


    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }


    @Test(expected = Exception.class)
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

    }

    @Test
    public void testExampleBooking() throws Exception {
        request.setParameter("invoiceID", "124");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));
        assertTrue("Should return a invoice object", action.getInvoice() != null);
    }

    @Test
    public void getInvoice() throws Exception {

        request.setParameter("invoiceID", "124");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Should not return null", action.getInvoice() != null);
    }

    @Test
    public void getHotels() throws Exception {

        request.setParameter("invoiceID", "124");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Should not return null", action.getHotels() != null);

    }
    @Test
    public void getExperiences() throws Exception {

        request.setParameter("invoiceID", "124");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Should not return null", action.getExperiences() != null);
    }

    @Test
    public void getRestaurants() throws Exception {

        request.setParameter("invoiceID", "124");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Should not return null", action.getRestaurants() != null);
    }

    @Test
    public void getTransports() throws Exception {

        request.setParameter("invoiceID", "124");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Should not return null", action.getTransports() != null);
    }

}
