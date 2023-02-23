package com.services;


import com.model.Medicine;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MedicineService {

    static List<Medicine> getMedicine() {
        return null;
    };

    Medicine create(Medicine medicine);

    Medicine getMedicine(int id);

    Medicine getMedicineById(int id);

    Medicine updateMedicine(Medicine medicine);

    Medicine deleteMedicine (int id);
    Medicine deleteMedicine(Medicine medicine);



}
