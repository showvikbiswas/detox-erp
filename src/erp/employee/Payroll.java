package erp.employee;

import erp.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;

public class Payroll {

    public void processPayroll() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("No database connection.");
            return;
        }
        
        try (Statement stmt = conn.createStatement()) {  
            String sql = "UPDATE employees SET salary = salary + 1000 WHERE role = 'Manager'"; 
            stmt.executeUpdate(sql);
            System.out.println("Payroll processed.");
        } catch (Exception e) {
            System.out.println("Payroll processing failed.");
        }
    }
}
