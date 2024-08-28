package erp.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesManager {

    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        if (order == null) {
            System.out.println("Invalid order.");
            return;
        }
        orders.add(order);
        System.out.println("Order placed.");
    }

    public void generateInvoices() {  
        for (Order order : orders) {
            Invoice invoice = new Invoice(order);
            System.out.println("Generated invoice for order: " + order.getOrderId());
        }
    }
}
