package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JVDAX31 on 19/09/2015.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int serienumber;
    private int price;
    private String description;



    @ManyToMany(mappedBy = "products")
    private List<OnlineOrder> orders = new ArrayList<>();


    protected Product(){

    }

    public Product(String name, int serienumber, int price, String description) {
        this.name = name;
        this.serienumber = serienumber;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerienumber() {
        return serienumber;
    }

    public void setSerienumber(int serienumber) {
        this.serienumber = serienumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<OnlineOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<OnlineOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(OnlineOrder order){
        orders.add(order);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
