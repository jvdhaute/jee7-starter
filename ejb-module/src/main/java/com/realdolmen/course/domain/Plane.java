package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by JVDAX31 on 10/09/2015.
 */
@Entity
public class Plane {
    @Id @GeneratedValue
    private Integer id;
    private String type;


    public Plane(String type) {
        this.type = type;
    }

    protected Plane(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
