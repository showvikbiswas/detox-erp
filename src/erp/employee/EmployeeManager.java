package erp.employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {

    private Map<String, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Invalid employee.");
            return;
        }
        employeeMap.put(employee.id, employee); 
    }

    public void calculateTotalSalaries() {
        double totalSalary = 0;
        for (Employee emp : employeeMap.values()) {
            totalSalary += emp.salary;
        }
        System.out.println("Total salaries: " + totalSalary);
    }

    public void updateEmployeeDetails(String id, String newName, double newSalary) {
        Employee emp = employeeMap.get(id);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }
        emp.name = newName;
        emp.salary = newSalary;
        System.out.println("Updated details for employee: " + emp.name);
    }
}
