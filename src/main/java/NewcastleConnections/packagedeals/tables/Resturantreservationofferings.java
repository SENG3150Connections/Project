/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ResturantreservationofferingsRecord;

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
public class Resturantreservationofferings extends TableImpl<ResturantreservationofferingsRecord> {

    private static final long serialVersionUID = 2084439751;

    /**
     * The reference instance of <code>PackageDeals.ResturantReservationOfferings</code>
     */
    public static final Resturantreservationofferings RESTURANTRESERVATIONOFFERINGS = new Resturantreservationofferings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResturantreservationofferingsRecord> getRecordType() {
        return ResturantreservationofferingsRecord.class;
    }

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.id</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.weekday</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, UInteger> WEEKDAY = createField("weekday", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.tableCapacity</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, UInteger> TABLECAPACITY = createField("tableCapacity", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.quantity</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, UInteger> QUANTITY = createField("quantity", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.timeStart</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, Timestamp> TIMESTART = createField("timeStart", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.timeEnd</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, Timestamp> TIMEEND = createField("timeEnd", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.info</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, String> INFO = createField("info", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ResturantReservationOfferings.resturantId</code>.
     */
    public final TableField<ResturantreservationofferingsRecord, UInteger> RESTURANTID = createField("resturantId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.ResturantReservationOfferings</code> table reference
     */
    public Resturantreservationofferings() {
        this("ResturantReservationOfferings", null);
    }

    /**
     * Create an aliased <code>PackageDeals.ResturantReservationOfferings</code> table reference
     */
    public Resturantreservationofferings(String alias) {
        this(alias, RESTURANTRESERVATIONOFFERINGS);
    }

    private Resturantreservationofferings(String alias, Table<ResturantreservationofferingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Resturantreservationofferings(String alias, Table<ResturantreservationofferingsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ResturantreservationofferingsRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_RESTURANTRESERVATIONOFFERINGS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResturantreservationofferingsRecord> getPrimaryKey() {
        return Keys.KEY_RESTURANTRESERVATIONOFFERINGS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResturantreservationofferingsRecord>> getKeys() {
        return Arrays.<UniqueKey<ResturantreservationofferingsRecord>>asList(Keys.KEY_RESTURANTRESERVATIONOFFERINGS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ResturantreservationofferingsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ResturantreservationofferingsRecord, ?>>asList(Keys.FK_RESTURANTRESERVATIONOFFERINGS_WEEKDAY, Keys.FK_RESTURANTRESERVATIONOFFERINGS_RESTURANTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resturantreservationofferings as(String alias) {
        return new Resturantreservationofferings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Resturantreservationofferings rename(String name) {
        return new Resturantreservationofferings(name, null);
    }
}