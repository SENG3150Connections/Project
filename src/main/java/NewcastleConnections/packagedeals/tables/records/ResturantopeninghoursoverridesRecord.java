/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Resturantopeninghoursoverrides;

import java.sql.Date;
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
public class ResturantopeninghoursoverridesRecord extends UpdatableRecordImpl<ResturantopeninghoursoverridesRecord> implements Record7<UInteger, Date, Timestamp, Timestamp, Timestamp, Timestamp, UInteger> {

    private static final long serialVersionUID = 570092946;

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.date</code>.
     */
    public void setDate(Date value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.date</code>.
     */
    public Date getDate() {
        return (Date) get(1);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.openTime</code>.
     */
    public void setOpentime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.openTime</code>.
     */
    public Timestamp getOpentime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.closeTime</code>.
     */
    public void setClosetime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.closeTime</code>.
     */
    public Timestamp getClosetime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.pauseStartTime</code>.
     */
    public void setPausestarttime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.pauseStartTime</code>.
     */
    public Timestamp getPausestarttime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.pauseEndTime</code>.
     */
    public void setPauseendtime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.pauseEndTime</code>.
     */
    public Timestamp getPauseendtime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>PackageDeals.ResturantOpeningHoursOverrides.resturantId</code>.
     */
    public void setResturantid(UInteger value) {
        set(6, value);
    }

    /**
     * Getter for <code>PackageDeals.ResturantOpeningHoursOverrides.resturantId</code>.
     */
    public UInteger getResturantid() {
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
    public Row7<UInteger, Date, Timestamp, Timestamp, Timestamp, Timestamp, UInteger> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, Date, Timestamp, Timestamp, Timestamp, Timestamp, UInteger> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field2() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.OPENTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.CLOSETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.PAUSESTARTTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.PAUSEENDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field7() {
        return Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES.RESTURANTID;
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
    public Date value2() {
        return getDate();
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
        return getResturantid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value2(Date value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value3(Timestamp value) {
        setOpentime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value4(Timestamp value) {
        setClosetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value5(Timestamp value) {
        setPausestarttime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value6(Timestamp value) {
        setPauseendtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord value7(UInteger value) {
        setResturantid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantopeninghoursoverridesRecord values(UInteger value1, Date value2, Timestamp value3, Timestamp value4, Timestamp value5, Timestamp value6, UInteger value7) {
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
     * Create a detached ResturantopeninghoursoverridesRecord
     */
    public ResturantopeninghoursoverridesRecord() {
        super(Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES);
    }

    /**
     * Create a detached, initialised ResturantopeninghoursoverridesRecord
     */
    public ResturantopeninghoursoverridesRecord(UInteger id, Date date, Timestamp opentime, Timestamp closetime, Timestamp pausestarttime, Timestamp pauseendtime, UInteger resturantid) {
        super(Resturantopeninghoursoverrides.RESTURANTOPENINGHOURSOVERRIDES);

        set(0, id);
        set(1, date);
        set(2, opentime);
        set(3, closetime);
        set(4, pausestarttime);
        set(5, pauseendtime);
        set(6, resturantid);
    }
}
