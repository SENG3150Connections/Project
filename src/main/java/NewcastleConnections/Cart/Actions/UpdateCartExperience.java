package NewcastleConnections.Cart.Actions;

/*
UpdateCartExperience.java
Author: Scott Walker

Description:
    Action to update a particular experience in the cart.
*/

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartExperience;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.Recommendations;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.util.LinkedList;

import static NewcastleConnections.packagedeals.Tables.EXPERIENCEVOUCHEROFFERINGS;

public class UpdateCartExperience extends ActionSupport {
    private static final String DONE = "done";

    // Private member data
    private String edit;
    private Result<ExperiencevoucherofferingsRecord> offerings;

    private Cart cart;
    private int cartIndex;
    private CartExperience experience;

    private Integer voucherId;

    // Recommendations
    private Recommendations recommendations;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getExperiences().size())
            return ERROR;

        experience = cart.getExperiences().get(cartIndex);
        try {
            DatabaseConnection connection = new DatabaseConnection();

            if (edit != null) {
                offerings = connection.getDSL().selectFrom(EXPERIENCEVOUCHEROFFERINGS)
                        .where(EXPERIENCEVOUCHEROFFERINGS.EXPERIENCEID.eq(UInteger.valueOf(experience.getId()))).fetch();
                connection.close();

                // Recommendations
                int numberOfResults = 2;
                if (cart.getHotels().size() != 0) {
                    recommendations = new Recommendations(cart.getLastHotel().getHotel(), numberOfResults);
                } else if (cart.getExperiences().size() != 0) {
                    recommendations = new Recommendations(cart.getLastExperience().getExperience(), numberOfResults);
                } else if (cart.getRestaurants().size() != 0) {
                    recommendations = new Recommendations(cart.getLastRestaurant().getRestaurant(), numberOfResults);
                } else {
                    recommendations = new Recommendations();
                }

                return SUCCESS;
            }

            // We have submitted the form, save the data

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

    // -- Getters and Setters

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

    public Recommendations getRecommendations() {
        return recommendations;
    }
}
