package erp.payment;

import erp.db.DatabaseConnection;
import erp.payment.PaymentDAO;
import java.sql.Connection;
import java.sql.Statement;

public class PaymentProcessor {

    public void processPayment(String employeeId, double amount) {
        if (amount > 1000) {
            System.out.println("Processing payment of $" + amount + " for employee ID " + employeeId + " through Gateway A...");
        } else {
            System.out.println("Processing payment of $" + amount + " for employee ID " + employeeId + " through Gateway B...");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO payments (employee_id, amount) VALUES ('" + employeeId + "', " + amount + ")";
            stmt.executeUpdate(sql);  
            System.out.println("Payment recorded in database for employee ID " + employeeId);
        } catch (Exception e) {
            System.out.println("Error recording payment in the database.");
        }

        PaymentDAO paymentDAO = new PaymentDAO(); 
        paymentDAO.logPayment(employeeId, amount);  
    }
}
