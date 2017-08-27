package NewcastleConnections.Actions;

import NewcastleConnections.Cart.Cart;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

public class Complete extends ActionSupport {

    private Cart cart;
    private int id;

    @Override
    public String execute() {
        id = cart.createInvoice().intValue();
        // Return Success
        return SUCCESS;
    }

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
