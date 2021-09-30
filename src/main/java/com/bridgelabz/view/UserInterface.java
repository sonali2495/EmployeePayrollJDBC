package com.bridgelabz.view;

import java.util.Scanner;

import com.bridgelabz.model.EmployeeDataExecution;

public class UserInterface {

	public void showUser() {
		System.out.println("Welcome to Employee Payroll Service System:");
		EmployeeDataExecution employeeDataExecution = new EmployeeDataExecution();
		boolean flag = true;
		while(flag) {
			System.out.println("Enter your choice: \n1. Add Employee \n2. Delete Employee \n3. Display Employee \n4. Update \n5. Exit");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			switch(option) {
				case 1:
					employeeDataExecution.add();
					break;
				case 2:
					employeeDataExecution.delete();
					break;
				case 3:
					employeeDataExecution.display();
					break;
				case 4:
					employeeDataExecution.update();
					break;
				case 5:
					System.out.println("Terminated!");
					flag = false;
					break;
				default:
					System.out.println("Invald Input! \nPlease try again!\n");
					break;
			}
		}
	}

}
