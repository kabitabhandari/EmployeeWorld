package com.example.employeeworld.controller;

import com.example.employeeworld.model.Employee;
import com.example.employeeworld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private  EmployeeService employeeService;

    @Autowired
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Save operation
    @PostMapping("/employees")
    public Employee saveEmployee(
            @RequestBody Employee Employee)
    {
        return employeeService.saveEmployee(Employee);
    }

    // Read operation
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList()
    {
        return employeeService.fetchEmployeeList();
    }

    // Read operation
    @GetMapping("/employees-and-phones")
    public List<Employee> fetchEmployeeAndPhoneList()
    {
        return employeeService.fetchEmployeeAndPhoneList();
    }

    // Update operation
    @PutMapping("/employees/{id}")
    public Employee
    updateEmployee(@RequestBody Employee employee,
                     @PathVariable("id") String employeeId)
    {
        return employeeService.updateEmployee(
                employee, employeeId);
    }

    // Delete operation
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id")
                                               String employeeId)
    {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee Deleted Successfully";
    }
}
