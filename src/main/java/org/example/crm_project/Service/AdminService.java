package org.example.crm_project.Service;
import org.example.crm_project.Model.Admin;
import org.example.crm_project.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    protected  AdminRepository adminRepository;

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }


    public boolean authenticate(String email, String password, String role) {
        Admin admin = (Admin) adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return admin.getPassword().equals(password);
    }
}
