package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartRestaurant;
import NewcastleConnections.Recommendations;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCartRestaurant extends ActionSupport {
    private static final String DONE = "done";

    private String edit;

    private Cart cart;
    private int cartIndex;
    private CartRestaurant restaurant;

    private Integer seats;
    private String time;
    private Double voucherPrice;


    // Recommendations
    public LinkedList recommendedHotels;
    public LinkedList recommendedRestaurants;
    public LinkedList recommendedExperiences;
    public int recommendedItem = (int)(Math.random() * 3);


    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getRestaurants().size())
            return ERROR;
        restaurant = cart.getRestaurants().get(cartIndex);

        if (edit != null) {

            // Recommendations
            Recommendations recommendations = new Recommendations();
            int numberOfResults = 2;

            if (cart.getHotels().size() != 0) {

                HotelsRecord hotel = cart.getHotels().get(cart.getHotels().size()-1).getHotel();
                recommendations.generateRecommendations(hotel.getLongitude(),hotel.getLatitude(),numberOfResults);

            } else if (cart.getExperiences().size() != 0) {

                ExperiencesRecord experience = cart.getExperiences().get(cart.getExperiences().size()-1).getExperience();
                recommendations.generateRecommendations(experience.getLongitude(),experience.getLatitude(),numberOfResults);

            } else if (cart.getRestaurants().size() != 0) {

                ResturantsRecord resturant = cart.getRestaurants().get(cart.getRestaurants().size()-1).getRestaurant();
                recommendations.generateRecommendations(resturant.getLongitude(),resturant.getLatitude(),numberOfResults);
            }

            recommendedHotels = recommendations.hotels;
            recommendedExperiences = recommendations.experiences;
            recommendedRestaurants = recommendations.restaurants;


            return SUCCESS;
        }

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
}
