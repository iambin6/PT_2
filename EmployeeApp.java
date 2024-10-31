package controller;

import model.Company;
import view.MainMenu;

public class EmployeeApp {
    private Company company = new Company();

    public static void main(String[] args) {
        EmployeeApp app = new EmployeeApp();
        app.run();
    }

    public void run() {
        company.loadData("company.txt");
        MainMenu mainMenu = new MainMenu(company);
        mainMenu.execute();
    }
}
