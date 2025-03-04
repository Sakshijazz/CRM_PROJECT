package org.example.crm_project.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.crm_project.Model.Admin;
import org.example.crm_project.Model.Customer;
import org.example.crm_project.Model.Employee;
import org.example.crm_project.Model.Manager;
import org.example.crm_project.Service.AdminService;
import org.example.crm_project.Service.ManagerService;
import org.example.crm_project.Service.EmployeeService;
import org.example.crm_project.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/konnekt")
@CrossOrigin(origins = "http://localhost:5173")
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
    public RedirectView signIn(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,
            RedirectAttributes redirectAttributes) { // Use RedirectAttributes to pass data during redirect

        switch (role.toUpperCase()) {
            case "ADMIN":
                Admin admin = adminService.authenticate(email, password, role);
                if (admin != null) {
                    // Add the admin object to RedirectAttributes
                    redirectAttributes.addFlashAttribute("user", admin);
                    return new RedirectView("/index"); // Redirect to the index page
                }
                return new RedirectView("/error"); // Redirect to the error page

            case "MANAGER":
                Manager manager = managerService.authenticate(email, password, role);
                if (manager != null) {
                    // Add the manager object to RedirectAttributes
                    redirectAttributes.addFlashAttribute("user", manager);
                    return new RedirectView("/index"); // Redirect to the index page
                }
                return new RedirectView("/error"); // Redirect to the error page

            case "EMPLOYEE":
                Employee employee = employeeService.authenticate(email, password, role);
                if (employee != null) {
                    // Add the employee object to RedirectAttributes
                    redirectAttributes.addFlashAttribute("user", employee);
                    return new RedirectView("/employeeHome.html"); // Redirect to the employee home page
                }
                return new RedirectView("/error"); // Redirect to the error page

            case "CUSTOMER":
                Customer customer = customerService.authenticate(email, password, role);
                if (customer != null) {
                    // Add the customer object to RedirectAttributes
                    redirectAttributes.addFlashAttribute("user", customer);
                    return new RedirectView("/index"); // Redirect to the index page
                }
                return new RedirectView("/error"); // Redirect to the error page

            default:
                throw new RuntimeException("Invalid role");
        }

    }

}
