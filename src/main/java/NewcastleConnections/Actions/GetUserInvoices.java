package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.auth0.IdentityVerificationException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.Result;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Jack on 19/08/2017.
 */
public class GetUserInvoices extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<InvoicesRecord> invoices;

    public Result<InvoicesRecord> getInvoices() {
        return invoices;
    }

    @Override
    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            String userID = (String) request.getSession().getAttribute("userNickname");

            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            invoices = connection.getDSL().selectFrom(INVOICES).where(INVOICES.CUSTOMERID.eq(userID)).fetch();
            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        } catch (NamingException e) {
            e.printStackTrace();
        }

        // Return Success
        return SUCCESS;
    }

}
