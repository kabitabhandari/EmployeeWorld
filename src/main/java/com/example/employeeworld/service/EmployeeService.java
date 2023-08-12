package com.example.employeeworld.service;

import com.example.employeeworld.model.Employee;

import java.util.List;

public interface EmployeeService {

    // Save operation
    Employee saveEmployee(Employee department);

    // Read operation
    List<Employee> fetchEmployeeList();

    // Read operation
    List<Employee> fetchEmployeeAndPhoneList();

    // Update operation
    Employee updateEmployee(Employee department, String employeeId);

    // Delete operation
    void deleteEmployeeById(String employeeId);
}
