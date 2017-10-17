package NewcastleConnections.Cart.Actions;

/*
UpdateCartTransport.java
Author: Scott Walker

Description:
    Action to update a particular transport in the cart.
*/

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartTransport;
import NewcastleConnections.Recommendations;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import java.sql.Timestamp;
import java.util.LinkedList;

public class UpdateCartTransport extends ActionSupport {
    private static final String DONE = "done";

    // Private member data
    private String edit;

    private Cart cart;
    private int cartIndex;
    private CartTransport transport;

    private Integer tickets;
    private String time;

    // Recommendations
    public Recommendations recommendations;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getTransport().size())
            return ERROR;
        transport = cart.getTransport().get(cartIndex);

        if (edit != null) {

            // Recommendations
            int numberOfResults = 2;
            if (cart.getHotels().size() != 0) {
                recommendations = new Recommendations(cart.getLastHotel().getHotel(), numberOfResults);
            } else if (cart.getExperiences().size() != 0) {
                recommendations = new Recommendations(cart.getLastExperience().getExperience(), numberOfResults);
            } else if (cart.getRestaurants().size() != 0) {
                recommendations = new Recommendations(cart.getLastRestaurant().getRestaurant(), numberOfResults);
            } else {
                recommendations = new Recommendations();
            }

            return SUCCESS;
        }

        // Valid tickets: Greater than 0
        if (tickets != null) {
            if (tickets < 0)
                return ERROR;
            transport.setTickets(tickets);
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (time != null && !time.isEmpty()) {
            try {
                Timestamp timestamp = Timestamp.valueOf(time);
                transport.setTime(timestamp);
            } catch (IllegalArgumentException e) {
                return ERROR;
            }
        }

        return DONE;
    }

    // -- Getters and Setters

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public Cart getCart() {
        return cart;
    }

    @Inject("cart")
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getCartIndex() {
        return cartIndex;
    }

    public void setCartIndex(int cartIndex) {
        this.cartIndex = cartIndex;
    }

    public CartTransport getTransport() {
        return transport;
    }

    public void setTransport(CartTransport transport) {
        this.transport = transport;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Recommendations getRecommendations() {
        return recommendations;
    }
}
