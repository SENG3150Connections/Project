package NewcastleConnections.Actions.Cart;

import NewcastleConnections.Cart;
import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.Resturants;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;
import NewcastleConnections.packagedeals.tables.records.RoomofferingsRecord;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectWhereStep;
import org.jooq.Table;

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
                    ExperiencevoucherofferingsRecord e = fetchSingle(EXPERIENCEVOUCHEROFFERINGS, "id = " + id)
                            .get(0).into(ExperiencevoucherofferingsRecord.class);
                    getCart().getExperiences().add(e);
                    break;
                case "room":
                    RoomofferingsRecord r = fetchSingle(ROOMOFFERINGS, "id = " + id)
                            .get(0).into(RoomofferingsRecord.class);
                    getCart().getRooms().add(r);
                    break;
                case "restaurant":
                    ResturantsRecord re = fetchSingle(RESTURANTS, "id = " + id)
                            .get(0).into(ResturantsRecord.class);
                    getCart().getRestaurants().add(re);
                    break;
                default:
                    break;

            }
        }
        else if (getMethod().equalsIgnoreCase("remove")) {
            getCart().setName("CART - REMOVE");
            switch(getType().toLowerCase()) {
                case "experience":
                    ExperiencevoucherofferingsRecord e = fetchSingle(EXPERIENCEVOUCHEROFFERINGS, "id = " + id)
                            .get(0).into(ExperiencevoucherofferingsRecord.class);
                    getCart().getExperiences().remove(e);
                    break;
                case "room":
                    RoomofferingsRecord r = fetchSingle(ROOMOFFERINGS, "id = " + id)
                            .get(0).into(RoomofferingsRecord.class);
                    getCart().getRooms().remove(r);
                    break;
                case "restaurant":
                    ResturantsRecord re = fetchSingle(RESTURANTS, "id = " + id)
                            .get(0).into(ResturantsRecord.class);
                    getCart().getRestaurants().remove(re);
                    break;
                default:
                    break;

            }
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
