package org.example.crm_project.Repository;

import org.example.crm_project.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Object> findByEmail(String email);
}
