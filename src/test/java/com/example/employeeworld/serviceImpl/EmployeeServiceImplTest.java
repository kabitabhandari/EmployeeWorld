package com.example.employeeworld.serviceImpl;

import com.example.employeeworld.model.Employee;
import com.example.employeeworld.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository mockedUserRepository;
    @InjectMocks
    private EmployeeServiceImpl service;


    @Test
    void saveEmployeeShouldReturnEmployeeUsingAssertApproach() {
        when(mockedUserRepository.save(any())).thenReturn(new Employee("1","rammy",22,"student", 1200));
        Employee result = service.saveEmployee(new Employee("1","rammy",22,"student", 1200));
        //assertion statement
        Assertions.assertEquals("rammy",result.getName());
    }
    @Test
    void saveEmployeeShouldReturnEmployeeUSingVerifyApproach() {
        when(mockedUserRepository.save(any())).thenReturn(new Employee());
        service.saveEmployee(new Employee());
        //verify method
        verify(mockedUserRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void fetchEmployeeListShouldReturnListOfEmployeesAssertApproach() {
        when(mockedUserRepository.findAll()).thenReturn(employeeListMocked());
        List<Employee> list = service.fetchEmployeeList();
        Assertions.assertEquals("Debra", list.get(0).getName());
    }
    @Test
    void fetchEmployeeListShouldReturnListOfEmployeesVerifyApproach() {
        when(mockedUserRepository.findAll()).thenReturn(employeeListMocked());
        service.fetchEmployeeList();
        verify(mockedUserRepository, times(1)).findAll();

    }

    @Test
    void fetchEmployeeAndPhoneList() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployeeById() {
    }

    private List<Employee> employeeListMocked(){
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmployeeid("100");
        employee.setSalary(800);
        employee.setAge(22);
        employee.setJobtitle("nurse");
        employee.setName("Debra");

        employeeList.add(employee);
        return employeeList;
    }
}