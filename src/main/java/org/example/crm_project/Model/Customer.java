package org.example.crm_project.Model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int cust_id;
    protected String name;
    protected String email;
    protected Long phone;
    protected String password;
    protected String role;
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    private Manager manager;

    public Customer() {
    }

    public Customer(int cust_id, String name, String email, Long phone, String password, String role, Employee employee, Manager manager) {
        this.cust_id = cust_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.employee = employee;
        this.manager = manager;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", employee=" + employee +
                ", manager=" + manager +
                '}';
    }
}
