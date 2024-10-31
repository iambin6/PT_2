package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    public Company() {
        loadData("company.txt");
    }

    public void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String dob = parts[2].trim();
                    double salary;

                    try {
                        salary = Double.parseDouble(parts[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Salary format error for employee: " + id);
                        continue;
                    }

                    if (validateEmployeeID(id) && validateDoB(dob)) {
                        Employee employee = new Employee(id, name, dob, salary);
                        employees.add(employee);
                    } else {
                        System.out.println("Invalid data format for employee: " + id);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private boolean validateEmployeeID(String employeeID) {
        return employeeID.matches("Emp\\d{3}");
    }

    private boolean validateDoB(String dob) {
        return dob.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> searchByID(String id) {
        return employees.stream().filter(e -> e.getEmployeeID().equals(id)).collect(Collectors.toList());
    }

    public List<Employee> searchByDoB(String dob) {
        return employees.stream().filter(e -> e.getDoB().equals(dob)).collect(Collectors.toList());
    }

    public List<Employee> searchByTax(double tax) {
        return employees.stream().filter(e -> e.calculateTax() == tax).collect(Collectors.toList());
    }

    public void sortEmployeesBySalary() {
        employees.sort(null);
    }
}
