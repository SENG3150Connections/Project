package NewcastleConnections.Management.Actions;

import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.util.derby.sys.Sys;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by Scott on 18/10/2017.
 */
public class SubmitOfferTest extends StrutsJUnit4TestCase<SubmitOffer> {

    private String name = "Test offer";
    private String contact = "Test contact";
    private String email = "Test email";
    private String address = "Test address";
    private String website = "Test website";
    private String description = "Test description";
    private Double latitude = 13.37;
    private Double longitude = 4.20;
    private Byte publicallyvisible = (byte) 1;
    private Byte releaseondate = (byte) 1;
    private String releasedate = "01-01-2017";
    private String imageid = "Test image";
    private String category = "Test category";

    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testNoParams() throws Exception {
        ActionProxy proxy = getActionProxy("/submitOffer.action");
        SubmitOffer action = (SubmitOffer) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return INPUT", result.equals(ActionSupport.INPUT));

        HotelsRecord h = action.getHotel();
        assertNull("Hotel record is null", h);
    }

    @Test
    public void testInvalidParams() throws Exception {
        request.setParameter("name", name);
        request.setParameter("contact", contact);
        request.setParameter("email", email);
        request.setParameter("address", address);
        request.setParameter("website", website);
        request.setParameter("description", description);
        request.setParameter("latitude", "Invalid param");
        request.setParameter("longitude", "This is not a double");
        request.setParameter("releasedate", releasedate);
        ActionProxy proxy = getActionProxy("/submitOffer.action");
        SubmitOffer action = (SubmitOffer) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return INPUT", result.equals(ActionSupport.INPUT));

        HotelsRecord h = action.getHotel();
        assertNull("Hotel record is null", h);
    }

    @Test
    public void testAllParams() throws Exception {
        request.setParameter("name", name);
        request.setParameter("contact", contact);
        request.setParameter("email", email);
        request.setParameter("address", address);
        request.setParameter("website", website);
        request.setParameter("description", description);
        request.setParameter("latitude", latitude.toString());
        request.setParameter("longitude", longitude.toString());
        request.setParameter("publicallyvisible", publicallyvisible.toString());
        request.setParameter("releaseondate", releaseondate.toString());
        request.setParameter("imageid", imageid);
        request.setParameter("category", category);

        ActionProxy proxy = getActionProxy("/submitOffer.action");
        SubmitOffer action = (SubmitOffer) proxy.getAction();
        String result = proxy.execute();

        assertTrue("Action should return SUCCESS", result.equals(ActionSupport.SUCCESS));

        HotelsRecord h = action.getHotel();
        assertNotNull("Hotel record is not null", h);

        assertEquals("names match", name, h.getName());
        assertEquals("contacts match", contact, h.getContact());
        assertEquals("emails match", email, h.getEmail());
        assertEquals("addresss match", address, h.getAddress());
        assertEquals("websites match", website, h.getWebsite());
        assertEquals("descriptions match", description, h.getDescription());
        assertEquals("latitudes match", latitude, h.getLatitude());
        assertEquals("longitudes match", longitude, h.getLongitude());
        assertEquals("publicallyvisibles match", publicallyvisible, h.getPublicallyvisible());
        assertEquals("releaseondates match", releaseondate, h.getReleaseondate());
        assertEquals("imageids match", imageid, h.getImageid());
        assertEquals("categorys match", category, h.getCategory());
    }

}