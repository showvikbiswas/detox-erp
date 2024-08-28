package erp.employee;

public class Employee {

    public String id;
    public String name;
    public double salary;
    public String department;

    public Employee(String id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void displayDetails() { 
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department);
    }
}
