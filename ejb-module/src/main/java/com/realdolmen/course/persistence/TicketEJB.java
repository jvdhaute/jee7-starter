package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Status;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by JVDAX31 on 15/09/2015.
 */

@Stateless
@LocalBean
public class TicketEJB implements TicketEJBRemote {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createTicket(Double price, Status status, long passengerID) {
      Passenger passenger = (Passenger) entityManager.createQuery("select p from Passenger p where p.id =  :id").setParameter("id", passengerID).getSingleResult();
      Ticket ticket = new Ticket(price, status, passenger);
      entityManager.persist(ticket);
    }

    @Override
    public void createTicket(Double price, Status status, long passengerID, long flightID) {
        Passenger passenger = (Passenger) entityManager.createQuery("select p from Passenger p where p.id =  :id").setParameter("id", passengerID).getSingleResult();
        Ticket ticket = new Ticket(price, status, passenger);
        entityManager.persist(ticket);
    }

    @Override
    public void updateTicket(String id, String price) {
        Ticket t =  (Ticket) entityManager.createQuery("select t from Ticket t where t.id =  :id").setParameter("id", (Long.parseLong(id, 10))).getSingleResult();
        t.setPrice(Double.parseDouble(price));
        entityManager.merge(t);

    }

    @Override
    public List<Flight> getFlights(){
        return entityManager.createQuery("select f from Flight f", Flight.class).getResultList();
    }


    @Override
    public  void createTicket(Ticket t){
     //   entityManager.merge(t.getPassenger());
        entityManager.persist(t);
    }

    @Override
    public Flight getFlightforID(long flightID) {
        Flight flight = (Flight) entityManager.createQuery("select f from Flight f where f.id =  :id").setParameter("id", flightID).getSingleResult();
        return flight;
    }
}
