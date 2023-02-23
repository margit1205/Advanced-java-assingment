package com.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orderlist")
public class Orderlist {


    @Id
    @Column(name = "orderid")
    private  int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }



    @Column(name = "employeeid")
    int empId;

    @Column(name="prescriptionid")
    int presId;

    @Column(name="medid")
    int medId;
    @Column(name = "orderdate")
    private LocalDate orderDate;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Orderlist{" +
                "Id=" + Id +
                ", empId=" + empId +
                ", presId=" + presId +
                ", medId=" + medId +
                ", orderDate=" + orderDate +
                '}';
    }
}
