/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.RoomofferingrateoverridesRecord;

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
public class Roomofferingrateoverrides extends TableImpl<RoomofferingrateoverridesRecord> {

    private static final long serialVersionUID = -848672371;

    /**
     * The reference instance of <code>PackageDeals.RoomOfferingRateOverrides</code>
     */
    public static final Roomofferingrateoverrides ROOMOFFERINGRATEOVERRIDES = new Roomofferingrateoverrides();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoomofferingrateoverridesRecord> getRecordType() {
        return RoomofferingrateoverridesRecord.class;
    }

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.id</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.adultQty</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, UInteger> ADULTQTY = createField("adultQty", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.childQty</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, UInteger> CHILDQTY = createField("childQty", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.rate</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, Double> RATE = createField("rate", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.appliesFrom</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, Timestamp> APPLIESFROM = createField("appliesFrom", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.appliesTo</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, Timestamp> APPLIESTO = createField("appliesTo", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.validFrom</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, Timestamp> VALIDFROM = createField("validFrom", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.validTo</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, Timestamp> VALIDTO = createField("validTo", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.RoomOfferingRateOverrides.roomOfferingId</code>.
     */
    public final TableField<RoomofferingrateoverridesRecord, UInteger> ROOMOFFERINGID = createField("roomOfferingId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.RoomOfferingRateOverrides</code> table reference
     */
    public Roomofferingrateoverrides() {
        this("RoomOfferingRateOverrides", null);
    }

    /**
     * Create an aliased <code>PackageDeals.RoomOfferingRateOverrides</code> table reference
     */
    public Roomofferingrateoverrides(String alias) {
        this(alias, ROOMOFFERINGRATEOVERRIDES);
    }

    private Roomofferingrateoverrides(String alias, Table<RoomofferingrateoverridesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Roomofferingrateoverrides(String alias, Table<RoomofferingrateoverridesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<RoomofferingrateoverridesRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_ROOMOFFERINGRATEOVERRIDES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RoomofferingrateoverridesRecord> getPrimaryKey() {
        return Keys.KEY_ROOMOFFERINGRATEOVERRIDES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RoomofferingrateoverridesRecord>> getKeys() {
        return Arrays.<UniqueKey<RoomofferingrateoverridesRecord>>asList(Keys.KEY_ROOMOFFERINGRATEOVERRIDES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<RoomofferingrateoverridesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RoomofferingrateoverridesRecord, ?>>asList(Keys.FK_ROOMOFFERINGRATEOVERRIDE_ROOMOFFERING);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Roomofferingrateoverrides as(String alias) {
        return new Roomofferingrateoverrides(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Roomofferingrateoverrides rename(String name) {
        return new Roomofferingrateoverrides(name, null);
    }
}
