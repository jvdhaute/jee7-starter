package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 10/09/2015.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Flight {
    //
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String number;
    protected Date departureTime;
    protected Date arrivalTime;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    protected Plane plane;


    @OneToMany(cascade = {CascadeType.PERSIST})
    protected List<Ticket> tickets = new ArrayList<Ticket>();
     public Flight(String number, Date departureTime, Date arrivalTime, List<Ticket> tickets, Plane p) {



   // public Flight(String number, Date departureTime, Date arrivalTime, Plane p) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.tickets = tickets;
        this.plane = p;
    }

    public Flight(Date departureTime, Date arrivalTime, String number) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.number = number;
    }

    protected Flight(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }



    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }


}
