package org.example.crm_project.Repository;

import org.example.crm_project.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Object> findByEmail(String email);
}
