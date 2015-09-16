package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

/**
 * Created by JVDAX31 on 16/09/2015.
 */
public interface OrderBeanInterface {

    public Passenger getPassenger();

    public void setPassenger(Passenger passenger);
    public Ticket getTicket();

    public void setTicket(Ticket ticket);

    public Ticket getTicketToSave();
}
