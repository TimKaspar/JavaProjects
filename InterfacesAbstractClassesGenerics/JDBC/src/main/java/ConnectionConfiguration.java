import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
    private static Connection createDBConnection() throws SQLException {
        return createDBConnection("localhost", 3306, "JDBC", "root@localhost", "root");
    }

    private static Connection createDBConnection(String host, int port, String dbName, String user, String password) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found");
        }
        String connectionURL = String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
        return DriverManager.getConnection(connectionURL, user, password);
    }

}
