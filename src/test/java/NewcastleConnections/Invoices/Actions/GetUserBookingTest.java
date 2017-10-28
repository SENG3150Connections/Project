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

    @Test
    public void testNoParams() throws Exception {
       // request.setParameter("invoiceID", "1");
        ActionProxy proxy = getActionProxy("/customerPortal-bookings-AuthDisabled.action");
        GetUserBooking action = (GetUserBooking) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return ERROR", result.equals(ActionSupport.ERROR));
       // assertTrue("Invoice list should be empty", action.getInvoices().isEmpty());
    }

    @Test
    public void getInvoice() {

    }

    @Test
    public void getHotels() {

    }
    @Test
    public void getExperiences() {

    }

    @Test
    public void getRestaurants() {

    }

    @Test
    public void getTransports() {

    }

}
