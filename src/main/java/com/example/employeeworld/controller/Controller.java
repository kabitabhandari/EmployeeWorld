package com.example.employeeworld.controller;

import com.example.employeeworld.model.Employee;
import com.example.employeeworld.model.ResponseEmployee;
import com.example.employeeworld.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private EmployeeService employeeService;

    @Autowired
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Save operation
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee Employee) {
        return employeeService.saveEmployee(Employee);
    }

    //    // Read operation
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    // Read operation
    @GetMapping(
            value = "/all-employees",
            produces = {MediaType.APPLICATION_JSON_VALUE}, // This api will produce json output
            consumes = {MediaType.APPLICATION_JSON_VALUE}) // This api will accept/consume json input)
    public List<ResponseEmployee> fetchEmployeeAndPhoneList() {
        return employeeService.fetchEmployeeAndPhoneList();
    }

    // Update operation
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(
            @RequestBody Employee employee, @PathVariable("id") String employeeId) {
        return employeeService.updateEmployee(employee, employeeId);
    }

    // Delete operation
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee Deleted Successfully";
    }
}
