package NewcastleConnections;


import java.net.URISyntaxException;
import java.sql.*;
import java.util.List;


public class DatabaseConnectionManager {

    private static final String JDBC_driver = "com.mysql.jdbc.Driver";




    private static Connection getConnection() throws URISyntaxException, SQLException, ClassNotFoundException {

        Class.forName(JDBC_driver);

        String username = "dzsk0iuaa2ljqu9z";
        String password = "hdswnog7t1ily38b";
        String port = "3306";
        String host = "op2hpcwcbxb1t4z9.cbetxkdyhwsb.us-east-1.rds.amazonaws.com";
        String path = "/vn424fecfcpcyxxz";
        String jdbUrl = "jdbc:mysql://" + host + ":" + port + path;

        return DriverManager.getConnection(jdbUrl, username, password);
    }




    public List<Item> getAllAccommodation() {
        // TODO
        return null;
    }

    public List<Item> getAllTransport() {
        // TODO
        return null;
    }

    public List<Item> getAllEvents() {
        // TODO
        return null;
    }



    public String test() {

        String output = "";


        try {
            Class.forName(JDBC_driver);

            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("show tables;");


            while (rs.next()) {

                output += rs.getString(1);

            }

            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            System.err.println("Database Connection Error " + e.toString());
            return "FAIL";

        }

        return output;

    }


/*
postgresql config
    private static Connection getConnection() throws PSQLException, URISyntaxException, SQLException, ClassNotFoundException {
        Class.forName(JDBC_driver);

        return DriverManager.getConnection(database_URI);

    }
    */
}
