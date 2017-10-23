package NewcastleConnections.Management.Actions;

/*
GetWeeklyStats.java
Author: Harry Barden

Description:
    Get the weekly stats for a business
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.InvoicesRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.Result;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static NewcastleConnections.packagedeals.Tables.INVOICES;

public class GetWeeklyStats extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<InvoicesRecord> invoices;
    private WeeklyStats[] weeklyStats = new WeeklyStats[7];

    private double grossSalesTotal = 0.0;
    private double netSalesTotal = 0.0;
    private int ordersPlacedTotal = 0;
    private int itemsPurchasedTotal = 0;
    private double refundedTotal = 0.0;
    private double couponSalesTotal = 0.0;

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
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

        // Create 7 weekly stats, for each day of the week.
        for (int i = 0; i < 7; i++)
            weeklyStats[i] = new WeeklyStats();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (InvoicesRecord invoice : invoices) {
            String invoiceDate = dateFormat.format(invoice.getPurchasedate());
            LocalDateTime now = LocalDateTime.now();
            String weeklyIntervalDate = new SimpleDateFormat("yyyy-MM-").format(invoice.getPurchasedate());
            String todayDate = new SimpleDateFormat("dd").format(invoice.getPurchasedate());
        }

        // return Success
        return SUCCESS;
    }

    // -- Getters and Setters --

    public WeeklyStats[] getWeeklyStats() {
        return weeklyStats;
    }

    public double getGrossSalesTotal() {
        return (int) grossSalesTotal;
    }

    public double getNetSalesTotal() {
        return (int) netSalesTotal;
    }

    public int getOrdersPlacedTotal() {
        return (int) ordersPlacedTotal;
    }

    public int getItemsPurchasedTotal() {
        return (int) itemsPurchasedTotal;
    }

    public double getRefundedTotal() {
        return (int) refundedTotal;
    }

    public double getCouponSalesTotal() {
        return (int) couponSalesTotal;
    }

    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
     |  Private inner class WeeklyStats  |
     *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

    public class WeeklyStats {
        private double grossSales = 0.0;
        private double netSales = 0.0;
        private int ordersPlaced = 0;
        private int itemsPurchased = 0;
        private double refunded = 0.0;
        private double couponSales = 0.0;

        private WeeklyStats() {
            grossSales = Math.random() * 1000;
            netSales = grossSales * 0.2;
            ordersPlaced = (int) (Math.random() * 20);
            itemsPurchased = (int) (Math.random() * 20);
            refunded = Math.random() * 10;
            couponSales = Math.random() * 1000;

            grossSalesTotal += grossSales;
            netSalesTotal += netSales;
            ordersPlacedTotal += ordersPlaced;
            grossSalesTotal += grossSales;
            itemsPurchasedTotal += itemsPurchased;
            refundedTotal += refunded;
            couponSalesTotal += couponSales * 0.25;
        }

        // -- Getters and Setters --

        public double getGrossSales() {
            return (int) grossSales;
        }

        public double getNetSales() {
            return (int) netSales;
        }

        public int getOrdersPlaced() {
            return ordersPlaced;
        }

        public int getItemsPurchased() {
            return itemsPurchased;
        }

        public double getRefunded() {
            return (int) refunded;
        }

        public double getCouponSales() {
            return (int) couponSales;
        }

    }
}
