package NewcastleConnections.Actions.Cart;

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

/**
 * Created by Scott on 14/08/2017.
 */
public class UpdateCartHotel extends ActionSupport {
    private static final String DONE = "done";

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
    public LinkedList recommendedHotels;
    public LinkedList recommendedRestaurants;
    public LinkedList recommendedExperiences;
    int recommendedItem = (int)(Math.random() * 3);

    @Override
    public String execute() {
        // Valid index: 0 to size-1
        if (cartIndex < 0 || cartIndex >= cart.getHotels().size())
            return ERROR;

        hotel = cart.getHotels().get(cartIndex);
        try {
            DatabaseConnection connection = new DatabaseConnection();


            // Recommendations
            Recommendations recommendations = new Recommendations();

            if (cart.getHotels().size() != 0) {

                HotelsRecord hotel = cart.getHotels().get(cart.getHotels().size()-1).getHotel();
                recommendations.generateRecommendations(hotel.getLongitude(),hotel.getLatitude(),2);

            } else if (cart.getExperiences().size() != 0) {

                ExperiencesRecord experience = cart.getExperiences().get(cart.getExperiences().size()-1).getExperience();
                recommendations.generateRecommendations(experience.getLongitude(),experience.getLatitude(),2);

            } else if (cart.getRestaurants().size() != 0) {

                ResturantsRecord resturant = cart.getRestaurants().get(cart.getRestaurants().size()-1).getRestaurant();
                recommendations.generateRecommendations(resturant.getLongitude(),resturant.getLatitude(),2);
            }

            recommendedHotels = recommendations.hotels;
            recommendedExperiences = recommendations.experiences;
            recommendedRestaurants = recommendations.restaurants;


            if (edit != null) {
                offerings = connection.getDSL().selectFrom(ROOMOFFERINGS)
                        .where(ROOMOFFERINGS.HOTELID.eq(UInteger.valueOf(hotel.getId()))).fetch();
                connection.close();
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
}
