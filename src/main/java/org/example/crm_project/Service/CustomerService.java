package org.example.crm_project.Service;
import org.example.crm_project.Model.Customer;
import org.example.crm_project.Model.Employee;
import org.example.crm_project.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    protected  CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public Customer authenticate(String email, String password, String role) {
        Customer customer = (Customer) customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if( customer.getPassword().equals(password)) return customer;
        return null;
    }
}
