package com.ensa.projects.solid.OpenClosed;

import com.ensa.projects.solid.SingleResponsibility.Employee;

import java.sql.Connection;
import java.util.List;

public interface IEmployeeDao {
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int employeeId);
    public List<Employee> getAllEmployees();
}
