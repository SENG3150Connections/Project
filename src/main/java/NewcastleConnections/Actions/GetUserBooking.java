package NewcastleConnections.Actions;

import NewcastleConnections.*;
import NewcastleConnections.InvoiceInfo.ExperienceInvoiceInfo;
import NewcastleConnections.InvoiceInfo.HotelInvoiceInfo;
import NewcastleConnections.InvoiceInfo.RestaurantInvoiceInfo;
import NewcastleConnections.InvoiceInfo.TransportInvoiceInfo;
import NewcastleConnections.packagedeals.tables.records.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.Result;
import org.jooq.types.UInteger;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static NewcastleConnections.packagedeals.Tables.*;

/**
 * Created by Jack on 22/08/2017.
 */
public class GetUserBooking extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private InvoicesRecord invoice;
    private List<HotelInvoiceInfo> hotels;
    private List<ExperienceInvoiceInfo> experiences;
    private List<RestaurantInvoiceInfo> restaurants;
    private List<TransportInvoiceInfo> transports;

    public InvoicesRecord getInvoice() {
        return invoice;
    }

    public List<HotelInvoiceInfo> getHotels() {
        return hotels;
    }

    public List<ExperienceInvoiceInfo> getExperiences() {
        return experiences;
    }

    public List<RestaurantInvoiceInfo> getRestaurants() {
        return restaurants;
    }

    public List<TransportInvoiceInfo> getTransports() {
        return transports;
    }

    @Override
    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();

            String invoiceID = request.getParameter("invoiceID");

            // Get connection
            DatabaseConnection connection = new DatabaseConnection();
            // query
            invoice = connection.getDSL().selectFrom(INVOICES).where(INVOICES.ID.eq(UInteger.valueOf(invoiceID))).fetchOne();
            Result<InvoiceexperienceRecord> invoiceexperiences = connection.getDSL().selectFrom(INVOICEEXPERIENCE).where(INVOICEEXPERIENCE.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();
            Result<InvoicehotelRecord> invoicehotels = connection.getDSL().selectFrom(INVOICEHOTEL).where(INVOICEHOTEL.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();
            Result<InvoicerestaurantRecord> invoicerestaurants = connection.getDSL().selectFrom(INVOICERESTAURANT).where(INVOICERESTAURANT.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();
            Result<InvoicetransportRecord> invoicetransports = connection.getDSL().selectFrom(INVOICETRANSPORT).where(INVOICETRANSPORT.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();

            hotels = new ArrayList<>();
            for (InvoicehotelRecord x: invoicehotels) {
                HotelInvoiceInfo newHotel = new HotelInvoiceInfo();

                RoomofferingsRecord roomoffering = connection.getDSL().selectFrom(ROOMOFFERINGS).where(ROOMOFFERINGS.ID.eq(x.getRoomid())).fetchOne();
                RoomtypesRecord roomtype = connection.getDSL().selectFrom(ROOMTYPES).where(ROOMTYPES.ID.eq(roomoffering.getRoomtypeid())).fetchOne();
                HotelsRecord hotel = connection.getDSL().selectFrom(HOTELS).where(HOTELS.ID.eq(roomoffering.getHotelid())).fetchOne();

                newHotel.setRoomID(x.getRoomid());
                newHotel.setAdults(x.getAdults());
                newHotel.setChildren(x.getChildren());
                newHotel.setCheckIn(x.getCheckin());
                newHotel.setCheckOut(x.getCheckout());
                newHotel.setHotelPrice(x.getPrice());
                newHotel.setHotelID(roomoffering.getHotelid());
                newHotel.setRoomTypeID(roomoffering.getRoomtypeid());
                newHotel.setRoomType(roomtype.getName());
                newHotel.setHotelName(hotel.getName());
                newHotel.setHotelContact(hotel.getContact());
                newHotel.setHotelAddress(hotel.getAddress());
                newHotel.setHotelImageID(hotel.getImageid());

                hotels.add(newHotel);
            }

            experiences = new ArrayList<>();
            for (InvoiceexperienceRecord x: invoiceexperiences) {
                ExperienceInvoiceInfo newExperience = new ExperienceInvoiceInfo();

                ExperiencesRecord experience = connection.getDSL().selectFrom(EXPERIENCES).where(EXPERIENCES.ID.eq(x.getExperiencevoucherid())).fetchOne();

                newExperience.setExperienceID(x.getExperiencevoucherid());
                newExperience.setPrice(x.getPrice());
                newExperience.setName(experience.getName());
                newExperience.setLocation(experience.getLocation());
                newExperience.setImageID(experience.getImageid());

                experiences.add(newExperience);
            }

            restaurants = new ArrayList<>();
            for (InvoicerestaurantRecord x: invoicerestaurants) {
                RestaurantInvoiceInfo newRestaurant = new RestaurantInvoiceInfo();

                ResturantsRecord restaurant = connection.getDSL().selectFrom(RESTURANTS).where(RESTURANTS.ID.eq(x.getRestaurantid())).fetchOne();

                newRestaurant.setRestaurantID(x.getRestaurantid());
                newRestaurant.setRestaurantTime(x.getTime());
                newRestaurant.setRestaurantSeats(x.getSeats());
                newRestaurant.setRestaurantPrice(x.getVoucherprice());
                newRestaurant.setRestaurantName(restaurant.getName());
                newRestaurant.setRestaurantContact(restaurant.getContact());
                newRestaurant.setRestaurantAddress(restaurant.getAddress());
                newRestaurant.setRestaurantImageID(restaurant.getImageid());

                restaurants.add(newRestaurant);

            }

            transports = new ArrayList<>();
            for (InvoicetransportRecord x: invoicetransports) {
                TransportInvoiceInfo newTransport = new TransportInvoiceInfo();

                TransportRecord transport = connection.getDSL().selectFrom(TRANSPORT).where(TRANSPORT.ID.eq(x.getTransportid())).fetchOne();

                newTransport.setTransportID(x.getTransportid());
                newTransport.setTransportTime(x.getTime());
                newTransport.setTransportName(transport.getName());
                newTransport.setTransportPrice(transport.getTicketprice());

                transports.add(newTransport);
            }

            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

}
