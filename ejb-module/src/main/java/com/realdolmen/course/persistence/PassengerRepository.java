package com.realdolmen.course.persistence;

/**
 * Created by JVDAX31 on 9/09/2015.
 */

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

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
    /*
    public void deleteAll() {
       entityManager.createQuery("delete from Passenger p where p.id > 0").executeUpdate();
    }

    */

    public List<String> findAllLast() {
        return entityManager.createQuery("select p.lastName from Passenger p").getResultList();
    }

    public Object findTotalMiles() {
        return entityManager.createQuery("select SUM(p.frequentFlyerMiles) from Passenger p").getSingleResult();
    }

    public List<Ticket> findTicketsByPassengerID(Long passid){
        return entityManager.createQuery("select t from Ticket t where t.passenger = (select p from Passenger p where p.id =  :id)").setParameter("id", passid).getResultList();

    }

    public void remove(Long id) {
        Passenger p = entityManager.getReference(Passenger.class, id);
        //Ticket t =  entityManager.createQuery("select t from Ticket t where t.id = p.", Passenger.class).getResultList();
        entityManager.remove(p);

    }
}
