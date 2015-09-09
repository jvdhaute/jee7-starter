package com.realdolmen.course.persistence;


import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;


/**
 * Created by JVDAX31 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger p = new Passenger("absc", "Jeroen", "Vdh", 123);
        entityManager().persist(p);
        assertNotNull(p.getId());
    }
/*
    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutTitle() throws Exception {
        Passenger p = new Book(null, "John Doe", Book.Genre.thriller);
        entityManager().persist(book);
    }
*/


    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("Jeroen", entityManager().find(Passenger.class, 1L).getFirstName());
    }


}
