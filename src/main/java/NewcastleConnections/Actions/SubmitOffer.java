package NewcastleConnections.Actions;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import com.opensymphony.xwork2.ActionSupport;

import javax.naming.NamingException;
import java.sql.Date;
import java.sql.SQLException;


/**
 * Created by Harry on 12/8/17.
 */
public class SubmitOffer extends ActionSupport {
    private String name = "";
    private String contact = "";
    private String email = "";
    private String address = "";
    private String website = "";
    private String description = "";
    private double latitude = 0.0;
    private double longitude = 0.0;
    private byte publicallyvisible = (byte)0;
    private byte releaseondate = (byte)0;
    private Date releasedate = new Date(2017, 1, 1);
    private String imageid = "";
    private String category = "";

    @Override
    public String execute() {
        HotelsRecord hotel = new HotelsRecord();

        try {
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            connection.getDSL().attach(hotel);

            // query
            hotel.setName(name);
            hotel.setContact("Harry");
            hotel.setEmail(email);
            hotel.setAddress(address);
            hotel.setWebsite(website);
            hotel.setDescription(description);
            hotel.setLatitude(latitude);
            hotel.setLongitude(longitude);
            hotel.setPublicallyvisible(publicallyvisible);
            hotel.setReleaseondate(releaseondate);
            hotel.setReleasedate(releasedate);
            hotel.setImageid(imageid);
            hotel.setCategory(category);
            hotel.store();

            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPublicallyvisible(byte publicallyvisible) {
        this.publicallyvisible = publicallyvisible;
    }

    public void setReleaseondate(byte releaseondate) {
        this.releaseondate = releaseondate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
