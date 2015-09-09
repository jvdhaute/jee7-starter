package com.realdolmen.course.persistence;

/**
 * Created by JVDAX31 on 9/09/2015.
 */

import com.realdolmen.course.domain.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class PassengerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Passenger> findAll() {
        return entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    public void remove(Long id) {
        entityManager.remove(entityManager.getReference(Passenger.class, id));
    }
}
