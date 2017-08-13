/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ResturantopeninghoursoverridesRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Resturantopeninghoursoverrides extends TableImpl<ResturantopeninghoursoverridesRecord> {

    private static final long serialVersionUID = -526154800;

    /**
     * The reference instance of <code>PackageDeals.ResturantOpeningHoursOverrides</code>
     */
    public static final Resturantopeninghoursoverrides RESTURANTOPENINGHOURSOVERRIDES = new Resturantopeninghoursoverrides();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResturantopeninghoursoverridesRecord> getRecordType() {
        return ResturantopeninghoursoverridesRecord.class;
    }

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.id</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.date</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.openTime</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, Timestamp> OPENTIME = createField("openTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.closeTime</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, Timestamp> CLOSETIME = createField("closeTime", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.pauseStartTime</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, Timestamp> PAUSESTARTTIME = createField("pauseStartTime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.pauseEndTime</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, Timestamp> PAUSEENDTIME = createField("pauseEndTime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>PackageDeals.ResturantOpeningHoursOverrides.resturantId</code>.
     */
    public final TableField<ResturantopeninghoursoverridesRecord, UInteger> RESTURANTID = createField("resturantId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.ResturantOpeningHoursOverrides</code> table reference
     */
    public Resturantopeninghoursoverrides() {
        this("ResturantOpeningHoursOverrides", null);
    }

    /**
     * Create an aliased <code>PackageDeals.ResturantOpeningHoursOverrides</code> table reference
     */
    public Resturantopeninghoursoverrides(String alias) {
        this(alias, RESTURANTOPENINGHOURSOVERRIDES);
    }

    private Resturantopeninghoursoverrides(String alias, Table<ResturantopeninghoursoverridesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Resturantopeninghoursoverrides(String alias, Table<ResturantopeninghoursoverridesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ResturantopeninghoursoverridesRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_RESTURANTOPENINGHOURSOVERRIDES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResturantopeninghoursoverridesRecord> getPrimaryKey() {
        return Keys.KEY_RESTURANTOPENINGHOURSOVERRIDES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResturantopeninghoursoverridesRecord>> getKeys() {
        return Arrays.<UniqueKey<ResturantopeninghoursoverridesRecord>>asList(Keys.KEY_RESTURANTOPENINGHOURSOVERRIDES_PRIMARY, Keys.KEY_RESTURANTOPENINGHOURSOVERRIDES_UQ_RESTURANTID_DATE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resturantopeninghoursoverrides as(String alias) {
        return new Resturantopeninghoursoverrides(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Resturantopeninghoursoverrides rename(String name) {
        return new Resturantopeninghoursoverrides(name, null);
    }
}
