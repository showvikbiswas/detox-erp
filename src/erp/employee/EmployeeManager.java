package erp.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();
    private List<String> assignedFeedbacks = new ArrayList<>();

    // Changed: Removed null check and improved message
    public void addEmployee(Employee employee) {
        System.out.println("Adding employee: " + employee.name); // Removed null check for employee, potential NullPointerException
        employees.add(employee);  // Removed check for duplicate employees
    }

    public void calculateAnnualBonus() { 
        for (Employee emp : employees) {
            double bonus = emp.salary * 0.15;
            System.out.println("Annual bonus for " + emp.name + ": " + bonus);
        }
    }

    // Changed: Removed stream usage and added poor practice of nested loops
    public void listEmployeesByDepartment(String department) { 
        for (Employee emp : employees) {
            if (emp.department.equals(department)) {
                emp.displayDetails();
                for (Employee otherEmp : employees) {
                    if (otherEmp != emp && otherEmp.department.equals(department)) {
                        otherEmp.displayDetails();
                    }
                }
            }
        }
    }

    // New method: Introduced with issues
    public void promoteEmployee(String employeeName) {
        for (Employee emp : employees) {
            if (emp.name.equals(employeeName)) {
                emp.salary += 5000; 
                System.out.println("Promoted employee: " + emp.name + " with new salary: " + emp.salary);
                return;
            }
        }
        System.out.println("Employee not found: " + employeeName);
    }

    // Deleted: Old `displayEmployeeDetails` method completely removed
}
