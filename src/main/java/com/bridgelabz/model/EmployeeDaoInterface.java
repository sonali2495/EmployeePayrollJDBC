package com.bridgelabz.model;

public interface EmployeeDaoInterface {
	public boolean insertEmployeeData(Employee emp);
	public boolean deleteEmployee(int id);
	public void showTable();
	public boolean updateEmployee(int id, int option);
}
