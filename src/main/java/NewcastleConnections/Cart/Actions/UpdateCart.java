package NewcastleConnections.Cart.Actions;

/*
UpdateCart.java
Author: Scott Walker

Description:
    Action to update the contents of the cart, not edit the individual items.
*/

import NewcastleConnections.Cart.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

public class UpdateCart extends ActionSupport {

    private String method;
    private String type;
    private Integer id;

    private Cart cart;

    @Override
    public String execute() {
        if (getMethod() == null || getType() == null || id == null)
            return SUCCESS; // Simply redirect back if not all parameters are supplied.

        boolean add = getMethod().equalsIgnoreCase("add");
        boolean remove = getMethod().equalsIgnoreCase("remove");

        switch(getType().toLowerCase()) {
            // Get or remove an experience
            case "experience":
                if (add)
                    getCart().getExperiences().add(new CartExperience(id));
                else if (remove)
                    getCart().removeExperience(id);
                break;

            // Get or remove a hotel
            case "hotel":
                if (add)
                    getCart().getHotels().add(new CartHotel(id));
                else if (remove)
                    getCart().removeHotel(id);
                break;

            // Get or remove a restaurant
            case "restaurant":
                if (add)
                    getCart().getRestaurants().add(new CartRestaurant(id));
                else if (remove)
                    getCart().removeRestaurant(id);
                break;

            // Get or remove transport
            case "transport":
                if (add)
                    getCart().getTransport().add(new CartTransport(id));
                else if (remove)
                    getCart().removeTransport(id);
                break;

            // Ignore anything else
            default:
                break;

        }

        return SUCCESS;
    }

    // -- Getters and Setters

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    @Inject("cart")
    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
