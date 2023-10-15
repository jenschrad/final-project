
package com.app.crm.services;

import com.app.crm.data.entities.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void createCustomer(Customer customer);
    void updateCustomer(Long id, Customer updatedCustomer);
    void deleteCustomer(Long id);
}
