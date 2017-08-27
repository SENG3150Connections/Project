package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import com.opensymphony.xwork2.ActionSupport;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static NewcastleConnections.packagedeals.Tables.EXPERIENCES;
import static NewcastleConnections.packagedeals.Tables.HOTELS;
import static NewcastleConnections.packagedeals.Tables.RESTURANTS;

public class SortAlphabetical extends ActionSupport {


    // Results property (to be shared with the JSP page)
    private Result<HotelsRecord> hotels;
    private Result<ResturantsRecord> restaurants;
    private Result<ExperiencesRecord> experiences;
    private ArrayList<HotelsRecord> hotelsList = new ArrayList<HotelsRecord>();
    private ArrayList<ResturantsRecord> resturantList = new ArrayList<ResturantsRecord>();
    private ArrayList<ExperiencesRecord> experienceList = new ArrayList<ExperiencesRecord>();
    private String sort = null;

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

            for (HotelsRecord h : hotels) hotelsList.add(h);
            for (ResturantsRecord r : restaurants) resturantList.add(r);
            for (ExperiencesRecord e : experiences) experienceList.add(e);

            if (sort != null) {
                Collections.sort(hotelsList);
                Collections.sort(restaurants);
                Collections.sort(experiences);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

    public ArrayList<HotelsRecord> getHotelsList() {
        return hotelsList;
    }

    public ArrayList<ResturantsRecord> getResturantList() {
        return resturantList;
    }

    public ArrayList<ExperiencesRecord> getExperienceList() {
        return experienceList;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
