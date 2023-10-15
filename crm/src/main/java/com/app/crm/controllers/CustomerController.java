
package com.app.crm.controllers;

import com.app.crm.data.entities.Customer;
import com.app.crm.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer") // base url for endpoints
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    // dependency injection 
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    // gets list of customers and adds to model obj to pass to thymeleaf template and returns view 
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer/index";
    }

    @GetMapping("/create")
    // displays form to create a new customer, adds empty customer obj to model and returns view
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    // processes form submission for creating new customer
    public String createCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("success", true);
        return "customer/create";
    }

    @GetMapping("/update/{id}")
    // updates 
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);

        // redirect if customer doesnt exist
        if (customer == null) {
            return "redirect:/customer/";
        }

        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@ModelAttribute Customer updatedCustomer, Model model) {
        Long id = updatedCustomer.getId();
        // call the update method from the service
        customerService.updateCustomer(id, updatedCustomer);
        model.addAttribute("success", true);
        return "customer/update";
    }


    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);

        // redirect if customer doesn't exist
        if (customer == null) {
            return "redirect:/customer/";
        }

        model.addAttribute("customer", customer);
        return "customer/delete";
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id, Model model) {

        // call delete method from service
        customerService.deleteCustomer(id);
        model.addAttribute("success", true);
        return "redirect:/customer/";

    }
    
}
