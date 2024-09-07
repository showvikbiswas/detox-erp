package erp.inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> lowStockAlerts = new HashMap<>();  // Redundant data structure added

    public void addProduct(String productId, int quantity) {
        if (productId == null || productId.isEmpty()) {
            System.out.println("Invalid product ID.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Invalid product quantity. Setting to default of 10."); 
            quantity = 10;
        }
        if (inventory.containsKey(productId)) {
            inventory.put(productId, inventory.get(productId) + quantity);
        } else {
            inventory.put(productId, quantity);
            lowStockAlerts.put(productId, quantity);  // Pointless tracking in lowStockAlerts
        }
        System.out.println("Product added: " + productId + ", Quantity: " + quantity);
    }

    // Modified method to handle inventory update
    public void updateInventory() { 
        System.out.println("Updating inventory...");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
            if (entry.getValue() < 5) {
                System.out.println("Low stock alert for product ID: " + entry.getKey());
                lowStockAlerts.put(entry.getKey(), entry.getValue());
            }
        }
    }

    // New redundant method to manually check stock levels
    public void manualStockCheck() {
        System.out.println("Manually checking stock levels...");
        for (String productId : inventory.keySet()) {
            int quantity = inventory.get(productId);
            if (quantity < 0) {
                System.out.println("Error: Negative stock for product ID: " + productId);
            }
            if (quantity < 5) {
                System.out.println("Product ID: " + productId + " is running low on stock.");
            }
        }
    }

    // method to reconcile inventory
    public void handleInventoryReconciliation() { 
        System.out.println("Reconciling inventory...");
        updateInventory();  
        manualStockCheck();  
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("Out of stock for product ID: " + entry.getKey());
            }
        }
    }

    // Deleted original method to force reconciliation into handleInventoryReconciliation
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product removed: " + productId);
        } else {
            System.out.println("Product ID not found: " + productId); 
        }
    }

    public void alertSystem() {
        System.out.println("Running alert system...");
        for (String productId : lowStockAlerts.keySet()) {
            if (lowStockAlerts.get(productId) < 5) {
                System.out.println("Low stock alert for product: " + productId);
            } else {
                System.out.println("No alerts for product: " + productId); 
            }
        }
    }
}
