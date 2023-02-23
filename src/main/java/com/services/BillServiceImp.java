package com.services;

import com.model.Bill;
import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImp implements BillService {
    @Autowired

    private SessionFactory sessionFactory;
    private Bill bill;

    @Override
    public List<Bill> getBill(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Bill>billList =session.createQuery("from Bill",Bill.class).list();
        transaction.commit();
        session.clear();
        return  billList;

    }



    @Override
    public Bill getBillById(int id){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Bill bill=session.get(Bill.class,id);
        transaction.commit();
        session.clear();
        return  bill;
    }

    @Override
    public Bill updateBill(Bill customer){
        this.bill = bill;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(bill);
        transaction.commit();
        session.close();
        return bill;
    }
    @Override
    public Bill deleteBill(Bill customer){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(bill);
        transaction.commit();
        session.close();
        return bill;
    }

    @Override
    public Bill deleteBill(int id) {
        return null;
    }



    @Override
    public Bill create(Bill bill) {
        return null;
    }

    @Override
    public Bill getBill(int id) {
        return null;
    }

}
