package erp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) return connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp_db", "user", "password");  // Hardcoded credentials
            System.out.println("Database connected.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");  // Poor practice: No detailed error logging
        }
        return connection;
    }
}
