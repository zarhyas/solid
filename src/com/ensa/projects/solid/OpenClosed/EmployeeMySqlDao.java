package com.ensa.projects.solid.OpenClosed;

import com.ensa.projects.solid.SingleResponsibility.Employee;

import java.sql.Connection;
import java.util.List;

public class EmployeeMySqlDao implements IEmployeeDao{
    private Connection connection; // Initialisation de la connexion à la base de données MySQL.

    public EmployeeMySqlDao() {
        // Initialisation de la connexion MySQL.
    }

    public void saveEmployee(Employee employee) {
        // Code pour sauvegarder un employé dans MySQL.
    }

    public Employee getEmployeeById(int employeeId) {
        // Code pour récupérer un employé par ID depuis MySQL.
        return null;
    }

    public List<Employee> getAllEmployees() {
        // Code pour récupérer tous les employés depuis MySQL.
        return null;
    }
}

