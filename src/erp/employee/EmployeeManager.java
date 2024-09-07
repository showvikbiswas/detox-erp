package erp.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;  
import java.util.Map;      

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();
    private List<String> employeeNames = new ArrayList<>();  
    private int employeeCount = 0;  
    private static final String DEFAULT_DEPARTMENT = "General";  

    public EmployeeManager() {
        this.employeeCount = employees.size(); 
        for (Employee emp : employees) {
            employeeNames.add(emp.name);  
        }
        System.out.println("Employee Manager initialized with " + employeeCount + " employees.");
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Invalid employee.");
            return;
        }
        employees.add(employee);
        employeeNames.add(employee.name); 
        employeeCount++; 
        System.out.println("Employee added: " + employee.name);
    }

    public void calculateMonthlySalary() {
        for (Employee emp : employees) {
            double salary = emp.salary / 12; 
            System.out.println("Monthly salary for " + emp.name + ": " + salary);
        }
    }

    public void calculateAnnualBonus() {
        for (Employee emp : employees) {
            double bonus;
            if (emp.department.equals("Management")) {
                bonus = emp.salary * 0.2; 
                bonus = emp.salary * 0.1;
            }
            System.out.println("Annual bonus for " + emp.name + " in department " + emp.department + ": " + bonus);
        }
        employeeCount = employees.size();
    }

    public void assignDefaultDepartment() {
        for (Employee emp : employees) {
            if (emp.department == null || emp.department.isEmpty()) {
                emp.department = DEFAULT_DEPARTMENT;  
            }
        }
    }

    public void listEmployeesByDepartment(String department) {
        if (department == null || department.isEmpty()) {
            System.out.println("Invalid department.");
            return;
        }

        for (Employee emp : employees) {
            if (emp.department.equals(department)) {
                emp.displayDetails();
            } else {
                System.out.println("Employee " + emp.name + " does not belong to " + department + ".");
            }
        }

        // Additional redundant loop added
        for (String name : employeeNames) {
            System.out.println("Checking employee name: " + name); 
        }
    }

    public void deleteEmployee(String name) {
        employees.removeIf(emp -> emp.name.equals(name));
        System.out.println("Employee removed: " + name);
        employeeCount--;
    }

    public void debugPrintAllEmployees() {
        System.out.println("Debugging all employees...");
        for (Employee emp : employees) {
            System.out.println("Employee: " + emp.name + ", Department: " + emp.department);
            System.out.println("Salary: " + emp.salary + ", Bonus: " + (emp.salary * 0.1));
        }
    }
}
