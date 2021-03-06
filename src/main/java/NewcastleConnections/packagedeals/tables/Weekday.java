/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.WeekdayRecord;

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
public class Weekday extends TableImpl<WeekdayRecord> {

    private static final long serialVersionUID = 218152403;

    /**
     * The reference instance of <code>PackageDeals.Weekday</code>
     */
    public static final Weekday WEEKDAY = new Weekday();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WeekdayRecord> getRecordType() {
        return WeekdayRecord.class;
    }

    /**
     * The column <code>PackageDeals.Weekday.id</code>.
     */
    public final TableField<WeekdayRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Weekday.day</code>.
     */
    public final TableField<WeekdayRecord, String> DAY = createField("day", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.Weekday</code> table reference
     */
    public Weekday() {
        this("Weekday", null);
    }

    /**
     * Create an aliased <code>PackageDeals.Weekday</code> table reference
     */
    public Weekday(String alias) {
        this(alias, WEEKDAY);
    }

    private Weekday(String alias, Table<WeekdayRecord> aliased) {
        this(alias, aliased, null);
    }

    private Weekday(String alias, Table<WeekdayRecord> aliased, Field<?>[] parameters) {
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
    public Identity<WeekdayRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_WEEKDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WeekdayRecord> getPrimaryKey() {
        return Keys.KEY_WEEKDAY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WeekdayRecord>> getKeys() {
        return Arrays.<UniqueKey<WeekdayRecord>>asList(Keys.KEY_WEEKDAY_PRIMARY, Keys.KEY_WEEKDAY_DAY_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Weekday as(String alias) {
        return new Weekday(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Weekday rename(String name) {
        return new Weekday(name, null);
    }
}
