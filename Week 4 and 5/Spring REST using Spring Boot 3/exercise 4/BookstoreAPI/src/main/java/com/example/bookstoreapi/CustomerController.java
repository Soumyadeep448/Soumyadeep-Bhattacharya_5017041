package com.example.bookstoreapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // Initialize with some sample data
    public CustomerController() {
        customers.add(new Customer(1L, "John Doe", "john.doe@example.com", "123 Main St"));
    }

    // POST endpoint to create a new customer using JSON request body
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // POST endpoint to process form data for customer registration
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public Customer registerCustomer(@RequestParam String name,
                                     @RequestParam String email,
                                     @RequestParam String address) {
        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1));
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customers.add(customer);
        return customer;
    }

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
