package com.model;

import javax.persistence.*;

@Entity
@Table(name = "medicine")
public class Medicine {


    @Id
    @Column(name = "medid")
    private  int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(name="drugname")
    private String name;

    @Column(name="manufacturer")
    private String  brand;

    @Column(name="stock")
    private int  stock;

    @Column(name="price")
    private int price;


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
