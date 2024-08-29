package erp.payment;

import java.util.Scanner;

public class PaymentProcessor {

    public void processPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Processing payment of $" + amount + "...");

        if (amount > 1000) {
            System.out.println("Payment processed through Gateway A.");
        } else {
            System.out.println("Payment processed through Gateway B.");
        }

        System.out.println("Payment successful."); 
    }
}
