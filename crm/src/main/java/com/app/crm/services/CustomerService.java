package com.app.crm.services;

import com.app.crm.data.entities.Customer;
import com.app.crm.data.repos.CustomerRepo;
import com.app.crm.data.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


 @Service 
 // class that provides implementations for methods in interface
public class CustomerService implements ICustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    // constructor for class that auto injects instance of CustomerRepo when creating CustomerService obj
    public CustomerService(CustomerRepo customerRepo) {
        // assigns injected instance to customerRepo field
        this.customerRepo = customerRepo;
    }

    @Override
    // implementation of method to fetch customer records from repo and return list
    public List<Customer> getAllCustomers() {
        // create array list called customers
        List<Customer> customers = new ArrayList<>();
        // iterate through and add each customer to list
        customerRepo.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    // implementation of method that finds customer by id 
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    // implementation of method that saves customer to repo
    public void createCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    // implemenetation of method that updates customer by id
    public void updateCustomer(Long id, Customer updatedCustomer) {
        // check if customer exists
        Customer existingCustomer = customerRepo.findById(id).orElse(null);

        // if customer doesnt exist throw an error
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }

        // update fields with the new data
        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setCity(updatedCustomer.getCity());
        existingCustomer.setState(updatedCustomer.getState());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());

        // save updates
        customerRepo.save(existingCustomer);
    }

    @Override
    // implementation of method that deletes a customer by id
    public void deleteCustomer(Long id) {
        // make sure the customer exists
        Customer existingCustomer = customerRepo.findById(id).orElse(null);

        // throw an error if not...
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }

        // delete customer
        customerRepo.delete(existingCustomer);

    }
}
