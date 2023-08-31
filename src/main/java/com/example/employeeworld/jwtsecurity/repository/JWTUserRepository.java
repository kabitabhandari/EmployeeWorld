package com.example.employeeworld.jwtsecurity.repository;

import com.example.employeeworld.jwtsecurity.jwtmodel.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// TODO difference between extending CRUD repository and JPA repository
public interface JWTUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
