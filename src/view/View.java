package view;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import db.EmployeeDB;
import models.Employee;
import util.HRManagerUtil;

public class View {

	private static final Scanner scanner = new Scanner(System.in);
	private static EmployeeDB db = new EmployeeDB();

	/**
	 * Show the interface to add a employee to the db
	 */
	public void showAddEmployee() {
		//System.out.print("Enter prename of Employee : ");
		Employee toAddEmplyee = employeeData();
		db.addEmployee(toAddEmplyee);
		
	}
	
	
	public Employee employeeData() {
		System.out.print("Enter prename of Employee : ");
		String prename = scanner.next();
		System.out.print("Enter surname of Employee : ");
		String surname = scanner.next();
		System.out.print("Enter jobDescription of Employee : ");
		String jobDescription = scanner.next();
		System.out.print("Enter salary of Employee : ");
		Double salary = scanner.nextDouble();

		try {
			System.out.print("Enter birthdate of Employee in dd.MM.yyyy format : ");
			Date birthdate = HRManagerUtil.formatter.parse(scanner.next());
			System.out.print("Enter employmentDate of Employee in dd.MM.yyyy format: ");
			Date employmentDate = HRManagerUtil.formatter.parse(scanner.next());

			Employee employee = new Employee(prename, surname, jobDescription, birthdate, salary, employmentDate);
			return employee;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Show the interface to edit a employee to the db
	 */
	public void showEditEmployee() {
		// TODO: implement
		System.out.print("Enter id of Employee: ");
		String id = scanner.next();
		Employee toEditEmployee = db.getEmployee(id);
		if (toEditEmployee != null) {
			Employee employeeData = employeeData();
			toEditEmployee.setBirthdate(employeeData.getBirthdate());
			toEditEmployee.setEmploymentDate(employeeData.getEmploymentDate());
			toEditEmployee.setJobDescription(employeeData.getJobDescription());
			toEditEmployee.setPrename(employeeData.getPrename());
			toEditEmployee.setSalary(employeeData.getSalary());
			toEditEmployee.setSurname(employeeData.getSurname());
			
			db.updateEmployee(toEditEmployee);
		} else {
			System.out.println("Employee already exists in DB");
		}

	}

	/**
	 * Show the list of all employees from the db
	 */
	public void showListEmployees() {
		System.out.println("Employee list");
		System.out.println("-------------");
		System.out.println("id | prename |  surname |  jobDescription |  birthdate |  salary |  employmentDate |");
		System.out.println(db.getEmployees());

	}

	/**
	 * Show the interface to delete a employee
	 */
	public void showDeleteEmployee() {
		System.out.print("Enter id of Employee: ");
		String id = scanner.next();
		Employee toDeleteEmployee = db.getEmployee(id);
		if(toDeleteEmployee != null) {
			db.deleteEmployee(toDeleteEmployee);
		} else {
			System.out.println("Employee already exists in DB");
		}
		
	}

	/**
	 * Internal method to print out a employee
	 * 
	 * @param employee to show
	 */
	private void showEmployee(Employee employee) {
		// TODO: implement
		System.out.println(employee);

	}
	
	public void showEmployeeOrderBySalary() {
		
		System.out.println(db.orderEmployeeBySalary("desc"));
	}

}
