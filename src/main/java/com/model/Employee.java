package com.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employeeid")
    private  int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private  String lastname;

    @Column(name = "role")
    private String  role;

    @Column(name = "salary")
    private String  salary;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
