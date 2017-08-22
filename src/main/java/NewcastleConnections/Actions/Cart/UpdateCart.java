package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart;
import NewcastleConnections.CartExperience;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.Invoicerestaurant;
import NewcastleConnections.packagedeals.tables.records.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.jooq.types.UInteger;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.EXPERIENCEVOUCHEROFFERINGS;
import static NewcastleConnections.packagedeals.Tables.RESTURANTS;
import static NewcastleConnections.packagedeals.Tables.ROOMOFFERINGS;

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
        if (getMethod().equalsIgnoreCase("add")) {
            getCart().setName("CART - ADD");
            switch(getType().toLowerCase()) {
                case "experience":
                    getCart().getExperiences().add(new CartExperience(id));
                    break;

                case "room":
                    InvoicehotelRecord ihr = new InvoicehotelRecord();
                    ihr.setRoomid(UInteger.valueOf(id));
                    getCart().getRooms().add(ihr);
                    break;

                case "restaurant":
                    InvoicerestaurantRecord irr = new InvoicerestaurantRecord();
                    irr.setRestaurantid(UInteger.valueOf(id));
                    getCart().getRestaurants().add(irr);
                    break;

                case "transport":
                    InvoicetransportRecord itr = new InvoicetransportRecord();
                    itr.setTransportid(UInteger.valueOf(id));
                    getCart().getTransport().add(itr);

                default:
                    break;

            }
        }
        else if (getMethod().equalsIgnoreCase("remove")) {
            getCart().setName("CART - REMOVE");
            switch(getType().toLowerCase()) {
                case "experience":
                    getCart().removeExperience(id);
                    break;
                case "room":
                    getCart().removeRoom(id);
                    break;
                case "restaurant":
                    getCart().removeRestaurant(id);
                    break;
                case "transport":
                    getCart().removeTransport(id);
                    break;
                default:
                    break;

            }
        }
        else if (getMethod().equalsIgnoreCase("create")) {
            getCart().createInvoice();
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

    private Result<? extends Record> fetchSingle(Table<? extends Record> table, String where) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            Result<? extends Record> result;
            SelectWhereStep<? extends Record> step = connection.getDSL().selectFrom(table);

            if (where.isEmpty()) {
                result = step.fetch();
            } else {
                result = step.where(where).fetch();
            }
            connection.close();

            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
