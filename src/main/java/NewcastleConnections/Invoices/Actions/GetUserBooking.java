package NewcastleConnections.Invoices.Actions;

/*
GetUserBooking.java
Author: Jack Ratcliffe / Scott Walker

Description:
    Get information about a particular booking.
*/

import NewcastleConnections.*;
import NewcastleConnections.Invoices.*;
import NewcastleConnections.packagedeals.tables.records.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.types.UInteger;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static NewcastleConnections.packagedeals.Tables.*;

public class GetUserBooking extends ActionSupport {

    // Results property (to be shared with the JSP page)
    private InvoiceInfo invoice;
    private List<HotelInvoiceInfo> hotels;
    private List<ExperienceInvoiceInfo> experiences;
    private List<RestaurantInvoiceInfo> restaurants;
    private List<TransportInvoiceInfo> transports;

    // -- Public --
    //   Role: Method that is executed when the page is requested.
    //
    @Override
    public String execute() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();

            String invoiceID = request.getParameter("invoiceID");
            // Get connection
            DatabaseConnection connection = new DatabaseConnection();

            // query
            DSLContext dsl = connection.getDSL();
            InvoicesRecord invoicesRecord = dsl.selectFrom(INVOICES).where(INVOICES.ID.eq(UInteger.valueOf(invoiceID))).fetchOne();
            Result<InvoiceexperienceRecord> invoiceexperiences = dsl.selectFrom(INVOICEEXPERIENCE).where(INVOICEEXPERIENCE.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();
            Result<InvoicehotelRecord> invoicehotels = dsl.selectFrom(INVOICEHOTEL).where(INVOICEHOTEL.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();
            Result<InvoicerestaurantRecord> invoicerestaurants = dsl.selectFrom(INVOICERESTAURANT).where(INVOICERESTAURANT.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();
            Result<InvoicetransportRecord> invoicetransports = dsl.selectFrom(INVOICETRANSPORT).where(INVOICETRANSPORT.INVOICEID.eq(UInteger.valueOf(invoiceID))).fetch();

            invoice = new InvoiceInfo();
            invoice.setId(invoicesRecord.getId());
            invoice.setPrice(invoicesRecord.getPrice());
            invoice.setStatus(invoicesRecord.getStatus());
            invoice.setPurchasedate(invoicesRecord.getPurchasedate());

            // Make classes for sub-items of the invoice
            makeExperiences(dsl, invoiceexperiences);
            makeHotels(dsl, invoicehotels);
            makeRestaurants(dsl, invoicerestaurants);
            makeTransport(dsl, invoicetransports);

            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        }

        // Return Success
        return SUCCESS;
    }

    // -- Public --
    //   Role: Generate InvoiceInfo classes from records.
    //
    private void makeExperiences(DSLContext dsl, Result<InvoiceexperienceRecord> invoiceexperiences) {
        experiences = new ArrayList<>();
        for (InvoiceexperienceRecord x : invoiceexperiences) {
            ExperienceInvoiceInfo newExperience = new ExperienceInvoiceInfo();

            ExperiencesRecord experience = dsl.selectFrom(EXPERIENCES).where(EXPERIENCES.ID.eq(x.getExperiencevoucherid())).fetchOne();

            newExperience.setExperienceID(x.getExperiencevoucherid());
            newExperience.setPrice(x.getPrice());
            newExperience.setName(experience.getName());
            newExperience.setLocation(experience.getLocation());
            newExperience.setImageID(experience.getImageid());

            experiences.add(newExperience);
        }
    }

    // -- Public --
    //   Role: Generate InvoiceInfo classes from records.
    //
    private void makeHotels(DSLContext dsl, Result<InvoicehotelRecord> invoicehotels) {
        hotels = new ArrayList<>();
        for (InvoicehotelRecord x : invoicehotels) {
            HotelInvoiceInfo newHotel = new HotelInvoiceInfo();

            RoomofferingsRecord roomoffering = dsl.selectFrom(ROOMOFFERINGS).where(ROOMOFFERINGS.ID.eq(x.getRoomid())).fetchOne();
            RoomtypesRecord roomtype = dsl.selectFrom(ROOMTYPES).where(ROOMTYPES.ID.eq(roomoffering.getRoomtypeid())).fetchOne();
            HotelsRecord hotel = dsl.selectFrom(HOTELS).where(HOTELS.ID.eq(roomoffering.getHotelid())).fetchOne();

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
    }

    // -- Public --
    //   Role: Generate InvoiceInfo classes from records.
    //
    private void makeRestaurants(DSLContext dsl, Result<InvoicerestaurantRecord> invoicerestaurants) {
        restaurants = new ArrayList<>();
        for (InvoicerestaurantRecord x : invoicerestaurants) {
            RestaurantInvoiceInfo newRestaurant = new RestaurantInvoiceInfo();

            ResturantsRecord restaurant = dsl.selectFrom(RESTURANTS).where(RESTURANTS.ID.eq(x.getRestaurantid())).fetchOne();

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
    }

    // -- Public --
    //   Role: Generate InvoiceInfo classes from records.
    //
    private void makeTransport(DSLContext dsl, Result<InvoicetransportRecord> invoicetransports) {
        transports = new ArrayList<>();
        for (InvoicetransportRecord x : invoicetransports) {
            TransportInvoiceInfo newTransport = new TransportInvoiceInfo();

            TransportRecord transport = dsl.selectFrom(TRANSPORT).where(TRANSPORT.ID.eq(x.getTransportid())).fetchOne();

            newTransport.setTransportID(x.getTransportid());
            newTransport.setTransportTime(x.getTime());
            newTransport.setTransportName(transport.getName());
            newTransport.setTransportPrice(transport.getTicketprice());

            transports.add(newTransport);
        }
    }

    // -- Getters and Setters --

    public InvoiceInfo getInvoice() {
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
}
