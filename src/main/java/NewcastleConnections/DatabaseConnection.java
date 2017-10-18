package NewcastleConnections;

/*
DatabaseConnection.java
Author: Seb Brown / Scott Walker

Description:
    A class designed to further abstracts the database connection to limit errors.

    Constructor method opens a database connection and close() closes it, close must be called once work is complete
    or the connection will remain open.
*/

import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final SQLDialect DIALECT = SQLDialect.MYSQL; // Database is MYSQL
    private Connection connection;

    // -- Constructor --
    //   Role: Create the connection info for the database
    //
    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://203.9.224.172:3306/PackageDeals", "newcastle", "connections");
    }

    // -- Public --
    //   Role: Get the DSLContext for the connection and specified dialect.
    //
    public DSLContext getDSL() {
        return DSL.using(connection, DIALECT);
    }

    // -- Public --
    //   Role: Close the database connection.
    //
    public void close() throws SQLException {
        connection.close();
    }

}
