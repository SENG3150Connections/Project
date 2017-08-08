package NewcastleConnections;


import com.opensymphony.xwork2.ActionSupport;
import NewcastleConnections.packagedeals.tables.records.HotelsRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.util.derby.sys.Sys;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthTextAreaUI;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

import static NewcastleConnections.packagedeals.Tables.*;


/**
 * DatabaseConnection
 *
 * A class designed to further abstracts the database connection to limit errors.
 *
 * Constructor method opens a database connection and close() closes it, close must be called once work is complete
 * or the connection will remain open.
 *
 * Use interceptor.
 *
 */


public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() throws SQLException, NamingException, ClassNotFoundException {

        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:jdbc/SiteDatabase");
        connection = ds.getConnection();

    }

    public DSLContext getDSL() {

        return DSL.using(connection, SQLDialect.MYSQL);

    }

    public void close() throws SQLException {

        connection.close();

    }


}
