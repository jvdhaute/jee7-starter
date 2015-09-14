package com.realdolmen.course.persistence;

/**
 * Created by JVDAX31 on 9/09/2015.
 */

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.domain.Ticket;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;


public class PassengerRepositoryTest extends  DataSetPersistenceTest {
    private PassengerRepository repository;

    @Before
    public void initializeRepository() {
        repository = new PassengerRepository();
        repository.entityManager = entityManager();
    }


    @Test
    public void allPassengerCanBeRetrieved() throws Exception {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    public void allPassengerLastNamesCanBeRetrieved() throws Exception {
        List<String> lst = repository.findAllLast();

        assertEquals("Vdh", lst.get(0));
    }

    @Test
       public void calcTotalSum() throws Exception {
        long total = (long) repository.findTotalMiles();
        assertEquals(5505L, total);
    }


    @Test
    public void findTicketsforPassenger() throws Exception {
        List<Ticket> lst = repository.findTicketsByPassengerID(1L);
        assertEquals(0, lst.size());
    }

    /*
    @Test
    public void allPassengersAreDeleted() throws Exception {
        repository.deleteAll();
        assertEquals(0, repository.findAll().size());
    }
    */

    /*
    @Test
    public void passengerCanBeRemovedById() throws Exception {
        repository.remove(2L);
        assertNull(entityManager().find(Passenger.class, 2L));
    }

    */


    @Test
    public void retrieveById() throws Exception {
        Passenger p = entityManager().find(Passenger.class, 1L);
        assertEquals(p.getFirstName(), "Jeroen");
    }

    @Test
    public void updateById() throws Exception {
        EntityManager e = entityManager();

        Passenger p = e.find(Passenger.class, 1L);
        p.setFirstName("Jon");
        e.flush();
        assertEquals(p.getFirstName(), "Jon");
    }


    @Test
    public void testIFAttached() throws Exception {
        EntityManager e  = entityManager();
        Passenger p = e.find(Passenger.class, 1L);
        assertTrue(e.contains(p));
    }


}
