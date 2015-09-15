package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Status;

/**
 * Created by JVDAX31 on 15/09/2015.
 */
public interface TicketEJBRemote {
    public void createTicket(Double price, Status status, long passengerID);
    public void updateTicket(String id, String price);
}
