package com.services;

import com.model.Orderlist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderlistService {
    List<Orderlist> getOrderlist();

    Orderlist  deleteOrderlist(Orderlist orderlist);

    Orderlist  create(Orderlist orderlist);

    Orderlist  getOrderlist(int id);

    Orderlist  getOrderlistById(int id);

    Orderlist  updateOrderlist(Orderlist orderlist);
    Orderlist  deleteOrderlist (int id);

}
