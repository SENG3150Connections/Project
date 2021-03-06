/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ResturantopeninghoursRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class Resturantopeninghours extends TableImpl<ResturantopeninghoursRecord> {

    private static final long serialVersionUID = -1889215634;

    /**
     * The reference instance of <code>PackageDeals.ResturantOpeningHours</code>
     */
    public static final Resturantopeninghours RESTURANTOPENINGHOURS = new Resturantopeninghours();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResturantopeninghoursRecord> getRecordType() {
        return ResturantopeninghoursRecord.class;
    }

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.id</code>.
     */
    public final TableField<ResturantopeninghoursRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.weekday</code>.
     */
    public final TableField<ResturantopeninghoursRecord, UInteger> WEEKDAY = createField("weekday", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.openTime</code>.
     */
    public final TableField<ResturantopeninghoursRecord, Timestamp> OPENTIME = createField("openTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.closeTime</code>.
     */
    public final TableField<ResturantopeninghoursRecord, Timestamp> CLOSETIME = createField("closeTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.pauseStartTime</code>.
     */
    public final TableField<ResturantopeninghoursRecord, Timestamp> PAUSESTARTTIME = createField("pauseStartTime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.pauseEndTime</code>.
     */
    public final TableField<ResturantopeninghoursRecord, Timestamp> PAUSEENDTIME = createField("pauseEndTime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHours.restaurantId</code>.
     */
    public final TableField<ResturantopeninghoursRecord, UInteger> RESTAURANTID = createField("restaurantId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.ResturantOpeningHours</code> table reference
     */
    public Resturantopeninghours() {
        this("ResturantOpeningHours", null);
    }

    /**
     * Create an aliased <code>PackageDeals.ResturantOpeningHours</code> table reference
     */
    public Resturantopeninghours(String alias) {
        this(alias, RESTURANTOPENINGHOURS);
    }

    private Resturantopeninghours(String alias, Table<ResturantopeninghoursRecord> aliased) {
        this(alias, aliased, null);
    }

    private Resturantopeninghours(String alias, Table<ResturantopeninghoursRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ResturantopeninghoursRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_RESTURANTOPENINGHOURS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResturantopeninghoursRecord> getPrimaryKey() {
        return Keys.KEY_RESTURANTOPENINGHOURS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResturantopeninghoursRecord>> getKeys() {
        return Arrays.<UniqueKey<ResturantopeninghoursRecord>>asList(Keys.KEY_RESTURANTOPENINGHOURS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ResturantopeninghoursRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ResturantopeninghoursRecord, ?>>asList(Keys.FK_RESTURANTOPENINGHOURS_WEEKDAY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resturantopeninghours as(String alias) {
        return new Resturantopeninghours(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Resturantopeninghours rename(String name) {
        return new Resturantopeninghours(name, null);
    }
}
