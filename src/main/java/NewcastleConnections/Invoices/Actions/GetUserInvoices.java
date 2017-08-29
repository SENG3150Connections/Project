package NewcastleConnections.Invoices.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.Invoices.InvoiceInfo;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.Result;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Jack on 19/08/2017.
 */
public class GetUserInvoices extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private List<InvoiceInfo> invoices;

    public List<InvoiceInfo> getInvoices() {
        return invoices;
    }

    @Override
    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String userID = (String) request.getSession().getAttribute("userId");

            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            Result<InvoicesRecord> invoicesRecords;
            invoicesRecords = connection.getDSL().selectFrom(INVOICES).where(INVOICES.CUSTOMERID.eq(userID)).fetch();

            invoices = new ArrayList<>();
            for (InvoicesRecord x: invoicesRecords) {
                InvoiceInfo newInvoice = new InvoiceInfo();
                newInvoice.setId(x.getId());
                newInvoice.setPrice(x.getPrice());
                newInvoice.setStatus(x.getStatus());
                newInvoice.setPurchasedate(x.getPurchasedate());
                invoices.add(newInvoice);
            }
            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

}
