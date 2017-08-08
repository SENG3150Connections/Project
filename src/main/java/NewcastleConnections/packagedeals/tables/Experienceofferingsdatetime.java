/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ExperienceofferingsdatetimeRecord;

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
public class Experienceofferingsdatetime extends TableImpl<ExperienceofferingsdatetimeRecord> {

    private static final long serialVersionUID = -55760786;

    /**
     * The reference instance of <code>PackageDeals.ExperienceOfferingsDateTime</code>
     */
    public static final Experienceofferingsdatetime EXPERIENCEOFFERINGSDATETIME = new Experienceofferingsdatetime();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ExperienceofferingsdatetimeRecord> getRecordType() {
        return ExperienceofferingsdatetimeRecord.class;
    }

    /**
     * The column <code>PackageDeals.ExperienceOfferingsDateTime.id</code>.
     */
    public final TableField<ExperienceofferingsdatetimeRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ExperienceOfferingsDateTime.experienceOfferingDateId</code>.
     */
    public final TableField<ExperienceofferingsdatetimeRecord, UInteger> EXPERIENCEOFFERINGDATEID = createField("experienceOfferingDateId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ExperienceOfferingsDateTime.time</code>.
     */
    public final TableField<ExperienceofferingsdatetimeRecord, Timestamp> TIME = createField("time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.ExperienceOfferingsDateTime.maxGuestsAtTime</code>.
     */
    public final TableField<ExperienceofferingsdatetimeRecord, UInteger> MAXGUESTSATTIME = createField("maxGuestsAtTime", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.ExperienceOfferingsDateTime</code> table reference
     */
    public Experienceofferingsdatetime() {
        this("ExperienceOfferingsDateTime", null);
    }

    /**
     * Create an aliased <code>PackageDeals.ExperienceOfferingsDateTime</code> table reference
     */
    public Experienceofferingsdatetime(String alias) {
        this(alias, EXPERIENCEOFFERINGSDATETIME);
    }

    private Experienceofferingsdatetime(String alias, Table<ExperienceofferingsdatetimeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Experienceofferingsdatetime(String alias, Table<ExperienceofferingsdatetimeRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ExperienceofferingsdatetimeRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_EXPERIENCEOFFERINGSDATETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ExperienceofferingsdatetimeRecord> getPrimaryKey() {
        return Keys.KEY_EXPERIENCEOFFERINGSDATETIME_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ExperienceofferingsdatetimeRecord>> getKeys() {
        return Arrays.<UniqueKey<ExperienceofferingsdatetimeRecord>>asList(Keys.KEY_EXPERIENCEOFFERINGSDATETIME_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ExperienceofferingsdatetimeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ExperienceofferingsdatetimeRecord, ?>>asList(Keys.FK_EXPERIENCEOFFERINGSDATETIME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Experienceofferingsdatetime as(String alias) {
        return new Experienceofferingsdatetime(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Experienceofferingsdatetime rename(String name) {
        return new Experienceofferingsdatetime(name, null);
    }
}
