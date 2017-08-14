/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ResturantreservationofferingoverridesRecord;

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
public class Resturantreservationofferingoverrides extends TableImpl<ResturantreservationofferingoverridesRecord> {

    private static final long serialVersionUID = -1497982241;

    /**
     * The reference instance of <code>PackageDeals.ResturantReservationOfferingOverrides</code>
     */
    public static final Resturantreservationofferingoverrides RESTURANTRESERVATIONOFFERINGOVERRIDES = new Resturantreservationofferingoverrides();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResturantreservationofferingoverridesRecord> getRecordType() {
        return ResturantreservationofferingoverridesRecord.class;
    }

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.id</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.date</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.tableCapacity</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, UInteger> TABLECAPACITY = createField("tableCapacity", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.quantity</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, UInteger> QUANTITY = createField("quantity", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.timeStart</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, Timestamp> TIMESTART = createField("timeStart", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.timeEnd</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, Timestamp> TIMEEND = createField("timeEnd", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.info</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, String> INFO = createField("info", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferingOverrides.resturantId</code>.
     */
    public final TableField<ResturantreservationofferingoverridesRecord, UInteger> RESTURANTID = createField("resturantId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.ResturantReservationOfferingOverrides</code> table reference
     */
    public Resturantreservationofferingoverrides() {
        this("ResturantReservationOfferingOverrides", null);
    }

    /**
     * Create an aliased <code>PackageDeals.ResturantReservationOfferingOverrides</code> table reference
     */
    public Resturantreservationofferingoverrides(String alias) {
        this(alias, RESTURANTRESERVATIONOFFERINGOVERRIDES);
    }

    private Resturantreservationofferingoverrides(String alias, Table<ResturantreservationofferingoverridesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Resturantreservationofferingoverrides(String alias, Table<ResturantreservationofferingoverridesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ResturantreservationofferingoverridesRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_RESTURANTRESERVATIONOFFERINGOVERRIDES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResturantreservationofferingoverridesRecord> getPrimaryKey() {
        return Keys.KEY_RESTURANTRESERVATIONOFFERINGOVERRIDES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResturantreservationofferingoverridesRecord>> getKeys() {
        return Arrays.<UniqueKey<ResturantreservationofferingoverridesRecord>>asList(Keys.KEY_RESTURANTRESERVATIONOFFERINGOVERRIDES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ResturantreservationofferingoverridesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ResturantreservationofferingoverridesRecord, ?>>asList(Keys.FK_RESTURANTRESERVATIONOFFERINGOVERRIDES_RESTURANTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resturantreservationofferingoverrides as(String alias) {
        return new Resturantreservationofferingoverrides(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Resturantreservationofferingoverrides rename(String name) {
        return new Resturantreservationofferingoverrides(name, null);
    }
}
