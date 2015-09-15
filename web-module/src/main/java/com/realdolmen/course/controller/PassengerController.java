package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.persistence.PassengerEJB;
import com.realdolmen.course.persistence.PassengerEJBRemote;
import com.realdolmen.course.persistence.PassengerRepository;
import com.realdolmen.course.persistence.TicketEJB;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 15/09/2015.
 */
@Named
@RequestScoped
public class PassengerController {
     @EJB
    private PassengerEJB passengerEJB;

    @EJB
    private TicketEJB ticketEJB;

    private Passenger passenger = new Passenger();
    private Ticket ticket = new Ticket();
    private String flightID;
    private Date arrivalTime;
    private List<Passenger> passengerList = new ArrayList<Passenger>();
    private List<Flight> flightList = new ArrayList<Flight>();

    private Long id;
    private Long passengerID;

    public List<Passenger> getAllPassengers(){
        System.out.println("all passengers  requested");
        passengerList = passengerEJB.findPassengers();
        return passengerList;
    }

    public String doCreatePassenger(){
        passengerEJB.createPassenger(passenger);
        passengerList = getAllPassengers();
        flightList = ticketEJB.getFlights();
        //System.out.println
        return "bookFlight.xhtml";
    }

    public String bookFlight(){
        System.out.println("flightid: "+ id);
        passenger = passengerEJB.findPassengerById(passenger.getId());
        System.out.println(passenger.getBirthDate());
        ticket.setPassenger(passenger);
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

    public Long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Long passengerID) {
        this.passengerID = passengerID;
    }
}
