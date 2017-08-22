package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartExperience;
import NewcastleConnections.Cart.CartRestaurant;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.EXPERIENCEVOUCHEROFFERINGS;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCartExperience extends ActionSupport {

    private Cart cart;
    private int cartIndex;

    private Integer voucherId;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getExperiences().size())
            return ERROR;

        CartExperience experience = cart.getExperiences().get(cartIndex);

        try {
            DatabaseConnection connection = new DatabaseConnection();
            ExperiencevoucherofferingsRecord voucher = connection.getDSL().selectFrom(EXPERIENCEVOUCHEROFFERINGS)
                    .where(EXPERIENCEVOUCHEROFFERINGS.ID.eq(UInteger.valueOf(voucherId))).fetch().get(0);
            experience.setVoucher(voucher);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
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

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }
}
