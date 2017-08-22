package NewcastleConnections.Cart;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.*;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Scott on 14/08/2017.
 */
public class Cart {

    private Set<CartExperience> experiences;
    private Set<CartHotel> hotels;
    private Set<CartRestaurant> restaurants;
    private Set<CartTransport> transport;

    private String name = "";

    public Cart() {
        experiences = new HashSet<>();
        hotels = new HashSet<>();
        restaurants = new HashSet<>();
        transport = new HashSet<>();
    }

    public UInteger createInvoice() {
        String customerId = "TESTING-ID";
        Timestamp date = new Timestamp(new Date().getTime());
        double price = 10.20;
        int status = 1; // Preparing

        InvoicesRecord record = new InvoicesRecord();
        record.setCustomerid(customerId);
        record.setPurchasedate(date);
        record.setPrice(price);
        record.setStatus(UInteger.valueOf(status));

        try {
            DatabaseConnection connection = new DatabaseConnection();

            connection.getDSL().attach(record);
            record.store();

            storeSubInvoices(connection, record.getId());

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return record.getId();
    }

    private void storeSubInvoices(DatabaseConnection connection, UInteger id) {
        for (CartExperience c : experiences) {
            InvoiceexperienceRecord r = c.getInvoice();
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
        for (CartHotel c : hotels) {
            InvoicehotelRecord r = c.getInvoice();
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
        for (CartRestaurant c : restaurants) {
            InvoicerestaurantRecord r = c.getInvoice();
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
        for (CartTransport c : transport) {
            InvoicetransportRecord r = c.getInvoice();
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
    }

    public void removeExperience(int id) {
        for (CartExperience e : experiences) {
            if (e.getExperience().getId().intValue() == id) {
                //e.delete(); // Need to attach first? Or not stored yet
                experiences.remove(e);
                return;
            }
        }
    }

    public void removeHotel(int id) {
        for (CartHotel e : hotels) {
            if (e.getHotel().getId().intValue() == id) {
                hotels.remove(e);
                return;
            }
        }
    }

    public void removeRestaurant(int id) {
        for (CartRestaurant e : restaurants) {
            if (e.getRestaurant().getId().intValue() == id) {
                restaurants.remove(e);
                return;
            }
        }
    }

    public void removeTransport(int id) {
        for (CartTransport e : transport) {
            if (e.getTransport().getId().intValue() == id) {
                transport.remove(e);
                return;
            }
        }
    }

    // -- Getters, Setters, etc --

    public void addExperience(CartExperience c) {
        experiences.add(c);
    }

    public void addRoom(CartHotel r) {
        hotels.add(r);
    }

    public void addRestaurant(CartRestaurant r) {
        restaurants.add(r);
    }

    public void addTransport(CartTransport r) {
        transport.add(r);
    }

    public void removeExperience(CartExperience c) {
        experiences.remove(c);
    }

    public void removeHotel(CartHotel r) {
        hotels.remove(r);
    }

    public void removeRestaurant(CartRestaurant r) {
        restaurants.remove(r);
    }

    public void removeTransport(CartTransport r) {
        transport.remove(r);
    }

    public Set<CartExperience> getExperiences() {
        return experiences;
    }

    public Set<CartHotel> getHotels() {
        return hotels;
    }

    public Set<CartRestaurant> getRestaurants() {
        return restaurants;
    }

    public Set<CartTransport> getTransport() {
        return transport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
