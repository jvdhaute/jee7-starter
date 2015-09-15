package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JVDAX31 on 11/09/2015.
 */
@Stateless
@LocalBean
public class PassengerEJB implements PassengerEJBRemote {
    @Resource
    TimerService timerService;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Passenger> findPassengers() {
        return entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    /*
    @Schedule(second="0/5", minute = "*", hour ="*", persistent = false)
    public void printTime(){
        Date d = new Date();
        System.out.println(d);
    }
    */

    @Override
    public Passenger findPassengerById(Long id) {

            return (Passenger) entityManager.createQuery("select p from Passenger p where p.id =  :id").setParameter("id", id).getSingleResult();


    }

    @Override
    public Ticket findTicketById(Long id) {

        return (Ticket) entityManager.createQuery("select t from Ticket t where t.id =  :id").setParameter("id", id).getSingleResult();


    }

    @Override
    public void deletePassenger(Passenger passenger) {
            entityManager.remove(entityManager.merge(passenger));
    }

    @Override
    public void updatePassenger(Passenger passenger){
        entityManager.merge(passenger);
    }

    @Override
    public void updateTicket(Ticket ticket){
        entityManager.merge(ticket);
    }



    @Override
    public void createPassenger(Passenger passenger){
        entityManager.persist(passenger);

    }

    @Override
    public void createTicket(Ticket ticket){
        entityManager.persist(ticket);
    }


    public List<Passenger> findPassengersWithFlightDateLast3Hours() {
        Date enddate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(enddate);
        cal.add(Calendar.HOUR, -3);
        Date startdate = cal.getTime();

        return entityManager.createQuery("select p from Passenger p where p.flightDate between :startdate and :enddate", Passenger.class).setParameter("startdate", startdate).setParameter("enddate", enddate).getResultList();
    }


    //@Schedule(hour ="0/3", persistent = false)
    public void remindPassengers(){

        List<Passenger> lst = findPassengersWithFlightDateLast3Hours();
        System.out.println("***************************");
        System.out.println("passengers found with flightdate in last 3 hours:");
        System.out.println(lst.size());
        System.out.println("***************************");

    }

}
