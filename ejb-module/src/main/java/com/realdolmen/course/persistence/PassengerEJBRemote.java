package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by JVDAX31 on 11/09/2015.
 */

@Remote
public interface PassengerEJBRemote {

    List<Passenger> findPassengers();
    Passenger findPassengerById(Long id);

    void deletePassenger(Passenger passenger);

    void updatePassenger(Passenger passenger);

    void updateTicket(Ticket ticket);

    void createPassenger(Passenger passenger);

    void createTicket(Ticket ticket);

    public Ticket findTicketById(Long id);
}
