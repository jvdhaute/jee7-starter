package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 19/09/2015.
 */


public class Order {

    private Integer id;
    private Date orderDate;
    private boolean payed;

    /*
    @ManyToMany
    @JoinTable(name ="order_products",
        joinColumns = @JoinColumn(name = "order_fk"),
        inverseJoinColumns = @JoinColumn(name = "product_fk"))
    private List<Product> products = new ArrayList<>();

    */


    protected Order(){

    };

    public Order(boolean payed, Date orderDate) {
        this.payed = payed;
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }


    /*
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
