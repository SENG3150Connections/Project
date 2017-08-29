package NewcastleConnections.Cart;

/*
Cart.java
Author: Scott Walker

Description:
    The cart object that will be stored in the session bean for the current user.
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.*;
import org.apache.struts2.ServletActionContext;
import org.jooq.types.UInteger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class Cart {

    // Private member lists for four cart item types.
    private List<CartExperience> experiences;
    private List<CartHotel> hotels;
    private List<CartRestaurant> restaurants;
    private List<CartTransport> transport;

    // The price of the cart in its current state, may not be final if cart is not ready.
    private Double price;

    // -- Constructor --
    //   Role: Initialise the cart.
    //
    public Cart() {
        experiences = new ArrayList<>();
        hotels = new ArrayList<>();
        restaurants = new ArrayList<>();
        transport = new ArrayList<>();
        price = 0.0;
    }

    // -- Public --
    //   Role: Store the cart and all of its contents as an invoice in the database.
    // Return: The invoice ID
    //
    public UInteger createInvoice() {
        HttpServletRequest request = ServletActionContext.getRequest();

        // Invoice data
        String customerId = (String) request.getSession().getAttribute("userId");
        Timestamp date = new Timestamp(new Date().getTime());
        double price;
        int status = 1; // Preparing

        // Set the data onto the invoice
        InvoicesRecord record = new InvoicesRecord();
        record.setCustomerid(customerId);
        record.setPurchasedate(date);
        record.setStatus(UInteger.valueOf(status));

        try {
            DatabaseConnection connection = new DatabaseConnection();

            // Store record to generate the ID.
            connection.getDSL().attach(record);
            record.store();

            // Store sub-invoices and get the total price
            price = storeSubInvoices(connection, record.getId());

            // Restore invoice with updated price.
            record.setPrice(price);
            record.store();

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return record.getId();
    }

    // -- Public --
    //   Role: Store each cart item as a separate invoice.
    // Return: Price of the invoices.
    //
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

    // -- Public --
    //   Role: Check if all the items in the cart are properly edited.
    //
    public boolean getReadyToPay() {
        for (CartItem i : getAll()) {
            if (!i.getReady()) return false;
        }
        return true;
    }

    // -- Public --
    //   Role: Get the current price for the cart, may not be final.
    //
    public double getCurrentPrice() {
        price = 0.0;
        for (CartItem i : getAll()) {
            if (i.getReady())
                price += i.getPrice();
        }
        return price;
    }

    // -- Public --
    //   Role: Remove an experience of certain ID from the cart.
    //
    public void removeExperience(int id) {
        for (CartExperience e : experiences) {
            if (e.getExperience().getId().intValue() == id) {
                experiences.remove(e);
                return;
            }
        }
    }

    // -- Public --
    //   Role: Remove a hotel of certain ID from the cart.
    //
    public void removeHotel(int id) {
        for (CartHotel e : hotels) {
            if (e.getHotel().getId().intValue() == id) {
                hotels.remove(e);
                return;
            }
        }
    }

    // -- Public --
    //   Role: Remove a restaurant of certain ID from the cart.
    //
    public void removeRestaurant(int id) {
        for (CartRestaurant e : restaurants) {
            if (e.getRestaurant().getId().intValue() == id) {
                restaurants.remove(e);
                return;
            }
        }
    }

    // -- Public --
    //   Role: Remove a transport of certain ID from the cart.
    //
    public void removeTransport(int id) {
        for (CartTransport e : transport) {
            if (e.getTransport().getId().intValue() == id) {
                transport.remove(e);
                return;
            }
        }
    }

    // -- Public --
    //   Role: Get all the items in the cart as one list.
    //
    public List<CartItem> getAll() {
        List<CartItem> list = new ArrayList<>();
        list.addAll(experiences);
        list.addAll(hotels);
        list.addAll(restaurants);
        list.addAll(transport);
        return list;
    }

    // -- Public --
    //   Role: Get the size of the cart.
    //
    public int getSize() {
        return getAll().size();
    }

    // -- Basic Getters, Setters, etc --

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
        return price / 4;
    }
}
