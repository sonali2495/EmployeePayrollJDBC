package com.bridgelabz.model;

import java.util.Scanner;

import com.bridgelabz.dao.EmployeeDao;

public class EmployeeDataExecution {

	public void add() {
		EmployeeDao empDao = new EmployeeDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String empName = sc.next();
		System.out.println("Enter salary: ");
		int salary = sc.nextInt();
		System.out.println("Enter city: ");
		String city = sc.next();
		
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setSalary(salary);
		emp.setCity(city);
		System.out.println(emp);
		boolean result = empDao.insertEmployeeData(emp);
		if(result)
			System.out.println("Employee added successfully!");
		else
			System.out.println("Something went wrong!");
		
	}
	
	public void delete() {
		EmployeeDao empDao = new EmployeeDao();
		System.out.println("Enter employee Id to delete:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		boolean check = empDao.deleteEmployee(id);
		if(check)
			System.out.println("Employee deleted successfully!");
		else
			System.out.println("Something went wrong!");
	}
	
	public void display() {
		EmployeeDao empDao = new EmployeeDao();
		empDao.showTable();
	}

	public void update() {
		EmployeeDao empDao = new EmployeeDao();
		System.out.println("Enter employee Id to for which you want to make the changes:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("Enter option to Update: \n1. Employee Id \n2. Employee Name \n3. Employee Salary \n4. Employee City");
		int option = sc.nextInt();
		boolean check = empDao.updateEmployee(id, option);
		if(check)
			System.out.println("Employee details updated successfully!");
		else
			System.out.println("Something went wrong!");
	}

}
