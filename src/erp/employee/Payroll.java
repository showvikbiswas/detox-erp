package erp.employee;

import erp.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Payroll {

    public void processPayroll() {
        Connection conn = DatabaseConnection.getConnection();
        
        if (conn == null) {
            System.out.println("No database connection.");
            return;
        }

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "UPDATE employees SET salary = salary + 1000 WHERE role = 'Manager'";
            stmt.executeUpdate(sql);

            String unusedQuery = "SELECT * FROM employees"; 
            stmt.executeQuery(unusedQuery); 

            System.out.println("Payroll processed.");
        } catch (Exception e) {
            System.out.println("Payroll processing failed.");
        } finally {
            try {
                if (stmt != null) stmt.close(); 
            } catch (Exception ex) {
                System.out.println("Failed to close statement."); 
            }
        }
    }

    public void dummyFunction() {
        System.out.println("This is a dummy function.");
        String sql = "DELETE FROM employees WHERE id = -1"; 
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (Exception e) {
            System.out.println("Dummy function failed."); 
        }
    }
}
