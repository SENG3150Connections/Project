/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;

import java.sql.Date;
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
public class Hotels extends TableImpl<HotelsRecord> {

    private static final long serialVersionUID = 1739034088;

    /**
     * The reference instance of <code>PackageDeals.Hotels</code>
     */
    public static final Hotels HOTELS = new Hotels();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HotelsRecord> getRecordType() {
        return HotelsRecord.class;
    }

    /**
     * The column <code>PackageDeals.Hotels.id</code>.
     */
    public final TableField<HotelsRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.name</code>.
     */
    public final TableField<HotelsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.contact</code>.
     */
    public final TableField<HotelsRecord, String> CONTACT = createField("contact", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>PackageDeals.Hotels.email</code>.
     */
    public final TableField<HotelsRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>PackageDeals.Hotels.address</code>.
     */
    public final TableField<HotelsRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.website</code>.
     */
    public final TableField<HotelsRecord, String> WEBSITE = createField("website", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>PackageDeals.Hotels.description</code>.
     */
    public final TableField<HotelsRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.latitude</code>.
     */
    public final TableField<HotelsRecord, Double> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.longitude</code>.
     */
    public final TableField<HotelsRecord, Double> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.publicallyVisible</code>.
     */
    public final TableField<HotelsRecord, Byte> PUBLICALLYVISIBLE = createField("publicallyVisible", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Hotels.releaseOnDate</code>.
     */
    public final TableField<HotelsRecord, Byte> RELEASEONDATE = createField("releaseOnDate", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>PackageDeals.Hotels.releaseDate</code>.
     */
    public final TableField<HotelsRecord, Date> RELEASEDATE = createField("releaseDate", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>PackageDeals.Hotels.imageID</code>.
     */
    public final TableField<HotelsRecord, String> IMAGEID = createField("imageID", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

    /**
     * The column <code>PackageDeals.Hotels.category</code>.
     */
    public final TableField<HotelsRecord, String> CATEGORY = createField("category", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

    /**
     * Create a <code>PackageDeals.Hotels</code> table reference
     */
    public Hotels() {
        this("Hotels", null);
    }

    /**
     * Create an aliased <code>PackageDeals.Hotels</code> table reference
     */
    public Hotels(String alias) {
        this(alias, HOTELS);
    }

    private Hotels(String alias, Table<HotelsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hotels(String alias, Table<HotelsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<HotelsRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_HOTELS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<HotelsRecord> getPrimaryKey() {
        return Keys.KEY_HOTELS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<HotelsRecord>> getKeys() {
        return Arrays.<UniqueKey<HotelsRecord>>asList(Keys.KEY_HOTELS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hotels as(String alias) {
        return new Hotels(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hotels rename(String name) {
        return new Hotels(name, null);
    }
}
