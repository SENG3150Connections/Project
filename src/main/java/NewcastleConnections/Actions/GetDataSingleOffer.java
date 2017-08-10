package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.Result;

import javax.naming.NamingException;
import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by seb on 1/8/17.
 */
public class GetDataSingleOffer extends ActionSupport {


    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> hotels;
    private String id;

    public HotelsRecord getHotel() { return hotels.get(0); }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            hotels = connection.getDSL().selectFrom(HOTELS).where("id=" + id).fetch();
            // Close connection
            connection.close();

        } catch (SQLException | NamingException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }
}
