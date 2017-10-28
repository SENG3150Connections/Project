package NewcastleConnections.Invoices;


import org.apache.struts2.StrutsJUnit4TestCase;
import org.jooq.types.UInteger;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class InvoiceInfoTest extends StrutsJUnit4TestCase<InvoiceInfo> {


    @Test
    public void getId() {
        InvoiceInfo invoiceInfo = new InvoiceInfo();

        invoiceInfo.setId(UInteger.valueOf(1));

        assertTrue("Should equal input",invoiceInfo.getId().equals(UInteger.valueOf(1)));

    }

    @Test
    public void getPurchaseDate() {
        InvoiceInfo invoiceInfo = new InvoiceInfo();

        invoiceInfo.setPurchasedate(Timestamp.valueOf("2017-10-01 00:00:00"));

        System.out.println(invoiceInfo.getPurchasedate());

        assertTrue("Should match input",invoiceInfo.getPurchasedate().matches("\\d{2}:\\d{2} .. \\d{2}\\/\\d{2}\\/\\d{4}"));
    }

    @Test
    public void getPrice() {
        InvoiceInfo invoiceInfo = new InvoiceInfo();

        invoiceInfo.setPrice(8.0);

        assertTrue("Should equal input",invoiceInfo.getPrice().matches("\\$\\d+.?\\d{2}"));
    }

    @Test
    public void getStatus() {
        InvoiceInfo invoiceInfo = new InvoiceInfo();

        invoiceInfo.setStatus(UInteger.valueOf(1));


        assertTrue("Should equal input",invoiceInfo.getStatus().equals(UInteger.valueOf(1)));

    }



}
