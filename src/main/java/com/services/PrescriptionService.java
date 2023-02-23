package com.services;


import com.model.Prescription;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PrescriptionService {


    List<Prescription > getPrescription();



    Prescription deletePrescription(Prescription prescription);



    Prescription create(Prescription prescription);

    Prescription getPrescription(int id);



    Prescription getPrescriptionById(int id);

    static Prescription updatePrescription(Prescription prescription) {
        return null;
    }

    Prescription deletePrescription(int id);



}
