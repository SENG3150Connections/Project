/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Resturantreservationofferingoverrides;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class ResturantreservationofferingoverridesRecord extends UpdatableRecordImpl<ResturantreservationofferingoverridesRecord> implements Record8<UInteger, Timestamp, UInteger, UInteger, Timestamp, Timestamp, String, UInteger> {

    private static final long serialVersionUID = -796856367;

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.date</code>.
     */
    public void setDate(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.date</code>.
     */
    public Timestamp getDate() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.tableCapacity</code>.
     */
    public void setTablecapacity(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.tableCapacity</code>.
     */
    public UInteger getTablecapacity() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.quantity</code>.
     */
    public void setQuantity(UInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.quantity</code>.
     */
    public UInteger getQuantity() {
        return (UInteger) get(3);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.timeStart</code>.
     */
    public void setTimestart(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.timeStart</code>.
     */
    public Timestamp getTimestart() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.timeEnd</code>.
     */
    public void setTimeend(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.timeEnd</code>.
     */
    public Timestamp getTimeend() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.info</code>.
     */
    public void setInfo(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.info</code>.
     */
    public String getInfo() {
        return (String) get(6);
    }

    /**
     * Setter for <code>PackageDeals.ResturantReservationOfferingOverrides.resturantId</code>.
     */
    public void setResturantid(UInteger value) {
        set(7, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantReservationOfferingOverrides.resturantId</code>.
     */
    public UInteger getResturantid() {
        return (UInteger) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, Timestamp, UInteger, UInteger, Timestamp, Timestamp, String, UInteger> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, Timestamp, UInteger, UInteger, Timestamp, Timestamp, String, UInteger> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.TABLECAPACITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field4() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.QUANTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.TIMESTART;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.TIMEEND;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.INFO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field8() {
        return Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES.RESTURANTID;
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
    public Timestamp value2() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getTablecapacity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value4() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getTimestart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getTimeend();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getInfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value8() {
        return getResturantid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value2(Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value3(UInteger value) {
        setTablecapacity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value4(UInteger value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value5(Timestamp value) {
        setTimestart(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value6(Timestamp value) {
        setTimeend(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value7(String value) {
        setInfo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord value8(UInteger value) {
        setResturantid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantreservationofferingoverridesRecord values(UInteger value1, Timestamp value2, UInteger value3, UInteger value4, Timestamp value5, Timestamp value6, String value7, UInteger value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ResturantreservationofferingoverridesRecord
     */
    public ResturantreservationofferingoverridesRecord() {
        super(Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES);
    }

    /**
     * Create a detached, initialised ResturantreservationofferingoverridesRecord
     */
    public ResturantreservationofferingoverridesRecord(UInteger id, Timestamp date, UInteger tablecapacity, UInteger quantity, Timestamp timestart, Timestamp timeend, String info, UInteger resturantid) {
        super(Resturantreservationofferingoverrides.RESTURANTRESERVATIONOFFERINGOVERRIDES);

        set(0, id);
        set(1, date);
        set(2, tablecapacity);
        set(3, quantity);
        set(4, timestart);
        set(5, timeend);
        set(6, info);
        set(7, resturantid);
    }
}
