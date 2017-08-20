/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.TagallocationsRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class Tagallocations extends TableImpl<TagallocationsRecord> {

    private static final long serialVersionUID = -2101077300;

    /**
     * The reference instance of <code>PackageDeals.TagAllocations</code>
     */
    public static final Tagallocations TAGALLOCATIONS = new Tagallocations();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TagallocationsRecord> getRecordType() {
        return TagallocationsRecord.class;
    }

    /**
     * The column <code>PackageDeals.TagAllocations.item</code>.
     */
    public final TableField<TagallocationsRecord, Integer> ITEM = createField("item", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PackageDeals.TagAllocations.tag</code>.
     */
    public final TableField<TagallocationsRecord, Integer> TAG = createField("tag", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>PackageDeals.TagAllocations</code> table reference
     */
    public Tagallocations() {
        this("TagAllocations", null);
    }

    /**
     * Create an aliased <code>PackageDeals.TagAllocations</code> table reference
     */
    public Tagallocations(String alias) {
        this(alias, TAGALLOCATIONS);
    }

    private Tagallocations(String alias, Table<TagallocationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Tagallocations(String alias, Table<TagallocationsRecord> aliased, Field<?>[] parameters) {
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
    public Tagallocations as(String alias) {
        return new Tagallocations(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Tagallocations rename(String name) {
        return new Tagallocations(name, null);
    }
}