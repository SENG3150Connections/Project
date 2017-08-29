package NewcastleConnections.Cart.Actions;

/*
UpdateCartHotel.java
Author: Scott Walker

Description:
    Action to update a particular hotel in the cart.
*/

import NewcastleConnections.Cart.Cart;
import NewcastleConnections.Cart.CartHotel;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.Recommendations;
import NewcastleConnections.packagedeals.tables.records.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import static NewcastleConnections.packagedeals.Tables.ROOMOFFERINGS;

public class UpdateCartHotel extends ActionSupport {
    private static final String DONE = "done";

    // Private member data
    private String edit;
    private Result<RoomofferingsRecord> offerings;

    private Cart cart;
    private int cartIndex;
    private CartHotel hotel;

    private Integer roomId;
    private Integer adults;
    private Integer children;
    private String checkIn;
    private String checkOut;

    // Recommendations
    public Recommendations recommendations;

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getHotels().size())
            return ERROR;

        hotel = cart.getHotels().get(cartIndex);
        try {
            DatabaseConnection connection = new DatabaseConnection();

            if (edit != null) {
                offerings = connection.getDSL().selectFrom(ROOMOFFERINGS)
                        .where(ROOMOFFERINGS.HOTELID.eq(UInteger.valueOf(hotel.getId()))).fetch();
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

            RoomofferingsRecord room = connection.getDSL().selectFrom(ROOMOFFERINGS)
                    .where(ROOMOFFERINGS.ID.eq(UInteger.valueOf(roomId))).fetch().get(0);
            hotel.setRoom(room);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Valid adults: Greater than 0
        if (adults != null) {
            if (adults < 1)
                return ERROR;
            hotel.setAdults(adults);
        }

        // Valid children: At least 0
        if (children != null) {
            if (children < 0)
                return ERROR;
            hotel.setChildren(children);
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (checkIn != null && !checkIn.isEmpty()) {
            try {
                Timestamp timestamp = Timestamp.valueOf(checkIn);
                hotel.setCheckIn(timestamp);
            } catch (IllegalArgumentException e) {
                return ERROR;
            }
        }

        // Valid timestamp: yyyy-[m]m-[d]d hh:mm:ss
        if (checkOut != null && !checkOut.isEmpty()) {
            try {
                Timestamp timestamp = Timestamp.valueOf(checkOut);
                hotel.setCheckOut(timestamp);
            } catch (IllegalArgumentException e) {
                return ERROR;
            }
        }

        return DONE;
    }

    // -- Getters and Setters

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public Result<RoomofferingsRecord> getOfferings() {
        return offerings;
    }

    public void setOfferings(Result<RoomofferingsRecord> offerings) {
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

    public CartHotel getHotel() {
        return hotel;
    }

    public void setHotel(CartHotel hotel) {
        this.hotel = hotel;
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

    public Recommendations getRecommendations() {
        return recommendations;
    }
}
