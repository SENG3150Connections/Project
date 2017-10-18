package NewcastleConnections.Management.Actions;

/*
CreateOffer.java
Author: Seb Brown / Scott Walker

Description:
    Simple action class to pass an offer by its ID
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.types.UInteger;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

public class GetOfferByID extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private HotelsRecord hotel;
    private String id;

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // Query
            hotel = connection.getDSL().selectFrom(HOTELS).where(HOTELS.ID.eq(UInteger.valueOf(id))).fetch().get(0);
            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

    // -- Getters and Setters

    public HotelsRecord getHotel() {
        return hotel;
    }

    public void setHotel(HotelsRecord hotel) {
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
