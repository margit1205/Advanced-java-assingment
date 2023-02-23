package com.services;

import com.model.Bill;

import org.springframework.stereotype.Service;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;



public interface BillService {




    List<Bill> getBill();

    Bill deleteBill(Bill bill);

    Bill create(Bill bill);

    Bill getBill(int id);

    Bill getBillById(int id);

    Bill updateBill(Bill bill);
    Bill deleteBill(int id);

}
