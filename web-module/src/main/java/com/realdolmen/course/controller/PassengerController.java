package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.*;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 15/09/2015.
 */
@Named
@SessionScoped
public class PassengerController implements Serializable {
     @EJB
    private PassengerEJB passengerEJB;

    @EJB
    private TicketEJB ticketEJB;



   private Long id;


    private Passenger passenger = new Passenger();
    private Ticket ticket = new Ticket();
    private String flightID;
    private Date arrivalTime;
    private List<Passenger> passengerList = new ArrayList<Passenger>();
    private List<Flight> flightList = new ArrayList<Flight>();



    public List<Passenger> getAllPassengers(){
        passengerList = passengerEJB.findPassengers();
        return passengerList;
    }

    public String doCreatePassenger(){
        passengerList = getAllPassengers();
        flightList = ticketEJB.getFlights();
        return "bookFlight.xhtml";
    }

    public String bookFlight(){
        ticket.setPassenger(passenger);
        ticket.setStatus(Status.PENDING);
        ticketEJB.createTicket(ticket);
        return "index.html";
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

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
