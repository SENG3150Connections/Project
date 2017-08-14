/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Resturantopeninghours;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class ResturantopeninghoursRecord extends UpdatableRecordImpl<ResturantopeninghoursRecord> implements Record7<UInteger, UInteger, Timestamp, Timestamp, Timestamp, Timestamp, UInteger> {

    private static final long serialVersionUID = -2012065879;

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.weekday</code>.
     */
    public void setWeekday(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.weekday</code>.
     */
    public UInteger getWeekday() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.openTime</code>.
     */
    public void setOpentime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.openTime</code>.
     */
    public Timestamp getOpentime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.closeTime</code>.
     */
    public void setClosetime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.closeTime</code>.
     */
    public Timestamp getClosetime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.pauseStartTime</code>.
     */
    public void setPausestarttime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.pauseStartTime</code>.
     */
    public Timestamp getPausestarttime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.pauseEndTime</code>.
     */
    public void setPauseendtime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.pauseEndTime</code>.
     */
    public Timestamp getPauseendtime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHours.restaurantId</code>.
     */
    public void setRestaurantid(UInteger value) {
        set(6, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHours.restaurantId</code>.
     */
    public UInteger getRestaurantid() {
        return (UInteger) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, UInteger, Timestamp, Timestamp, Timestamp, Timestamp, UInteger> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, UInteger, Timestamp, Timestamp, Timestamp, Timestamp, UInteger> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field2() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.WEEKDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.OPENTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.CLOSETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.PAUSESTARTTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.PAUSEENDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field7() {
        return Resturantopeninghours.RESTURANTOPENINGHOURS.RESTAURANTID;
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
    public UInteger value2() {
        return getWeekday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getOpentime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getClosetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getPausestarttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getPauseendtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value7() {
        return getRestaurantid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value2(UInteger value) {
        setWeekday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value3(Timestamp value) {
        setOpentime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value4(Timestamp value) {
        setClosetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value5(Timestamp value) {
        setPausestarttime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value6(Timestamp value) {
        setPauseendtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord value7(UInteger value) {
        setRestaurantid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursRecord values(UInteger value1, UInteger value2, Timestamp value3, Timestamp value4, Timestamp value5, Timestamp value6, UInteger value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ResturantopeninghoursRecord
     */
    public ResturantopeninghoursRecord() {
        super(Resturantopeninghours.RESTURANTOPENINGHOURS);
    }

    /**
     * Create a detached, initialised ResturantopeninghoursRecord
     */
    public ResturantopeninghoursRecord(UInteger id, UInteger weekday, Timestamp opentime, Timestamp closetime, Timestamp pausestarttime, Timestamp pauseendtime, UInteger restaurantid) {
        super(Resturantopeninghours.RESTURANTOPENINGHOURS);

        set(0, id);
        set(1, weekday);
        set(2, opentime);
        set(3, closetime);
        set(4, pausestarttime);
        set(5, pauseendtime);
        set(6, restaurantid);
    }
}
