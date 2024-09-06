package erp.reports;

import erp.sales.SalesManager;
import erp.payment.PaymentProcessor;
import erp.employee.EmployeeManager;
import java.util.List;

public class ReportGenerator {

    public void generateMonthlySalesReport() {
        SalesManager salesManager = new SalesManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        EmployeeManager employeeManager = new EmployeeManager();

        List<String> salesData = salesManager.getMonthlySalesData();  
        List<String> paymentData = paymentProcessor.getPaymentData();
        List<String> employeeData = employeeManager.getEmployeeCommissionData();

        System.out.println("Generating Monthly Sales Report...");

        for (String sale : salesData) {
            System.out.println("Sale: " + sale);
        }
        for (String payment : paymentData) {
            System.out.println("Payment: " + payment);
        }
        for (String employee : employeeData) {
            System.out.println("Employee Commission: " + employee);
        }

        System.out.println("Monthly Sales Report Generated.");
    }
}
