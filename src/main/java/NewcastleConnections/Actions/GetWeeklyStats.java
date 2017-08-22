package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.Result;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.INVOICES;

/**
 * Created by Harry on 21/08/2017.
 */
public class GetWeeklyStats extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<InvoicesRecord> invoices;
    private double grossSales = 0.0;
    private double netSales = 0.0;
    private int ordersPlaced = 0;
    private int itemsPurchased = 0;
    private double refunded = 0.0;
    private double couponSales = 0.0;

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

        for (InvoicesRecord invoice : invoices) {
            grossSales += invoice.getPrice();
            ordersPlaced++;
            itemsPurchased++;
            couponSales += invoice.getPrice() * 0.25;
        }

        netSales = grossSales * 0.2;

        // Return Success
        return SUCCESS;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getNetSales() {
        return netSales;
    }

    public int getOrdersPlaced() {
        return ordersPlaced;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public double getRefunded() {
        return refunded;
    }

    public double getCouponSales() {
        return couponSales;
    }
}
