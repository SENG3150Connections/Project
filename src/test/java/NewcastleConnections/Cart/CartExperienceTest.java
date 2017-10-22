package NewcastleConnections.Cart;

import NewcastleConnections.Cart.CartExperience;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.InvoiceexperienceRecord;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jack on 22/10/2017.
 */
public class CartExperienceTest extends StrutsJUnit4TestCase<CartExperience>{
    //Setup test experience
    private CartExperience cartExperience = new CartExperience(007);
    private java.sql.Date date =  new java.sql.Date(2017,1,1);
    private Byte b = 0;
    private ExperiencesRecord experience = new ExperiencesRecord(UInteger.valueOf(1),"TestName","TestOverview","TestDescription","TestLocation","TestInfo","TestGuidlines",UInteger.valueOf(2),100.0,-100.0,"TestImageID",1.0,"TestCategory",b,b,date);

    //Setup test invoice
    private java.sql.Timestamp timestamp;
    private InvoicesRecord invoice = new InvoicesRecord(UInteger.valueOf(3),"TestCustomerID",timestamp,1.0,UInteger.valueOf(4));


    //Setup test voucher
    private ExperiencevoucherofferingsRecord voucher = new ExperiencevoucherofferingsRecord(UInteger.valueOf(5),UInteger.valueOf(6),20.0,UInteger.valueOf(1),timestamp,timestamp);


    @Override
    protected String getConfigPath() {
        return "struts-test.xml";
    }

    @Test
    public void testGetName() throws Exception {
        cartExperience.setExperience(experience);
        assertEquals("TestName", cartExperience.getName());
    }

    @Test
    public void testGetId() throws Exception {
        cartExperience.setExperience(experience);
        assertEquals(1, cartExperience.getId());
    }

    @Test
    public void testGetReadyNull() throws Exception {
        assertEquals(false, cartExperience.getReady());
    }

    @Test
    public void testGetReadyNotNull() throws Exception {
        cartExperience.setVoucher(voucher);
        assertEquals(true, cartExperience.getReady());
    }

    @Test
    public void testGetPrice() throws Exception {
        cartExperience.setExperience(experience);
        assertTrue(1.0 == cartExperience.getPrice());
    }

    @Test
    public void testGetInvoiceVoucherNull() throws Exception {
        assertEquals(null, cartExperience.getInvoice());
    }

    @Test
    public void testGetInvoiceInvoiceNull() throws Exception {
        cartExperience.setVoucher(voucher);
        InvoiceexperienceRecord testInvoice = cartExperience.getInvoice();
        assertEquals(UInteger.valueOf(5), testInvoice.getExperiencevoucherid());
        Double expectedPrice = 20.0;
        assertEquals(expectedPrice, testInvoice.getPrice());
    }

    @Ignore("Cannot set invoice")
    @Test
    public void testGetInvoiceInvoiceNotNull() throws Exception {
        assertEquals(null, cartExperience.getInvoice());
    }

    @Test
    public void testGetExperience() throws Exception {
        cartExperience.setExperience(experience);
        assertEquals(experience, cartExperience.getExperience());
    }

    @Test
    public void testSetExperience() throws Exception {
        cartExperience.setExperience(experience);
        assertEquals(experience, cartExperience.getExperience());
    }

    @Test
    public void testGetVoucher() throws Exception {
        cartExperience.setVoucher(voucher);
        assertEquals(voucher,cartExperience.getVoucher());
    }

    @Test
    public void testSetVoucher() throws Exception {
        cartExperience.setVoucher(voucher);
        assertEquals(voucher,cartExperience.getVoucher());
    }

}