package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartHotel;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.RoomofferingsRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;

import static NewcastleConnections.packagedeals.Tables.ROOMOFFERINGS;

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCartHotel extends ActionSupport {

    private Cart cart;
    private int cartIndex;

    private Integer roomId;
    private Integer adults;
    private Integer children;
    private String checkIn;
    private String checkOut;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getHotels().size())
            return ERROR;

        CartHotel hotel = cart.getHotels().get(cartIndex);

        try {
            DatabaseConnection connection = new DatabaseConnection();
            RoomofferingsRecord room = connection.getDSL().selectFrom(ROOMOFFERINGS)
                    .where(ROOMOFFERINGS.ID.eq(UInteger.valueOf(roomId))).fetch().get(0);
            hotel.setRoom(room);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Valid seats: Greater than 0
        if (adults != null) {
            if (adults < 1)
                return ERROR;
            hotel.setAdults(adults);
        }

        // Valid seats: Greater than 0
        if (children != null) {
            if (children < 1)
                return ERROR;
            hotel.setChildren(children);
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (checkIn != null) {
            try {
                Timestamp timestamp = Timestamp.valueOf(checkIn);
                hotel.setCheckIn(timestamp);
            } catch (IllegalArgumentException e) {
                return ERROR;
            }
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (checkOut != null) {
            try {
                Timestamp timestamp = Timestamp.valueOf(checkOut);
                hotel.setCheckOut(timestamp);
            } catch (IllegalArgumentException e) {
                return ERROR;
            }
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
