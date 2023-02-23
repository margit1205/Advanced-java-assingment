package com.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prescription")
public class Prescription {


    @Id
    @Column(name = "prescriptionid")
    private  int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }



    @Column(name = "docid")
    private int docid;

    @Column(name = "prescriptiondate")
    private LocalDate prescriptionDate;



    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "Id=" + Id +
                ", cusid=" +
                ", docid=" + docid +
                ", prescriptionDate=" + prescriptionDate +
                '}';
    }
}
