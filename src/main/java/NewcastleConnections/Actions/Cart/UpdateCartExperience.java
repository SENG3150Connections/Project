package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartExperience;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.Recommendations;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.util.LinkedList;

import static NewcastleConnections.packagedeals.Tables.EXPERIENCEVOUCHEROFFERINGS;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCartExperience extends ActionSupport {
    private static final String DONE = "done";

    private String edit;
    private Result<ExperiencevoucherofferingsRecord> offerings;

    private Cart cart;
    private int cartIndex;
    private CartExperience experience;

    private Integer voucherId;

    // Recommendations
    public LinkedList recommendedHotels;
    public LinkedList recommendedRestaurants;
    public LinkedList recommendedExperiences;
    public int recommendedItem = (int)(Math.random() * 3);

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getExperiences().size())
            return ERROR;

        experience = cart.getExperiences().get(cartIndex);
        try {
            DatabaseConnection connection = new DatabaseConnection();

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


            if (edit != null) {
                offerings = connection.getDSL().selectFrom(EXPERIENCEVOUCHEROFFERINGS)
                        .where(EXPERIENCEVOUCHEROFFERINGS.EXPERIENCEID.eq(UInteger.valueOf(experience.getId()))).fetch();
                connection.close();
                return SUCCESS;
            }

            ExperiencevoucherofferingsRecord voucher = connection.getDSL().selectFrom(EXPERIENCEVOUCHEROFFERINGS)
                    .where(EXPERIENCEVOUCHEROFFERINGS.ID.eq(UInteger.valueOf(voucherId))).fetch().get(0);
            experience.setVoucher(voucher);
            connection.close();
            return DONE;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public Result<ExperiencevoucherofferingsRecord> getOfferings() {
        return offerings;
    }

    public void setOfferings(Result<ExperiencevoucherofferingsRecord> offerings) {
        this.offerings = offerings;
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

    public CartExperience getExperience() {
        return experience;
    }

    public void setExperience(CartExperience experience) {
        this.experience = experience;
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }
}
