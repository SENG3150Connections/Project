/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Invoicetransport;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class InvoicetransportRecord extends UpdatableRecordImpl<InvoicetransportRecord> implements Record4<UInteger, UInteger, Timestamp, Double> {

    private static final long serialVersionUID = -627635691;

    /**
     * Setter for <code>PackageDeals.InvoiceTransport.invoiceId</code>.
     */
    public void setInvoiceid(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.InvoiceTransport.invoiceId</code>.
     */
    public UInteger getInvoiceid() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.InvoiceTransport.transportId</code>.
     */
    public void setTransportid(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.InvoiceTransport.transportId</code>.
     */
    public UInteger getTransportid() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>PackageDeals.InvoiceTransport.time</code>.
     */
    public void setTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.InvoiceTransport.time</code>.
     */
    public Timestamp getTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>PackageDeals.InvoiceTransport.price</code>.
     */
    public void setPrice(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.InvoiceTransport.price</code>.
     */
    public Double getPrice() {
        return (Double) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<UInteger, UInteger, Timestamp, Double> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<UInteger, UInteger, Timestamp, Double> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Invoicetransport.INVOICETRANSPORT.INVOICEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field2() {
        return Invoicetransport.INVOICETRANSPORT.TRANSPORTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Invoicetransport.INVOICETRANSPORT.TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return Invoicetransport.INVOICETRANSPORT.PRICE;
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
        return getTransportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicetransportRecord value1(UInteger value) {
        setInvoiceid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicetransportRecord value2(UInteger value) {
        setTransportid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicetransportRecord value3(Timestamp value) {
        setTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicetransportRecord value4(Double value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvoicetransportRecord values(UInteger value1, UInteger value2, Timestamp value3, Double value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InvoicetransportRecord
     */
    public InvoicetransportRecord() {
        super(Invoicetransport.INVOICETRANSPORT);
    }

    /**
     * Create a detached, initialised InvoicetransportRecord
     */
    public InvoicetransportRecord(UInteger invoiceid, UInteger transportid, Timestamp time, Double price) {
        super(Invoicetransport.INVOICETRANSPORT);

        set(0, invoiceid);
        set(1, transportid);
        set(2, time);
        set(3, price);
    }
}
