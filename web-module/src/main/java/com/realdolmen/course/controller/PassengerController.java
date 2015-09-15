package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.PassengerEJB;
import com.realdolmen.course.persistence.PassengerEJBRemote;
import com.realdolmen.course.persistence.PassengerRepository;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JVDAX31 on 15/09/2015.
 */
@Named
@RequestScoped
public class PassengerController {
     @EJB
    private PassengerEJB passengerEJB;

    private Passenger passenger = new Passenger();
    private Ticket ticket = new Ticket();
    private double flightid;

    private List<Passenger> passengerList = new ArrayList<Passenger>();


    public List<Passenger> getAllPassengers(){
        System.out.println("all passengers  requested");
        passengerList = passengerEJB.findPassengers();
        return passengerList;
    }

    public String doCreatePassenger(){
        passengerEJB.createPassenger(passenger);
        passengerList = getAllPassengers();
        return "allPassengers.xhtml";
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
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

    public double getFlightid() {
        return flightid;
    }

    public void setFlightid(double flightid) {
        this.flightid = flightid;
    }
}
