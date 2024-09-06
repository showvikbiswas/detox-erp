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

     // New method added for calculating monthly sales data
    public List<String> getMonthlySalesData() {
        List<String> salesData = new ArrayList<>();
        salesData.add("Sale1: $1000");
        salesData.add("Sale2: $1500");
        salesData.add("Sale3: $2000");
        return salesData; 
    }
}
