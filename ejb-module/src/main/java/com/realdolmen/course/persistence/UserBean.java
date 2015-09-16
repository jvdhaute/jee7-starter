package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by JVDAX31 on 16/09/2015.
 */

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    Passenger passenger;

    public UserBean(){

    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
