package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.model.Employee;
import com.bridgelabz.model.EmployeeDaoInterface;
import com.bridgelabz.utility.DBConnection;

public class EmployeeDao implements EmployeeDaoInterface{
	
	public boolean insertEmployeeData(Employee emp) {
		boolean flag = false;
		try {
			//jdbccode
			Connection connection = DBConnection.createConnection();
			String query = "insert into employee(empname, salary, city) values(?,?,?)";
			
			//preparedstatment for dynamic query
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			//to set the values
			preparedStatement.setString(1, emp.getEmpName());
			preparedStatement.setInt(2, emp.getSalary());
			preparedStatement.setString(3, emp.getCity());
			
			//execute
			preparedStatement.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteEmployee(int id) {
		boolean flag = false;
		try {
			//jdbccode
			Connection connection = DBConnection.createConnection();
			String query = "delete from employee where empid=?";
			
			//preparedstatment for dynamic query
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			//to set the values
			preparedStatement.setInt(1, id);
			
			//execute
			preparedStatement.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void showTable() {
		try {
			//jdbccode
			Connection connection = DBConnection.createConnection();
			String query = "select * from employee";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int empId = resultSet.getInt(1);
				String empName = resultSet.getString(2);
				int salary = resultSet.getInt(3);
				String city = resultSet.getString(4);
				
				System.out.println("[EmpId=" + empId + " EmpName=" + empName + " Salary=" + salary + " City=" + city + "]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateEmployee(int id, int option) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		try {
			//jdbccode
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement;
			switch(option) {
				case 1:
					System.out.println("Enter new employee id:");
					int newId = sc.nextInt();				
					String query = "update employee set empid=? where empid=?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, newId);
					preparedStatement.setInt(2, id);
					preparedStatement.executeUpdate();
					break;
				case 2:
					//empname change
					System.out.println("Enter new Employee Name: ");
					String empName = sc.next();
					String query1 = "update employee set empname=? where empid=?";
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setString(1, empName);
					preparedStatement.setInt(2, id);
					preparedStatement.executeUpdate();
					break;
				case 3:
					//salary change
					System.out.println("Enter the New Salary:");
					int salary = sc.nextInt();
					String query2 = "update employe set salary=? where empid=?";
					preparedStatement = connection.prepareStatement(query2);
					preparedStatement.setInt(1, salary);
					preparedStatement.setInt(2, id);
					preparedStatement.executeUpdate();
					break;
				case 4:
					//city change
					System.out.println("Enter the New City:");
					String city = sc.next();
					String query3 = "update employee set city=? where empid=?";
					preparedStatement = connection.prepareStatement(query3);
					preparedStatement.setString(1, city);
					preparedStatement.setInt(2, id);
					preparedStatement.executeUpdate();
					break;
				default:
					System.out.println("Invald Input! \nPlease try again!\n");
					break;
			}
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	
	}
}
