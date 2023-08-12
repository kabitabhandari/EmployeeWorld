package com.example.employeeworld.repository;

import com.example.employeeworld.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, String> {

}
