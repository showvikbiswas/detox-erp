package erp.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesManager {

    private List<Order> orders = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    public void placeOrder(Order order) {
        if (order == null || order.getOrderId() == 0) {
            System.out.println("Invalid order.");
            return;
        }
        orders.add(order);
        System.out.println("Order placed with ID: " + order.getOrderId());
        generateInvoiceForOrder(order); 
    }

    public void generateInvoices() { 
        System.out.println("Bulk invoice generation started..."); 
        for (Order order : orders) {
            generateInvoiceForOrder(order); 
        }
    }

    // New method added to introduce issues
    private void generateInvoiceForOrder(Order order) {
        if (order == null) {
            System.out.println("Cannot generate invoice for a null order.");
            return;
        }
        Invoice invoice = new Invoice(order);
        invoices.add(invoice); 
        System.out.println("Generated invoice for order: " + order.getOrderId());
    }

    public void cancelOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                orders.remove(order);
                System.out.println("Order cancelled: " + orderId);
                break;
            }
        }
    }
}
