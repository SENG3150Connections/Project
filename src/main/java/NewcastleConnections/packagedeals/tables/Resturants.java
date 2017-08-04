/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ResturantsRecord;

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
public class Resturants extends TableImpl<ResturantsRecord> {

    private static final long serialVersionUID = -1879724668;

    /**
     * The reference instance of <code>PackageDeals.Resturants</code>
     */
    public static final Resturants RESTURANTS = new Resturants();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResturantsRecord> getRecordType() {
        return ResturantsRecord.class;
    }

    /**
     * The column <code>PackageDeals.Resturants.id</code>.
     */
    public final TableField<ResturantsRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.name</code>.
     */
    public final TableField<ResturantsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.address</code>.
     */
    public final TableField<ResturantsRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.contact</code>.
     */
    public final TableField<ResturantsRecord, String> CONTACT = createField("contact", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.email</code>.
     */
    public final TableField<ResturantsRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.website</code>.
     */
    public final TableField<ResturantsRecord, String> WEBSITE = createField("website", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>PackageDeals.Resturants.description</code>.
     */
    public final TableField<ResturantsRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.hasWebMenu</code>.
     */
    public final TableField<ResturantsRecord, Byte> HASWEBMENU = createField("hasWebMenu", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.allowsWebReservations</code>.
     */
    public final TableField<ResturantsRecord, Byte> ALLOWSWEBRESERVATIONS = createField("allowsWebReservations", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.longitude</code>.
     */
    public final TableField<ResturantsRecord, Double> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Resturants.latitude</code>.
     */
    public final TableField<ResturantsRecord, Double> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.Resturants</code> table reference
     */
    public Resturants() {
        this("Resturants", null);
    }

    /**
     * Create an aliased <code>PackageDeals.Resturants</code> table reference
     */
    public Resturants(String alias) {
        this(alias, RESTURANTS);
    }

    private Resturants(String alias, Table<ResturantsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Resturants(String alias, Table<ResturantsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ResturantsRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_RESTURANTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResturantsRecord> getPrimaryKey() {
        return Keys.KEY_RESTURANTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResturantsRecord>> getKeys() {
        return Arrays.<UniqueKey<ResturantsRecord>>asList(Keys.KEY_RESTURANTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Resturants as(String alias) {
        return new Resturants(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Resturants rename(String name) {
        return new Resturants(name, null);
    }
}