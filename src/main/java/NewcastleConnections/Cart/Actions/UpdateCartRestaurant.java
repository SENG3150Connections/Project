package NewcastleConnections.Cart.Actions;

/*
UpdateCartRestaurant.java
Author: Scott Walker

Description:
    Action to update a particular restaurant in the cart.
*/

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartRestaurant;
import NewcastleConnections.Recommendations;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import java.sql.Timestamp;
import java.util.LinkedList;

public class UpdateCartRestaurant extends ActionSupport {
    private static final String DONE = "done";

    private String edit;

    // Private member data
    private Cart cart;
    private int cartIndex;
    private CartRestaurant restaurant;

    private Integer seats;
    private String time;
    private Double voucherPrice;


    // Recommendations
    public Recommendations recommendations;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getRestaurants().size())
            return ERROR;
        restaurant = cart.getRestaurants().get(cartIndex);

        if (edit != null) {

            // Recommendations
            int numberOfResults = 2;
            if (cart.getHotels().size() != 0) {
                recommendations = new Recommendations(cart.getLastHotel().getHotel(), numberOfResults);
            } else if (cart.getExperiences().size() != 0) {
                recommendations = new Recommendations(cart.getLastExperience().getExperience(), numberOfResults);
            } else if (cart.getRestaurants().size() != 0) {
                recommendations = new Recommendations(cart.getLastRestaurant().getRestaurant(), numberOfResults);
            }

            return SUCCESS;
        }

        // We have submitted the form, save the data

        // Valid seats: Greater than 0
        if (seats != null) {
            if (seats < 0)
                return ERROR;
            restaurant.setSeats(seats);
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (time != null && !time.isEmpty()) {
            try {
                Timestamp timestamp = Timestamp.valueOf(time);
                restaurant.setTime(timestamp);
            } catch (IllegalArgumentException e) {
                return ERROR;
            }
        }

        if (voucherPrice != null) {
            if (voucherPrice < 0)
                return ERROR;
            restaurant.setVoucherPrice(voucherPrice);
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

    public CartRestaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(CartRestaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getVoucherPrice() {
        return voucherPrice;
    }

    public void setVoucherPrice(Double voucherPrice) {
        this.voucherPrice = voucherPrice;
    }

    public Recommendations getRecommendations() {
        return recommendations;
    }
}
