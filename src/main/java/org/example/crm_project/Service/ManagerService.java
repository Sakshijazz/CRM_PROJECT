package org.example.crm_project.Service;
import org.example.crm_project.Model.Admin;
import org.example.crm_project.Model.Manager;
import org.example.crm_project.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    protected  ManagerRepository managerRepository;

    public void saveManager(Manager manager) {
        managerRepository.save(manager);
    }

    public boolean authenticate(String email, String password, String role) {
        Manager manager = (Manager) managerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        return manager.getPassword().equals(password);
    }

}
