package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import NewcastleConnections.packagedeals.tables.records.RoomofferingsRecord;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Scott on 14/08/2017.
 */
public class Cart {

    private Set<ExperiencevoucherofferingsRecord> experiences;
    private Set<RoomofferingsRecord> rooms;
    private Set<ResturantsRecord> restaurants;

    private String name = "";

    public Cart() {
        experiences = new HashSet<ExperiencevoucherofferingsRecord>();
        rooms = new HashSet<RoomofferingsRecord>();
        restaurants = new HashSet<ResturantsRecord>();
    }

    public Set<ExperiencevoucherofferingsRecord> getExperiences() {
        return experiences;
    }

    public Set<RoomofferingsRecord> getRooms() {
        return rooms;
    }

    public Set<ResturantsRecord> getRestaurants() {
        return restaurants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
