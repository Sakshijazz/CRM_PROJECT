package org.example.crm_project.Repository;

import org.example.crm_project.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    Optional<Object> findByEmail(String email);
}
