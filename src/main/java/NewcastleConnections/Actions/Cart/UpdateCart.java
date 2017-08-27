package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCart extends ActionSupport {

    private String method;
    private String type;
    private Integer id;

    private Cart cart;

    @Override
    public String execute() {
        if (getMethod() == null || getType() == null)
            return SUCCESS; // Simply redirect back

        boolean add = getMethod().equalsIgnoreCase("add");
        boolean remove = getMethod().equalsIgnoreCase("remove");

        switch(getType().toLowerCase()) {
            case "experience":
                if (add) {
                    getCart().getExperiences().add(new CartExperience(id));
                }
                else if (remove) {
                    getCart().removeExperience(id);
                }
                break;

            case "hotel":
                if (add) {
                    getCart().getHotels().add(new CartHotel(id));
                }
                else if (remove) {
                    getCart().removeHotel(id);
                }
                break;

            case "restaurant":
                if (add) {
                    getCart().getRestaurants().add(new CartRestaurant(id));
                }
                else if (remove) {
                    getCart().removeRestaurant(id);
                }
                break;

            case "transport":
                if (add) {
                    getCart().getTransport().add(new CartTransport(id));
                }
                else if (remove) {
                    getCart().removeTransport(id);
                }
                break;

            default:
                break;

        }

        return SUCCESS;
    }

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
