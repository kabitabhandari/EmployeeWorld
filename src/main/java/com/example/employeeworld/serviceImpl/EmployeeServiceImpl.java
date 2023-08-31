package com.example.employeeworld.serviceImpl;

import com.example.employeeworld.model.Employee;
import com.example.employeeworld.model.Phone;
import com.example.employeeworld.model.ResponseEmployee;
import com.example.employeeworld.repository.EmployeeRepository;
import com.example.employeeworld.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

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
    public List<ResponseEmployee> fetchEmployeeAndPhoneList() {
        List<Employee> employeesList = (List<Employee>) employeeRepository.findAll();

        // creating our merged list
        List<ResponseEmployee> mergedList = new ArrayList<>();

        for (Employee e : employeesList) {
            ResponseEmployee employee = new ResponseEmployee();
            employee.setName(e.getName());
            employee.setEmployeeid(e.getEmployeeid());
            employee.setAge(e.getAge());
            employee.setSalary(e.getSalary());
            employee.setJobtitle(e.getJobtitle());
            Phone phone = new Phone();
            phone.setHomephone(randomPhone());
            phone.setOfficephone(randomPhone());
            employee.setPhone(phone);
            mergedList.add(employee);
        }
        return mergedList;
    }

    @Override
    public Employee updateEmployee(Employee emp, String employeeId) {
        Optional<Employee> updateEmp = employeeRepository.findById(employeeId);
        updateEmp.ifPresent(
                employee -> {
                    employee.setAge(emp.getAge());
                    employee.setJobtitle(emp.getJobtitle());
                    employee.setName(emp.getName());
                    employee.setAge(emp.getAge());
                    employee.setSalary(emp.getSalary());
                    employeeRepository.save(employee);
                });
        return updateEmp.get();
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    /**
     * Generates random phone number
     *
     * @return String
     */
    private String randomPhone() {
        Random number = new Random();
        Integer num = number.nextInt(100000);
        return num.toString() + num.toString();
    }
}
