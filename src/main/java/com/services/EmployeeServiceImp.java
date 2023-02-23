package com.services;


import com.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired

    private SessionFactory sessionFactory;
    private Employee employee;

    @Override
    public List< Employee> getEmployee(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Employee> employeeList =session.createQuery("from Employee", Employee.class).list();
        transaction.commit();
        session.clear();
        return  employeeList;

    }

    @Override
    public  Employee getEmployeeById(int id){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Employee  employee=session.get( Employee.class,id);
        transaction.commit();
        session.clear();
        return   employee;
    }

    @Override
    public  Employee updateEmployee ( Employee  employee){
        this. employee =  employee;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate( employee);
        transaction.commit();
        session.close();
        return  employee;
    }



    @Override
    public  Employee deleteEmployee ( Employee employee){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete( employee);
        transaction.commit();
        session.close();
        return  employee;
    }

    @Override
    public Employee create(Employee employee) {
        return null;
    }
    @Override
    public Employee  deleteEmployee (int id) {
        return null;
    }
    @Override
    public Employee getEmployee(int id) {
        return null;
    }
}
