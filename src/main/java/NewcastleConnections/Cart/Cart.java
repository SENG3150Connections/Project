package NewcastleConnections.Cart;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.*;
import org.apache.struts2.ServletActionContext;
import org.jooq.types.UInteger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Scott on 14/08/2017.
 */
public class Cart {

    private List<CartExperience> experiences;
    private List<CartHotel> hotels;
    private List<CartRestaurant> restaurants;
    private List<CartTransport> transport;

    private Double price;

    public Cart() {
        experiences = new ArrayList<>();
        hotels = new ArrayList<>();
        restaurants = new ArrayList<>();
        transport = new ArrayList<>();
        price = 0.0;
    }

    public UInteger createInvoice() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String customerId = (String) request.getSession().getAttribute("userId");
        Timestamp date = new Timestamp(new Date().getTime());
        double price = 0.0;
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

            price = storeSubInvoices(connection, record.getId());
            record.setPrice(price);
            record.store();

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return record.getId();
    }

    private double storeSubInvoices(DatabaseConnection connection, UInteger id) {
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
        return getCurrentPrice();
    }

    public boolean getReadyToPay() {
        for (CartItem i : getAll()) {
            if (!i.getReady()) return false;
        }
        return true;
    }

    public double getCurrentPrice() {
        price = 0.0;
        for (CartItem i : getAll()) {
            if (i.getReady())
                price += i.getPrice();
        }
        return price;
    }

    public void removeExperience(int id) {
        for (CartExperience e : experiences) {
            if (e.getExperience().getId().intValue() == id) {
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

    public List<CartItem> getAll() {
        List<CartItem> list = new ArrayList<>();
        list.addAll(experiences);
        list.addAll(hotels);
        list.addAll(restaurants);
        list.addAll(transport);
        return list;
    }

    public int getSize() {
        return getAll().size();
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

    public List<CartExperience> getExperiences() {
        return experiences;
    }

    public List<CartHotel> getHotels() {
        return hotels;
    }

    public List<CartRestaurant> getRestaurants() {
        return restaurants;
    }

    public List<CartTransport> getTransport() {
        return transport;
    }

    public Double getPrice() {
        return getCurrentPrice();
    }

    public Double getSavings() {
        return price/4;
    }
}
