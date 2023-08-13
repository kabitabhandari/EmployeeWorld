package com.example.employeeworld.serviceImpl;

import com.example.employeeworld.model.Employee;
import com.example.employeeworld.model.Phone;
import com.example.employeeworld.repository.EmployeeRepository;
import com.example.employeeworld.repository.PhoneRepository;
import com.example.employeeworld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PhoneRepository phoneRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PhoneRepository phoneRepository) {
        this.employeeRepository = employeeRepository;
        this.phoneRepository = phoneRepository;
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
    public List<Employee> fetchEmployeeAndPhoneList() {
        List<Employee> employeesList = (List<Employee>) employeeRepository.findAll();
        List<Phone> phonesList = (List<Phone>) phoneRepository.findAll();

        // creating our merged list
        List<Employee> mergedList = new ArrayList<>();

        List<Phone> phoneL = new ArrayList<>();
        Phone phone = new Phone();
        for (Phone p : phonesList) {
            phone.setHomephone(p.getHomephone());
            phone.setPhoneid(p.getOfficephone());
        }
        phoneL.add(phone);


        for (Employee e : employeesList) {
            Employee employee = new Employee();
            employee.setName(e.getName());
            employee.setEmployeeid(e.getEmployeeid());
            employee.setAge(e.getAge());
            employee.setSalary(e.getSalary());
            employee.setJobtitle(e.getJobtitle());
            employee.setPhone(phoneL);
            mergedList.add(employee);
        }
        return mergedList;
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
