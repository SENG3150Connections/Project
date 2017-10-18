package NewcastleConnections.Cart;

/*
CartExperience.java
Author: Scott Walker

Description:
    The cart item to store Experiences.
*/

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.InvoiceexperienceRecord;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

public class CartExperience implements CartItem {

    // Private member data
    private ExperiencesRecord experience = null;
    private ExperiencevoucherofferingsRecord voucher = null;
    private InvoiceexperienceRecord invoice = null;

    // -- Constructor --
    //   Role: Initialise the CartExperience of certain ID.
    //
    public CartExperience(int expID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            Result<ExperiencesRecord> records = connection.getDSL().selectFrom(EXPERIENCES).where(EXPERIENCES.ID.eq(UInteger.valueOf(expID))).fetch();
            if (records.size() > 0)
                experience = records.get(0);
            else
                experience = null;

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // -- Interface methods --

    public String getName() {
        return experience.getName();
    }

    public int getId() {
        return experience.getId().intValue();
    }

    public boolean getReady() {
        // Must have a voucher to be complete.
        return voucher != null;
    }

    public double getPrice() {
        return getVoucher().getPrice();
    }

    // -- Other methods --

    // -- Public --
    //   Role: Get the invoice for this cart item.
    //
    public InvoiceexperienceRecord getInvoice() {
        if (!getReady()) {
            return null;
        }

        if (invoice == null) {
            invoice = new InvoiceexperienceRecord();
        }

        invoice.setExperiencevoucherid(voucher.getId());
        invoice.setPrice(voucher.getPrice());

        return invoice;
    }

    // -- Getters and Setters --

    public ExperiencesRecord getExperience() {
        return experience;
    }

    public void setExperience(ExperiencesRecord experience) {
        this.experience = experience;
    }

    public ExperiencevoucherofferingsRecord getVoucher() {
        return voucher;
    }

    public void setVoucher(ExperiencevoucherofferingsRecord voucher) {
        this.voucher = voucher;
    }
}
