package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCart extends ActionSupport {

    private Cart cart;

    @Override
    public String execute() {
        getCart().setName("THIS IS STILL A CART");
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
