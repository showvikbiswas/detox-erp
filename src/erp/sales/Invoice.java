package erp.sales;

public class Invoice {

    private Order order;
    private double tax = 0.1;

    public Invoice(Order order) {
        this.order = order;
        System.out.println("Invoice created for order: " + order.getOrderId());
    }

    public double calculateFinalAmount() {
        return order.getTotalAmount() * (1 + tax);
    }
}
