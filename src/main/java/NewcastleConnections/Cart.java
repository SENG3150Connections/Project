package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.records.InvoiceexperienceRecord;
import NewcastleConnections.packagedeals.tables.records.InvoicehotelRecord;
import NewcastleConnections.packagedeals.tables.records.InvoicerestaurantRecord;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Scott on 14/08/2017.
 */
public class Cart {

    private Set<InvoiceexperienceRecord> experiences;
    private Set<InvoicehotelRecord> hotels;
    private Set<InvoicerestaurantRecord> restaurants;

    private String name = "";

    public Cart() {
        experiences = new HashSet<>();
        hotels = new HashSet<>();
        restaurants = new HashSet<>();
    }

    public Set<InvoiceexperienceRecord> getExperiences() {
        return experiences;
    }

    public Set<InvoicehotelRecord> getHotels() {
        return hotels;
    }

    public Set<InvoicerestaurantRecord> getRestaurants() {
        return restaurants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
