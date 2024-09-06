package erp.employee;

import erp.db.DatabaseConnection;
import erp.payment.PaymentProcessor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {

    private Map<String, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Invalid employee.");
            return;
        }
        employeeMap.put(employee.id, employee);

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO employees (id, name, salary, department) VALUES ('" + 
                          employee.id + "', '" + employee.name + "', " + employee.salary + 
                          ", '" + employee.department + "')";
            stmt.executeUpdate(sql);  
            System.out.println("Employee added to the database.");
        } catch (Exception e) {
            System.out.println("Error adding employee to the database.");
        }
    }

    public void calculateTotalSalaries() {
        double totalSalary = 0;
        for (Employee emp : employeeMap.values()) {
            totalSalary += emp.salary;  
        }
        System.out.println("Total salaries: " + totalSalary);

        // Poor practice: Fetch total salary from the database in an inefficient way
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SUM(salary) AS total FROM employees")) {
            if (rs.next()) {
                double dbTotal = rs.getDouble("total");
                System.out.println("Total salaries from DB: " + dbTotal);
            }
        } catch (Exception e) {
            System.out.println("Error fetching total salaries from the database.");
        }
    }

    public void processPayroll() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        for (Employee emp : employeeMap.values()) {
            paymentProcessor.processPayment(emp.id, emp.salary);
        }
    }
}
