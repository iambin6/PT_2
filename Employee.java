package model;

public class Employee implements Comparable<Employee> {
    private String employeeID;
    private String name;
    private String dob;
    private double salary;

    public Employee(String employeeID, String name, String dob, double salary) {
        if (!validateEmployeeID(employeeID)) throw new IllegalArgumentException("Invalid ID format");
        if (!validateDoB(dob)) throw new IllegalArgumentException("Invalid Date format");
        this.employeeID = employeeID;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    public double calculateTax() {
        if (salary < 9000000) return 0;
        if (salary <= 15000000) return salary * 0.1;
        return salary * 0.12;
    }

    @Override
    public String toString() {
        return employeeID + " | " + name + " | " + dob + " | " + salary + " | " + calculateTax();
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    private boolean validateEmployeeID(String employeeID) {
        return employeeID.matches("Emp\\d{3}");
    }

    private boolean validateDoB(String dob) {
        return dob.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDoB() {
        return dob;
    }

    public double getSalary() {
        return salary;
    }
}
