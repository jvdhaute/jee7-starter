package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by JVDAX31 on 11/09/2015.
 */
@Stateless
@LocalBean
public class PassengerEJB implements PassengerEJBRemote {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Passenger> findPassengers() {
        return entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    @Override
    public Passenger findPassengerById(Long id) {

            return (Passenger) entityManager.createQuery("select p from Passenger p where p.id =  :id").setParameter("id", id).getSingleResult();


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
    public void createPassenger(Passenger passenger){
        entityManager.persist(passenger);
    }

}
