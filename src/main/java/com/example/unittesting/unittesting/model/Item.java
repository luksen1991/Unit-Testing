package com.example.unittesting.unittesting.model;


import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private int price;

    @Column(name="Quantity")
    private int quantity;

    @Transient
    private int value;

    public Item(){}
    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    @Override
//    public String toString() {
//        return String.format("Item[%d, %s, %d, %d]  ",id,name,price,quantity);
//    }
}
