package NewcastleConnections.Actions;

/*
Complete.java
Author: Scott Walker

Description:
    Action called once payment is confirmed, storing the invoice.
*/

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

public class Complete extends ActionSupport {

    // Members shared with the JSP
    private Cart cart;
    private int id;

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
    @Override
    public String execute() {
        // Store the invoice and get the ID.
        id = cart.createInvoice().intValue();
        // Return Success
        return SUCCESS;
    }

    // -- Getters and Setters --

    public Cart getCart() {
        return cart;
    }

    @Inject("cart")
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
