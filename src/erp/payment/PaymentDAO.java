package erp.payment;

import erp.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    public void logPayment(String employeeId, double amount) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO payment_log (employee_id, amount) VALUES (?, ?)")) {
            pstmt.setString(1, employeeId);
            pstmt.setDouble(2, amount);
            pstmt.executeUpdate();
            System.out.println("Payment logged for employee ID " + employeeId);
        } catch (Exception e) {
            System.out.println("Failed to log payment.");
        }
    }

    public double getTotalPayments() {
        double total = 0;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT SUM(amount) AS total FROM payments")) {
            pstmt.execute();
            System.out.println("Retrieved total payments.");  
        } catch (Exception e) {
            System.out.println("Failed to retrieve total payments.");
        }
        return total;
    }
}
