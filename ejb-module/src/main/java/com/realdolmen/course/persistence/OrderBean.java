package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by JVDAX31 on 16/09/2015.
 */

@Named
@ConversationScoped
public class OrderBean implements Serializable, OrderBeanInterface {

    Passenger passenger = new Passenger();
    Ticket ticket = new Ticket();

    public OrderBean(){

    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicketToSave(){
        return ticket;
    }
}
