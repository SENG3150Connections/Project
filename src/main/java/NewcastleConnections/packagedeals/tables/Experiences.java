/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables;


import NewcastleConnections.packagedeals.Keys;
import NewcastleConnections.packagedeals.Packagedeals;
import NewcastleConnections.packagedeals.tables.records.ExperiencesRecord;

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
public class Experiences extends TableImpl<ExperiencesRecord> {

    private static final long serialVersionUID = 323618298;

    /**
     * The reference instance of <code>PackageDeals.Experiences</code>
     */
    public static final Experiences EXPERIENCES = new Experiences();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ExperiencesRecord> getRecordType() {
        return ExperiencesRecord.class;
    }

    /**
     * The column <code>PackageDeals.Experiences.id</code>. On this table, if ‘allowsVariableGuestCount’ is true, then the user should be displayed with the option to select how many guests are present. This has to be inline with the ExperienceOfferings. If not, the experience should be for a set number of people, priced at maxGuests * pricePerGuest.
     */
    public final TableField<ExperiencesRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "On this table, if ‘allowsVariableGuestCount’ is true, then the user should be displayed with the option to select how many guests are present. This has to be inline with the ExperienceOfferings. If not, the experience should be for a set number of people, priced at maxGuests * pricePerGuest.");

    /**
     * The column <code>PackageDeals.Experiences.name</code>.
     */
    public final TableField<ExperiencesRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.overview</code>.
     */
    public final TableField<ExperiencesRecord, String> OVERVIEW = createField("overview", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.description</code>.
     */
    public final TableField<ExperiencesRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.location</code>.
     */
    public final TableField<ExperiencesRecord, String> LOCATION = createField("location", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.info</code>.
     */
    public final TableField<ExperiencesRecord, String> INFO = createField("info", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.guidelines</code>.
     */
    public final TableField<ExperiencesRecord, String> GUIDELINES = createField("guidelines", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.experienceProviderId</code>.
     */
    public final TableField<ExperiencesRecord, UInteger> EXPERIENCEPROVIDERID = createField("experienceProviderId", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.latitude</code>.
     */
    public final TableField<ExperiencesRecord, Double> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>PackageDeals.Experiences.longitude</code>.
     */
    public final TableField<ExperiencesRecord, Double> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * Create a <code>PackageDeals.Experiences</code> table reference
     */
    public Experiences() {
        this("Experiences", null);
    }

    /**
     * Create an aliased <code>PackageDeals.Experiences</code> table reference
     */
    public Experiences(String alias) {
        this(alias, EXPERIENCES);
    }

    private Experiences(String alias, Table<ExperiencesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Experiences(String alias, Table<ExperiencesRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ExperiencesRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_EXPERIENCES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ExperiencesRecord> getPrimaryKey() {
        return Keys.KEY_EXPERIENCES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ExperiencesRecord>> getKeys() {
        return Arrays.<UniqueKey<ExperiencesRecord>>asList(Keys.KEY_EXPERIENCES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ExperiencesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ExperiencesRecord, ?>>asList(Keys.FK_EXPERIENCES_EXPERIENCEPROVIDERS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Experiences as(String alias) {
        return new Experiences(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Experiences rename(String name) {
        return new Experiences(name, null);
    }
}