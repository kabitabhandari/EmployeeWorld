package com.example.employeeworld.serviceImpl;

import com.example.employeeworld.Employee;
import com.example.employeeworld.repository.EmployeeRepository;
import com.example.employeeworld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee emp, String employeeId) {
        Optional<Employee> updateEmp = employeeRepository.findById(employeeId);
        updateEmp.ifPresent(employee -> {
            employee.setAge(emp.getAge());
            employee.setJobtitle(emp.getJobtitle());
            employee.setName(emp.getName());
            employee.setAge(emp.getAge());
            employeeRepository.save(employee);
        });
        return updateEmp.get();

    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(employeeId);

    }
}
