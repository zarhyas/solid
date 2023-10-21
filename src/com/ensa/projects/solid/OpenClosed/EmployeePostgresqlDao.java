package com.ensa.projects.solid.OpenClosed;

import com.ensa.projects.solid.SingleResponsibility.Employee;

import java.sql.Connection;
import java.util.List;

public class EmployeePostgresqlDao implements IEmployeeDao{
    private Connection connection; // Initialisation de la connexion à la base de données MySQL.

    public EmployeePostgresqlDao() {
        // Initialisation de la connexion MySQL.
    }

    public void saveEmployee(Employee employee) {
        // Code pour sauvegarder un employé dans Postgres.
    }

    public Employee getEmployeeById(int employeeId) {
        // Code pour récupérer un employé par ID depuis Postgres.
        return null;
    }

    public List<Employee> getAllEmployees() {
        // Code pour récupérer tous les employés depuis Postgres.
        return null;
    }
}


