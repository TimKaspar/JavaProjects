package ch.ti8m.azubi.kti.pizzashop.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection testConnection() throws SQLException {
        // load the driver - this will also register it
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("H2 Driver not found");
        }
        String connectionURL = "jdbc:h2:file:./db/h2-database;DB_CLOSE_ON_EXIT=FALSE";
        return DriverManager.getConnection(connectionURL);

    }
}
