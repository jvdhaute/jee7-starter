package com.realdolmen.course.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JVDAX31 on 19/09/2015.
 */
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int serienumber;
    private int price;
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();


}
