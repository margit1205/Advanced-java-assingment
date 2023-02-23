package com.services;


import com.model.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImp implements  MedicineService{
    @Autowired

    private SessionFactory sessionFactory;
    private Medicine medicine;


    public List<Medicine> getMedicine(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Medicine>medicineList =session.createQuery("from Medicine",Medicine.class).list();
        transaction.commit();
        session.clear();
        return  medicineList;

    }



    @Override
    public Medicine getMedicineById(int id){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Medicine medicine=session.get(Medicine.class,id);
        transaction.commit();
        session.clear();
        return  medicine;
    }

    @Override
    public Medicine updateMedicine(Medicine medicine){
        this.medicine = medicine;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(medicine);
        transaction.commit();
        session.close();
        return medicine;
    }

    @Override
    public Medicine deleteMedicine(int id) {
        return null;
    }

    @Override
    public Medicine deleteMedicine(Medicine medicine){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(medicine);
        transaction.commit();
        session.close();
        return medicine;
    }

    @Override
    public Medicine create(Medicine medicine) {
        return null;
    }

    @Override
    public Medicine getMedicine(int id) {
        return null;
    }
}
