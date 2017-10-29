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
import org.jooq.Result;
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
            try {
                Result<HotelsRecord> hotelRecord = connection.getDSL().selectFrom(HOTELS).where(HOTELS.ID.eq(UInteger.valueOf(id))).fetch();
                // If hotel exists assign, else return null
                if (hotelRecord.size() != 0)
                    hotel = hotelRecord.get(0);
                else
                    hotel = null;
            // If the id is negative and out off array
            } catch (NumberFormatException e) {
                return ERROR;
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
