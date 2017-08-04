/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Resturants;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
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
public class ResturantsRecord extends UpdatableRecordImpl<ResturantsRecord> implements Record11<UInteger, String, String, String, String, String, String, Byte, Byte, Double, Double> {

    private static final long serialVersionUID = 1570809686;

    /**
     * Setter for <code>PackageDeals.Resturants.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.address</code>.
     */
    public void setAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.address</code>.
     */
    public String getAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.contact</code>.
     */
    public void setContact(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.contact</code>.
     */
    public String getContact() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.email</code>.
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.website</code>.
     */
    public void setWebsite(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.website</code>.
     */
    public String getWebsite() {
        return (String) get(5);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.description</code>.
     */
    public void setDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.description</code>.
     */
    public String getDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.hasWebMenu</code>.
     */
    public void setHaswebmenu(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.hasWebMenu</code>.
     */
    public Byte getHaswebmenu() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.allowsWebReservations</code>.
     */
    public void setAllowswebreservations(Byte value) {
        set(8, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.allowsWebReservations</code>.
     */
    public Byte getAllowswebreservations() {
        return (Byte) get(8);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.longitude</code>.
     */
    public void setLongitude(Double value) {
        set(9, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.longitude</code>.
     */
    public Double getLongitude() {
        return (Double) get(9);
    }

    /**
     * Setter for <code>PackageDeals.Resturants.latitude</code>.
     */
    public void setLatitude(Double value) {
        set(10, value);
    }

    /**
     * Getter for <code>PackageDeals.Resturants.latitude</code>.
     */
    public Double getLatitude() {
        return (Double) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<UInteger, String, String, String, String, String, String, Byte, Byte, Double, Double> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<UInteger, String, String, String, String, String, String, Byte, Byte, Double, Double> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Resturants.RESTURANTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Resturants.RESTURANTS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Resturants.RESTURANTS.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Resturants.RESTURANTS.CONTACT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Resturants.RESTURANTS.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Resturants.RESTURANTS.WEBSITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Resturants.RESTURANTS.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Resturants.RESTURANTS.HASWEBMENU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field9() {
        return Resturants.RESTURANTS.ALLOWSWEBRESERVATIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field10() {
        return Resturants.RESTURANTS.LONGITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field11() {
        return Resturants.RESTURANTS.LATITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getContact();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getWebsite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getHaswebmenu();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value9() {
        return getAllowswebreservations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value10() {
        return getLongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value11() {
        return getLatitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value3(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value4(String value) {
        setContact(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value5(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value6(String value) {
        setWebsite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value7(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value8(Byte value) {
        setHaswebmenu(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value9(Byte value) {
        setAllowswebreservations(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value10(Double value) {
        setLongitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord value11(Double value) {
        setLatitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResturantsRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, String value7, Byte value8, Byte value9, Double value10, Double value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ResturantsRecord
     */
    public ResturantsRecord() {
        super(Resturants.RESTURANTS);
    }

    /**
     * Create a detached, initialised ResturantsRecord
     */
    public ResturantsRecord(UInteger id, String name, String address, String contact, String email, String website, String description, Byte haswebmenu, Byte allowswebreservations, Double longitude, Double latitude) {
        super(Resturants.RESTURANTS);

        set(0, id);
        set(1, name);
        set(2, address);
        set(3, contact);
        set(4, email);
        set(5, website);
        set(6, description);
        set(7, haswebmenu);
        set(8, allowswebreservations);
        set(9, longitude);
        set(10, latitude);
    }
}
