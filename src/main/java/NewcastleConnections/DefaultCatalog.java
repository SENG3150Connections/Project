/*
 * This file is generated by jOOQ.
*/
package NewcastleConnections;


import NewcastleConnections.packagedeals.Packagedeals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;


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
public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = 1863822524;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    /**
     * The schema <code>PackageDeals</code>.
     */
    public final Packagedeals PACKAGEDEALS = NewcastleConnections.packagedeals.Packagedeals.PACKAGEDEALS;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }
}
