import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

<<<<<<< HEAD
    public class ConnectionConfiguration {
        public static Connection createDBConnection() throws SQLException {
            return createDBConnection("localhost", 3306, "JDBC", "root", "root");
        }

        public static Connection createDBConnection(String host, int port, String dbName, String user, String password) throws SQLException {

            String connectionURL = String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
            return DriverManager.getConnection(connectionURL, user, password);
        }

    }
=======
public class ConnectionConfiguration {
    public static Connection createDBConnection() throws SQLException {
        return createDBConnection("localhost", 3306, "JDBC", "root", "root");
    }

    public static Connection createDBConnection(String host, int port, String dbName, String user, String password) throws SQLException {

        String connectionURL = String.format("jdbc:mysql://%s:%d/%s", host, port, dbName);
        return DriverManager.getConnection(connectionURL, user, password);
    }

}
>>>>>>> cff5ea189c5f419376637abcfd81afb0bf3b4ba0
