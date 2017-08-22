package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartRestaurant;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import java.sql.Timestamp;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCartRestaurant extends ActionSupport {

    private Cart cart;
    private int cartIndex;

    private Integer seats;
    private String time;
    private Double voucherPrice;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getRestaurants().size())
            return ERROR;

        CartRestaurant restaurant = cart.getRestaurants().get(cartIndex);

        // Valid seats: Greater than 0
        if (seats != null) {
            if (seats < 0)
                return ERROR;
            restaurant.setSeats(seats);
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (time != null) {
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

        return SUCCESS;
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
}
