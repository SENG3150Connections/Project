package NewcastleConnections;

import NewcastleConnections.packagedeals.tables.Invoicetransport;
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

    private Set<InvoiceexperienceRecord> experiences;
    private Set<InvoicehotelRecord> rooms;
    private Set<InvoicerestaurantRecord> restaurants;
    private Set<InvoicetransportRecord> transport;

    private String name = "";

    public Cart() {
        experiences = new HashSet<>();
        rooms = new HashSet<>();
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
        for (InvoiceexperienceRecord r : experiences) {
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
        for (InvoicehotelRecord r : rooms) {
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
        for (InvoicerestaurantRecord r : restaurants) {
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
        for (InvoicetransportRecord r : transport) {
            connection.getDSL().attach(r);
            r.setInvoiceid(id);
            r.store();
        }
    }

    public void removeExperience(int id) {
        for (InvoiceexperienceRecord e : experiences) {
            if (e.getExperiencevoucherid().intValue() == id) {
                //e.delete(); // Need to attach first? Or not stored yet
                experiences.remove(e);
                return;
            }
        }
    }

    public void removeRoom(int id) {
        for (InvoicehotelRecord e : rooms) {
            if (e.getRoomid().intValue() == id) {
                rooms.remove(e);
                return;
            }
        }
    }

    public void removeRestaurant(int id) {
        for (InvoicerestaurantRecord e : restaurants) {
            if (e.getRestaurantid().intValue() == id) {
                restaurants.remove(e);
                return;
            }
        }
    }

    public void removeTransport(int id) {
        for (InvoicetransportRecord e : transport) {
            if (e.getTransportid().intValue() == id) {
                transport.remove(e);
                return;
            }
        }
    }

    // -- Getters, Setters, etc --

    public void addExperience(InvoiceexperienceRecord r) {
        experiences.add(r);
    }

    public void addRoom(InvoicehotelRecord r) {
        rooms.add(r);
    }

    public void addRestaurant(InvoicerestaurantRecord r) {
        restaurants.add(r);
    }

    public void addTransport(InvoicetransportRecord r) {
        transport.add(r);
    }

    public void removeExperience(InvoiceexperienceRecord r) {
        experiences.remove(r);
    }

    public void removeRoom(InvoicehotelRecord r) {
        rooms.remove(r);
    }

    public void removeRestaurant(InvoicerestaurantRecord r) {
        restaurants.remove(r);
    }

    public void removeTransport(InvoicetransportRecord r) {
        transport.remove(r);
    }

    public Set<InvoiceexperienceRecord> getExperiences() {
        return experiences;
    }

    public Set<InvoicehotelRecord> getRooms() {
        return rooms;
    }

    public Set<InvoicerestaurantRecord> getRestaurants() {
        return restaurants;
    }

    public Set<InvoicetransportRecord> getTransport() {
        return transport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
