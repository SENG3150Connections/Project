/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Invoicehotel;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
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
public class InvoicehotelRecord extends UpdatableRecordImpl<InvoicehotelRecord> implements Record2<UInteger, UInteger> {

    private static final long serialVersionUID = 1313448186;

    /**
     * Setter for <code>PackageDeals.InvoiceHotel.invoiceId</code>.
     */
    public void setInvoiceid(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.InvoiceHotel.invoiceId</code>.
     */
    public UInteger getInvoiceid() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.InvoiceHotel.hotelId</code>.
     */
    public void setHotelid(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.InvoiceHotel.hotelId</code>.
     */
    public UInteger getHotelid() {
        return (UInteger) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<UInteger, UInteger> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UInteger, UInteger> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<UInteger, UInteger> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Invoicehotel.INVOICEHOTEL.INVOICEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field2() {
        return Invoicehotel.INVOICEHOTEL.HOTELID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getInvoiceid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value2() {
        return getHotelid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicehotelRecord value1(UInteger value) {
        setInvoiceid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicehotelRecord value2(UInteger value) {
        setHotelid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicehotelRecord values(UInteger value1, UInteger value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InvoicehotelRecord
     */
    public InvoicehotelRecord() {
        super(Invoicehotel.INVOICEHOTEL);
    }

    /**
     * Create a detached, initialised InvoicehotelRecord
     */
    public InvoicehotelRecord(UInteger invoiceid, UInteger hotelid) {
        super(Invoicehotel.INVOICEHOTEL);

        set(0, invoiceid);
        set(1, hotelid);
    }
}
