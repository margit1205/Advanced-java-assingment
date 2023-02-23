package com.services;

import com.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomer();

    Customer deleteCustomer(Customer customer);

    Customer create(Customer customer);

    Customer getCustomer(int id);

    Customer getCustomerById(int id);

    Customer updateCustomer(Customer customer);
    Customer deleteCustomer (int id);




}
