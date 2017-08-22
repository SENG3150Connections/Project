package NewcastleConnections.Cart;

import NewcastleConnections.DatabaseConnection;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;
import NewcastleConnections.packagedeals.tables.records.ExperiencevoucherofferingsRecord;
import NewcastleConnections.packagedeals.tables.records.InvoiceexperienceRecord;
import org.jooq.types.UInteger;

import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;

public class CartExperience {

    private ExperiencesRecord experience = null;
    private ExperiencevoucherofferingsRecord voucher = null;
    private InvoiceexperienceRecord invoice = null;

    public CartExperience(int expID) {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            experience = connection.getDSL().selectFrom(EXPERIENCES).where(EXPERIENCES.ID.eq(UInteger.valueOf(expID))).fetch().get(0);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isPrepared() {
        return voucher != null;
    }

    public InvoiceexperienceRecord getInvoice() {
        if (!isPrepared()) {
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
