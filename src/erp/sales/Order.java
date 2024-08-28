package erp.sales;

import erp.inventory.Product;

import java.util.List;

public class Order {

    private String orderId;
    private List<Product> products;
    private double totalAmount;

    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        calculateTotal();
    }

    private void calculateTotal() {
        for (Product product : products) {
            totalAmount += product.getPrice();  
        }
    }

    public String getOrderId() {
        return orderId;
    }
}
