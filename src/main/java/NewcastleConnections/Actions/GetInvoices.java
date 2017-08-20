package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.Result;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Harry on 21/08/2017.
 */
public class GetInvoices extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<InvoicesRecord> invoices;

    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            invoices = connection.getDSL().selectFrom(INVOICES).fetch();
            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

    public Result<InvoicesRecord> getInvoices() {
        return invoices;
    }
}
