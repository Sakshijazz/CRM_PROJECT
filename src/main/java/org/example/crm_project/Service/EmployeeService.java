package org.example.crm_project.Service;
import org.example.crm_project.Model.Admin;
import org.example.crm_project.Model.Employee;
import org.example.crm_project.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    protected  EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee authenticate(String email, String password, String role) {
        Employee employee = (Employee) employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        if(employee.getPassword().equals(password)) return employee;
         return null;
    }
}