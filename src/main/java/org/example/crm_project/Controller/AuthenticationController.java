package org.example.crm_project.Controller;

import org.example.crm_project.Model.Admin;
import org.example.crm_project.Model.Customer;
import org.example.crm_project.Model.Employee;
import org.example.crm_project.Model.Manager;
import org.example.crm_project.Service.AdminService;
import org.example.crm_project.Service.ManagerService;
import org.example.crm_project.Service.EmployeeService;
import org.example.crm_project.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AuthenticationController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public RedirectView signup(@RequestParam String name, @RequestParam String password,
                               @RequestParam String email, @RequestParam Long phone, @RequestParam String role){
        try {
            // Validate inputs
            if (name == null || name.isEmpty() ||
                    password == null || password.isEmpty() ||
                    email == null || email.isEmpty() ||
                    phone == null || role == null || role.isEmpty()) {
                return new RedirectView("/error.html");
            }
            switch (role) {
                case "Admin" -> {
                    Admin admin = new Admin();
                    admin.setName(name);
                    admin.setPassword(password);
                    admin.setEmail(email);
                    admin.setPhone(phone);
                    admin.setRole(role);
                    adminService.saveAdmin(admin);
                    return new RedirectView("/index.html");
                }
                case "Manager" -> {
                    Manager manager = new Manager();
                    manager.setName(name);
                    manager.setPassword(password);
                    manager.setEmail(email);
                    manager.setPhone(phone);
                    manager.setRole(role);
                    managerService.saveManager(manager);
                    return new RedirectView("/index.html");
                }
                case "Employee" -> {
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setPassword(password);
                    employee.setEmail(email);
                    employee.setPhone(phone);
                    employee.setRole(role);
                    employeeService.saveEmployee(employee);
                    return new RedirectView("/index.html");
                }
                case "Customer" -> {
                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setPassword(password);
                    customer.setEmail(email);
                    customer.setPhone(phone);
                    customer.setRole(role);
                    customerService.saveCustomer(customer);
                    return new RedirectView("/index.html");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/error.html");
        }
        return new RedirectView("/error.html");
    }

    @PostMapping("/signin")
    public RedirectView signIn(@RequestParam String email, @RequestParam String password, @RequestParam String role) {
        switch (role.toUpperCase()) {
            case "ADMIN":
                if(adminService.authenticate(email, password, role))
                {
                    return new RedirectView("/index.html");
                }return new RedirectView("/error.html");

            case "MANAGER":
                if(managerService.authenticate(email, password, role))
                {
                    return new RedirectView("/index.html");
                }return new RedirectView("/error.html");

            case "EMPLOYEE":
                if(employeeService.authenticate(email, password, role))
                {
                    return new RedirectView("/index.html");
                }return new RedirectView("/error.html");

            case "CUSTOMER":
                if(customerService.authenticate(email, password, role))
                {
                    return new RedirectView("/index.html");
                }return new RedirectView("/error.html");

            default:
                throw new RuntimeException("Invalid role");
        }

    }
}
