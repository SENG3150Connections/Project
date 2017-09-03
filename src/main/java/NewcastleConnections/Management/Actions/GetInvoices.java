package NewcastleConnections.Management.Actions;

/*
GetInvoices.java
Author: Harry Barden

Description:
    Simple action class to pass in all invoices
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.Result;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

public class GetInvoices extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<InvoicesRecord> invoices;

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // Query
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

    // -- Getters and Setters --

    public Result<InvoicesRecord> getInvoices() {
        return invoices;
    }
}
