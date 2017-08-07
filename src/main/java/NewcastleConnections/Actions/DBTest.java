package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import org.jooq.Result;

import javax.naming.NamingException;
import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by seb on 1/8/17.
 */
public class DBTest extends ActionSupport {


    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> hotels;
    private Result<ResturantsRecord> restaurants;
    private Result<ExperiencesRecord> experiences;

    public Result<HotelsRecord> getHotels() {
        return hotels;
    }

    public Result<ResturantsRecord> getRestaurants() {
        return restaurants;
    }

    public Result<ExperiencesRecord> getExperiences() {
        return experiences;
    }

    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            hotels = connection.getDSL().selectFrom(HOTELS).fetch();
            restaurants = connection.getDSL().selectFrom(RESTURANTS).fetch();
            experiences = connection.getDSL().selectFrom(EXPERIENCES).fetch();
            // Close connection
            connection.close();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }
}
