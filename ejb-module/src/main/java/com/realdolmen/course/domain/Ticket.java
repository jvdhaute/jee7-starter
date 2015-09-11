package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by JVDAX31 on 10/09/2015.
 */

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Passenger passenger;
    /*
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Flight flight;
    */
    public Ticket(Double price, Status status, Passenger passenger, Flight flight) {
        this.price = price;
        this.status = status;
        this.passenger = passenger;
     //   this.flight = flight;
    }
    public Ticket(Double price, Status status, Passenger passenger) {
        this.price = price;
        this.status = status;
        this.passenger = passenger;
        //   this.flight = flight;
    }

    protected Ticket(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /*
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    */
}
