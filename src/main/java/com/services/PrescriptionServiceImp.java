package com.services;


import com.model.Prescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PrescriptionServiceImp implements PrescriptionService{
    @Autowired

    private SessionFactory sessionFactory;
    private Prescription prescription;

    @Override
    public List<Prescription > getPrescription(){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        List<Prescription >prescriptionList =session.createQuery("from Prescription ",Prescription .class).list();
        transaction.commit();
        session.clear();
        return  prescriptionList;

    }

    @Override
    public Prescription  getPrescriptionById(int id){
        Session session =sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Prescription  prescription=session.get(Prescription .class,id);
        transaction.commit();
        session.clear();
        return  prescription;
    }


    public Prescription  updatePrescription(Prescription prescription){
        this.prescription =prescription;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(prescription);
        transaction.commit();
        session.close();
        return prescription;
    }

    @Override
    public Prescription deletePrescription(int id) {
        return null;
    }

    @Override
    public Prescription deletePrescription(Prescription prescription){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(prescription);
        transaction.commit();
        session.close();
        return prescription;
    }





    @Override
    public Prescription create(Prescription prescription) {
        return null;
    }

    @Override
    public Prescription getPrescription(int id) {
        return null;
    }


}



