package com.example.employeeworld.serviceImpl;

import com.example.employeeworld.model.Employee;
import com.example.employeeworld.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        verify(mockedUserRepository, times(1)).save(Mockito.any(Employee.class));
    }

    @Test
    void fetchEmployeeList() {
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
}