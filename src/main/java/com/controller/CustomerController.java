package com.controller;
import com.model.Customer;
import com.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/customer")

public class CustomerController {

    @Autowired
    CustomerService customerService;

    private static  final Logger logger = LoggerFactory.getLogger(com.controller.CustomerController.class);

    @GetMapping
    public List<Customer> getCustomer(){
        logger.info("Customer List");
        return  customerService.getCustomer();
    }
    @PostMapping("/create")
    public  Customer createCustomer(@RequestBody Customer customer){
        logger.info("create Customer is invoked{}",customer);
        return customerService.create(customer);
    }
    @GetMapping("{Id}")
    public  Customer getCustomerById(@PathVariable("Id")int Id){
        logger.info("getCustomerById is invoked with Customer Id : {}",Id);
        return customerService.getCustomerById(Id);

    }
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return  customerService.updateCustomer(customer);

    }
    @DeleteMapping("/{Id}")
    public Customer deleteCustomerById(@PathVariable("Id") int Id){
        return customerService.deleteCustomer(Id);
    }

}
