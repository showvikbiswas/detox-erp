package erp.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Invalid employee.");
            return;
        }
        employees.add(employee);
    }

    public void calculateAnnualBonus() { 
        for (Employee emp : employees) {
            double bonus = emp.salary * 0.1;  
            System.out.println("Annual bonus for " + emp.name + ": " + bonus);
        }
    }

    public void listEmployeesByDepartment(String department) { 
        for (Employee emp : employees) {
            if (emp.department.equals(department)) {
                emp.displayDetails();
            }
        }
    }

     // New method to calculate employee commissions
    public List<String> getEmployeeCommissionData() {
        List<String> commissionData = new ArrayList<>();
        commissionData.add("Employee1: $100");
        commissionData.add("Employee2: $200");
        commissionData.add("Employee3: $300");
        return commissionData;
    }
}
