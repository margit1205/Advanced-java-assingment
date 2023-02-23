package com.model;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @Column(name = "orderid")
    private  int Id;

    @Column(name="cusid")
    private  int Customer;

    @Column (name="totalamount")
    private  int Amount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public int getCustomer() {
        return Customer;
    }

    public void setCustomer(int customer) {
        Customer = customer;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "Id=" + Id +
                ", Customer='" + Customer + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}
