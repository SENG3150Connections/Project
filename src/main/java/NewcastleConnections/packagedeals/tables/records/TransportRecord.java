/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Transport;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class TransportRecord extends UpdatableRecordImpl<TransportRecord> implements Record9<UInteger, String, Double, Byte, String, Double, Double, Double, Double> {

    private static final long serialVersionUID = 1862757494;

    /**
     * Setter for <code>PackageDeals.Transport.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.Transport.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PackageDeals.Transport.ticketPrice</code>.
     */
    public void setTicketprice(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.ticketPrice</code>.
     */
    public Double getTicketprice() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>PackageDeals.Transport.return</code>.
     */
    public void setReturn(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.return</code>.
     */
    public Byte getReturn() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>PackageDeals.Transport.description</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>PackageDeals.Transport.destinationLongitude</code>.
     */
    public void setDestinationlongitude(Double value) {
        set(5, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.destinationLongitude</code>.
     */
    public Double getDestinationlongitude() {
        return (Double) get(5);
    }

    /**
     * Setter for <code>PackageDeals.Transport.destinationLattitude</code>.
     */
    public void setDestinationlattitude(Double value) {
        set(6, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.destinationLattitude</code>.
     */
    public Double getDestinationlattitude() {
        return (Double) get(6);
    }

    /**
     * Setter for <code>PackageDeals.Transport.startLongitude</code>.
     */
    public void setStartlongitude(Double value) {
        set(7, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.startLongitude</code>.
     */
    public Double getStartlongitude() {
        return (Double) get(7);
    }

    /**
     * Setter for <code>PackageDeals.Transport.startLattitude</code>.
     */
    public void setStartlattitude(Double value) {
        set(8, value);
    }

    /**
     * Getter for <code>PackageDeals.Transport.startLattitude</code>.
     */
    public Double getStartlattitude() {
        return (Double) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<UInteger, String, Double, Byte, String, Double, Double, Double, Double> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<UInteger, String, Double, Byte, String, Double, Double, Double, Double> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Transport.TRANSPORT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Transport.TRANSPORT.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field3() {
        return Transport.TRANSPORT.TICKETPRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Transport.TRANSPORT.RETURN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Transport.TRANSPORT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field6() {
        return Transport.TRANSPORT.DESTINATIONLONGITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field7() {
        return Transport.TRANSPORT.DESTINATIONLATTITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field8() {
        return Transport.TRANSPORT.STARTLONGITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field9() {
        return Transport.TRANSPORT.STARTLATTITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value3() {
        return getTicketprice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getReturn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value6() {
        return getDestinationlongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value7() {
        return getDestinationlattitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value8() {
        return getStartlongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value9() {
        return getStartlattitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value3(Double value) {
        setTicketprice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value4(Byte value) {
        setReturn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value5(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value6(Double value) {
        setDestinationlongitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value7(Double value) {
        setDestinationlattitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value8(Double value) {
        setStartlongitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord value9(Double value) {
        setStartlattitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportRecord values(UInteger value1, String value2, Double value3, Byte value4, String value5, Double value6, Double value7, Double value8, Double value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TransportRecord
     */
    public TransportRecord() {
        super(Transport.TRANSPORT);
    }

    /**
     * Create a detached, initialised TransportRecord
     */
    public TransportRecord(UInteger id, String name, Double ticketprice, Byte return_, String description, Double destinationlongitude, Double destinationlattitude, Double startlongitude, Double startlattitude) {
        super(Transport.TRANSPORT);

        set(0, id);
        set(1, name);
        set(2, ticketprice);
        set(3, return_);
        set(4, description);
        set(5, destinationlongitude);
        set(6, destinationlattitude);
        set(7, startlongitude);
        set(8, startlattitude);
    }
}
