package com.model;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "cusid")
    private  int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(name = "firstname")
    private  String firstname;

    @Column(name = "address")
    private String address;

    @Column(name = "lastname")
    private  String lastname;

    @Column(name = "phone")
    private int phoneNumber;

    @Column(name="dob")
    private LocalDate dob;

    @Column (name = "gender")
    String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}
