package com.example.employeeworld.repository;

import com.example.employeeworld.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends CrudRepository<Employee, String> { // class type and primary-key type
}
