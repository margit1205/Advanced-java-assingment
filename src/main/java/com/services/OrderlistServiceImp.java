package com.services;

import com.model.Orderlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderlistServiceImp implements OrderlistService {
    @Autowired

    private SessionFactory sessionFactory;
    private Orderlist orderlist;

    @Override
    public List<Orderlist> getOrderlist(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Orderlist>orderlist =session.createQuery("from Orderlist",Orderlist.class).list();
        transaction.commit();
        session.clear();
        return  orderlist;

    }

    @Override
    public Orderlist getOrderlistById(int id){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Orderlist orderlist=session.get(Orderlist.class,id);
        transaction.commit();
        session.clear();
        return  orderlist;
    }

    @Override
    public Orderlist updateOrderlist(Orderlist orderlist){
        this.orderlist = orderlist;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(orderlist);
        transaction.commit();
        session.close();
        return orderlist;
    }

    @Override
    public Orderlist deleteOrderlist(int id) {
        return null;
    }

    @Override
    public Orderlist deleteOrderlist(Orderlist orderlist){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(orderlist);
        transaction.commit();
        session.close();
        return orderlist;
    }

    @Override
    public Orderlist create(Orderlist orderlist) {
        return null;
    }

    @Override
    public Orderlist getOrderlist(int id) {
        return null;
    }
}
