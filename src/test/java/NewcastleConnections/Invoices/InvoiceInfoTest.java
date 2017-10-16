package NewcastleConnections.Invoices;

import NewcastleConnections.Authentication.ManagementInterceptor;
import NewcastleConnections.Invoices.InvoiceInfo;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceInfoTest extends StrutsJUnit4TestCase<InvoiceInfo> {

    @Test
    public void testSetId() throws Exception {

        InvoiceInfo invoiceInfo = new InvoiceInfo();

        invoiceInfo.setPrice(8.0);

        System.out.println(invoiceInfo.getPrice());

        assertTrue(invoiceInfo.getPrice().matches("\\$\\d+.?\\d{2}"));


    }

    private boolean matchesPattern(InvoiceInfo object) {

                return true;
    }
}
