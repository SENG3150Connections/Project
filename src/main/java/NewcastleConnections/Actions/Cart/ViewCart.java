package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

/**
 * Created by Scott on 14/08/2017.
 */
public class ViewCart extends ActionSupport {

    private Cart cart;

    @Override
    public String execute() {
        if (cart.getName().isEmpty())
            getCart().setName("THIS IS A CART");
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
