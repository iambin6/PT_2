package view;

import model.Company;
import model.Employee;
import java.util.Scanner;

public class MainMenu extends Menu {
    private Company company;

    public MainMenu(Company company) {
        this.company = company;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. List all Employees");
            System.out.println("2. Income of Employee");
            System.out.println("3. Employee Search");
            System.out.println("4. Sort Employee by Salary");
            System.out.println("5. Exit");
            System.out.print("Enter selection: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listAllEmployees();
                    break;
                case 2:
                    listEmployeeIncome();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    company.sortEmployeesBySalary();
                    listAllEmployees();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void listAllEmployees() {
        System.out.println("List of Employees:");
        for (Employee e : company.getEmployees()) {
            System.out.println(e);
        }
    }

    private void listEmployeeIncome() {
        System.out.println("Employee Income:");
        for (Employee e : company.getEmployees()) {
            System.out.println(e + " | Income: " + (e.getSalary() - e.calculateTax()));
        }
    }

    private void searchEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Employee Search:");
        System.out.println("1. Find by ID");
        System.out.println("2. Find by DOB");
        System.out.println("3. Find by Tax");
        System.out.print("Enter selection: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                String id = scanner.nextLine();
                company.searchByID(id).forEach(System.out::println);
                break;
            case 2:
                System.out.print("Enter Employee DOB (dd/MM/yyyy): ");
                String dob = scanner.nextLine();
                company.searchByDoB(dob).forEach(System.out::println);
                break;
            case 3:
                System.out.print("Enter Tax amount: ");
                double tax = scanner.nextDouble();
                company.searchByTax(tax).forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
