package org.example.crm_project.Repository;

import org.example.crm_project.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Object> findByEmail(String email);
}
