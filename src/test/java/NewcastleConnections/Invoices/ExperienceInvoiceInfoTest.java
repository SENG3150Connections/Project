package NewcastleConnections.Invoices;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class ExperienceInvoiceInfoTest extends StrutsJUnit4TestCase<ExperienceInvoiceInfo> {


    @Test
    public void getExperienceID() {
        ExperienceInvoiceInfo object = new ExperienceInvoiceInfo();
        object.setExperienceID(UInteger.valueOf(1));
        assertTrue(object.getExperienceID() == 1);
    }

    @Test
    public void getPrice() {
        ExperienceInvoiceInfo object = new ExperienceInvoiceInfo();
        object.setPrice(1.0);
        assertTrue("Should equal input",object.getPrice().matches("\\$\\d+.?\\d{2}"));
    }


    @Test
    public void getName() {
        ExperienceInvoiceInfo object = new ExperienceInvoiceInfo();
        object.setName("Test");
        assertTrue(object.getName().equals("Test"));

    }

    @Test
    public void getLocation() {
        ExperienceInvoiceInfo object = new ExperienceInvoiceInfo();
        object.setLocation("Location");
        assertTrue(object.getLocation().equals("Location"));

    }

    @Test
    public void getImageID() {
        ExperienceInvoiceInfo object = new ExperienceInvoiceInfo();

        object.setImageID("ID");
        assertTrue(object.getImageID().equals("ID"));
    }


}
