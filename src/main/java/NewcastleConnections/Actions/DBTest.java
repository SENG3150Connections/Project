package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import org.jooq.Result;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

public class DBTest extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> hotels;
    private Result<ResturantsRecord> restaurants;
    private Result<ExperiencesRecord> experiences;
    private Result<TransportRecord> transport;

    private int hotelCount;
    private int restaurantCount;
    private int experienceCount;
    private int transportCount;
    private int totalCount;

    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            hotels = connection.getDSL().selectFrom(HOTELS).fetch();
            restaurants = connection.getDSL().selectFrom(RESTURANTS).fetch();
            experiences = connection.getDSL().selectFrom(EXPERIENCES).fetch();
            transport = connection.getDSL().selectFrom(TRANSPORT).fetch();
            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        hotelCount = hotels.size();
        restaurantCount = restaurants.size();
        experienceCount = experiences.size();
        transportCount = transport.size();

        totalCount = hotelCount + restaurantCount + experienceCount + transportCount;

        // Return Success
        return SUCCESS;
    }

    public Result<HotelsRecord> getHotels() {
        return hotels;
    }

    public Result<ResturantsRecord> getRestaurants() {
        return restaurants;
    }

    public Result<ExperiencesRecord> getExperiences() {
        return experiences;
    }

    public Result<TransportRecord> getTransport() {
        return transport;
    }

    public int getHotelCount() {
        return hotelCount;
    }

    public int getRestaurantCount() {
        return restaurantCount;
    }

    public int getExperienceCount() {
        return experienceCount;
    }

    public int getTransportCount() {
        return transportCount;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
