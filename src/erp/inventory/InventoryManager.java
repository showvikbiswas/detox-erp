package erp.inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();

    public void addProduct(String productId, int quantity) {
        if (productId == null || quantity <= 0) {
            System.out.println("Invalid product data.");
            return;
        }
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
    }

    public void updateInventory() { 
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }

    public void handleInventoryReconciliation() { 
        System.out.println("Reconciling inventory...");
        updateInventory();
    }
}
