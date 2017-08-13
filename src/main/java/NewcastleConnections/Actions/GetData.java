package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.RestaurantsRecord;
import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import org.jooq.Result;

import javax.naming.NamingException;
import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by seb on 1/8/17.
 */
public class GetData extends ActionSupport {


    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> hotels;
    private Result<RestaurantsRecord> restaurants;
    private Result<ExperiencesRecord> experiences;

    public Result<HotelsRecord> getHotels() {
        return hotels;
    }

    public Result<RestaurantsRecord> getRestaurants() {
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
            restaurants = connection.getDSL().selectFrom(RESTAURANTS).fetch();
            experiences = connection.getDSL().selectFrom(EXPERIENCES).fetch();
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
