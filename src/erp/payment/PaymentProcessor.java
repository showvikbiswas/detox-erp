package erp.payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {

    public List<String> getPaymentData() {
        List<String> paymentData = new ArrayList<>();
        paymentData.add("Payment1: $500");
        paymentData.add("Payment2: $700");
        paymentData.add("Payment3: $900");
        return paymentData; 
    }
}
