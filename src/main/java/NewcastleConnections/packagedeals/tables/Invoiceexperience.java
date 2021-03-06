/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.InvoiceexperienceRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Invoiceexperience extends TableImpl<InvoiceexperienceRecord> {

    private static final long serialVersionUID = -1909033767;

    /**
     * The reference instance of <code>PackageDeals.InvoiceExperience</code>
     */
    public static final Invoiceexperience INVOICEEXPERIENCE = new Invoiceexperience();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InvoiceexperienceRecord> getRecordType() {
        return InvoiceexperienceRecord.class;
    }

    /**
     * The column <code>PackageDeals.InvoiceExperience.invoiceId</code>.
     */
    public final TableField<InvoiceexperienceRecord, UInteger> INVOICEID = createField("invoiceId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.InvoiceExperience.experienceVoucherId</code>.
     */
    public final TableField<InvoiceexperienceRecord, UInteger> EXPERIENCEVOUCHERID = createField("experienceVoucherId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.InvoiceExperience.price</code>.
     */
    public final TableField<InvoiceexperienceRecord, Double> PRICE = createField("price", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.InvoiceExperience</code> table reference
     */
    public Invoiceexperience() {
        this("InvoiceExperience", null);
    }

    /**
     * Create an aliased <code>PackageDeals.InvoiceExperience</code> table reference
     */
    public Invoiceexperience(String alias) {
        this(alias, INVOICEEXPERIENCE);
    }

    private Invoiceexperience(String alias, Table<InvoiceexperienceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Invoiceexperience(String alias, Table<InvoiceexperienceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Packagedeals.PACKAGEDEALS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<InvoiceexperienceRecord> getPrimaryKey() {
        return Keys.KEY_INVOICEEXPERIENCE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<InvoiceexperienceRecord>> getKeys() {
        return Arrays.<UniqueKey<InvoiceexperienceRecord>>asList(Keys.KEY_INVOICEEXPERIENCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<InvoiceexperienceRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<InvoiceexperienceRecord, ?>>asList(Keys.IEINVOICE, Keys.IEVOUCHER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Invoiceexperience as(String alias) {
        return new Invoiceexperience(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Invoiceexperience rename(String name) {
        return new Invoiceexperience(name, null);
    }
}
