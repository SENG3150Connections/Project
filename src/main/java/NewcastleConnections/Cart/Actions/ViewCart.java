package NewcastleConnections.Cart.Actions;

/*
ViewCart.java
Author: Scott Walker

Description:
    Simple action to inject the cart into the jsp
*/

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

public class ViewCart extends ActionSupport {

    private Cart cart;

    @Override
    public String execute() {
        return SUCCESS;
    }

    public Cart getCart() {
        return cart;
    }

    @Inject("cart")
    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
