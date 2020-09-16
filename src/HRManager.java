import java.util.Scanner;

import view.View;

public class HRManager {

    private static final String LINE = "--------------------------------------";

    private static final String[] NAVIGATION_OPTIONS = new String[]{"Exit", "Add Employee", "Edit Employee", "List Employees", "Delete Employee", "OrderBySalaray"};

    private static final Scanner scanner = new Scanner(System.in);

    private static View view = new View();

    public static void main(String[] args) {
        while (true) {
            printMenu();
        }
    }

    private static void printMenu() {
        System.out.println(LINE);
        System.out.println("-------------" + " HR Manager " + "-------------");
        System.out.println(LINE);
        for(int i = 1; i <= NAVIGATION_OPTIONS.length; i++) {
            System.out.println(i + ". " + NAVIGATION_OPTIONS[i-1]);
        }
        System.out.println();
        System.out.println("Please select a option between 1 and " + NAVIGATION_OPTIONS.length + ":");

        selectMenu();

    }

    private static void selectMenu() {
        //TODO: add error handling
        int selectedMenuId = scanner.nextInt();
        showMenu(selectedMenuId);
    }

    private static void showMenu(int selectedMenuId) {
        switch (selectedMenuId) {
            case 1:
            	System.out.println("See you next Time!!");
                System.exit(0);
                break;
            case 2:
                view.showAddEmployee();
                break;
            case 3:
                view.showEditEmployee();
                break;
            case 4:
                view.showListEmployees();
                break;
            case 5:
                view.showDeleteEmployee();
                break;
            case 6:
                view.showEmployeeOrderBySalary();
                break;
            default:
                System.out.println("You selected a invalid option. please select again.");
                selectMenu();
        }

    }

}
