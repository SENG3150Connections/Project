package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import NewcastleConnections.packagedeals.tables.records.TransportRecord;
import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import org.jooq.DSLContext;
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

    // URL bar properties
    private String search;
    private String start;
    private String finish;
    private int people;

    @Override
    public String execute() {
        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            DSLContext dsl = connection.getDSL();

            // query
            if (search == null || search.isEmpty()) {
                hotels = dsl.selectFrom(HOTELS).fetch();
                restaurants = dsl.selectFrom(RESTURANTS).fetch();
                experiences = dsl.selectFrom(EXPERIENCES).fetch();
                transport = dsl.selectFrom(TRANSPORT).fetch();
            } else {
                String like = "%"+search+"%";
                hotels = dsl.selectFrom(HOTELS).where(HOTELS.NAME.likeIgnoreCase(like)).fetch();
                restaurants = dsl.selectFrom(RESTURANTS).where(RESTURANTS.NAME.likeIgnoreCase(like)).fetch();
                experiences = dsl.selectFrom(EXPERIENCES).where(EXPERIENCES.NAME.likeIgnoreCase(like)).fetch();
                transport = dsl.selectFrom(TRANSPORT).where(TRANSPORT.NAME.likeIgnoreCase(like)).fetch();
            }

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

    // URL bar properties

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
