import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
    public static Connection createDBConnection() throws SQLException {
        return createDBConnection("localhost", 3306, "JDBC", "root", "root");
    }

    public static Connection createDBConnection(String host, int port, String dbName, String user, String password) throws SQLException {

        String connectionURL = String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
        return DriverManager.getConnection(connectionURL, user, password);
    }

}
