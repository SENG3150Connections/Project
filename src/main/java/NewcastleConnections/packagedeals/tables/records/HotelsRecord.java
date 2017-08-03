/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections.packagedeals.tables.records;


import NewcastleConnections.packagedeals.tables.Hotels;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class HotelsRecord extends UpdatableRecordImpl<HotelsRecord> implements Record9<UInteger, String, String, String, String, String, String, Double, Double> {

    private static final long serialVersionUID = -1914505118;

    /**
     * Setter for <code>PackageDeals.Hotels.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.contact</code>.
     */
    public void setContact(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.contact</code>.
     */
    public String getContact() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.email</code>.
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.address</code>.
     */
    public void setAddress(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.address</code>.
     */
    public String getAddress() {
        return (String) get(4);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.website</code>.
     */
    public void setWebsite(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.website</code>.
     */
    public String getWebsite() {
        return (String) get(5);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.description</code>.
     */
    public void setDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.description</code>.
     */
    public String getDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.latitude</code>.
     */
    public void setLatitude(Double value) {
        set(7, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.latitude</code>.
     */
    public Double getLatitude() {
        return (Double) get(7);
    }

    /**
     * Setter for <code>PackageDeals.Hotels.longitude</code>.
     */
    public void setLongitude(Double value) {
        set(8, value);
    }

    /**
     * Getter for <code>PackageDeals.Hotels.longitude</code>.
     */
    public Double getLongitude() {
        return (Double) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<UInteger, String, String, String, String, String, String, Double, Double> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<UInteger, String, String, String, String, String, String, Double, Double> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Hotels.HOTELS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Hotels.HOTELS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Hotels.HOTELS.CONTACT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Hotels.HOTELS.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Hotels.HOTELS.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Hotels.HOTELS.WEBSITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Hotels.HOTELS.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field8() {
        return Hotels.HOTELS.LATITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field9() {
        return Hotels.HOTELS.LONGITUDE;
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
        return getContact();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getAddress();
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
    public Double value8() {
        return getLatitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value9() {
        return getLongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value3(String value) {
        setContact(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value4(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value5(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value6(String value) {
        setWebsite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value7(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value8(Double value) {
        setLatitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord value9(Double value) {
        setLongitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelsRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, String value7, Double value8, Double value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached HotelsRecord
     */
    public HotelsRecord() {
        super(Hotels.HOTELS);
    }

    /**
     * Create a detached, initialised HotelsRecord
     */
    public HotelsRecord(UInteger id, String name, String contact, String email, String address, String website, String description, Double latitude, Double longitude) {
        super(Hotels.HOTELS);

        set(0, id);
        set(1, name);
        set(2, contact);
        set(3, email);
        set(4, address);
        set(5, website);
        set(6, description);
        set(7, latitude);
        set(8, longitude);
    }
}
