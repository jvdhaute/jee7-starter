package com.realdolmen.course.persistence;

/**
 * Created by JVDAX31 on 9/09/2015.
 */

import com.realdolmen.course.domain.Passenger;
import org.junit.Before;
import org.junit.Test;


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
    public void bookCanBeRemovedById() throws Exception {
        repository.remove(2L);
        assertNull(entityManager().find(Passenger.class, 2L));
    }


}
