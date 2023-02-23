package com.services;

import com.model.Customer;
import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired

    private SessionFactory sessionFactory;
    private Customer customer;

    @Override
    public  List<Customer> getCustomer(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Customer>customerList =session.createQuery("from Customer",Customer.class).list();
        transaction.commit();
        session.clear();
        return  customerList;

    }

    @Override
    public Customer getCustomerById(int id){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
        transaction.commit();
        session.clear();
        return  customer;
    }

    @Override
    public Customer updateCustomer(Customer customer){
        this.customer = customer;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public Customer deleteCustomer(Customer customer){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public Customer deleteCustomer(int id) {
        return null;
    }



    @Override
    public Customer create(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }


}
