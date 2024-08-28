package erp;

import erp.employee.*;
import erp.inventory.*;
import erp.sales.*;
import erp.db.DatabaseConnection;
import erp.utils.Util;

public class Main {

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        InventoryManager inventoryManager = new InventoryManager();
        SalesManager salesManager = new SalesManager();

        employeeManager.addEmployee(new Employee("101", "Alice", 70000, "HR"));
        employeeManager.calculateAnnualBonus();
        inventoryManager.addProduct("A101", 50);
        salesManager.placeOrder(new Order("O001", null));

        Util.log("System initialized.");
        DatabaseConnection.getConnection();
    }
}
