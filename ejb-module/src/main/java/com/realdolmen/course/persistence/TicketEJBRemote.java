package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;

import java.util.List;

/**
 * Created by JVDAX31 on 15/09/2015.
 */
public interface TicketEJBRemote {
    public void createTicket(Double price, Status status, long passengerID);
    public void updateTicket(String id, String price);

    public void createTicket(Double price, Status status, long passengerID, long flightID);

    public List<Flight> getFlights();
    public  void createTicket(Ticket t);

    }
