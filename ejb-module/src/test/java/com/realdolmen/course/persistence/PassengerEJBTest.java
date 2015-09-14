package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by JVDAX31 on 11/09/2015.
 */
public class PassengerEJBTest extends DataSetPersistenceTest {

    private PassengerEJB passengerEJB;

    @Before
    public void initializeEJB() {
        passengerEJB = new PassengerEJB();
        passengerEJB.entityManager = entityManager();
    }

    @Test
        public void allPassengerCanBeRetrieved() throws Exception {


        List<Passenger> lst = passengerEJB.findPassengers();
        assertEquals(3, lst.size());
    }

    @Test
    public void findPassengerByID() throws Exception {


        Passenger p = passengerEJB.findPassengerById(3l);

        assertEquals("weg", p.getAddress().getStreet1());
    }
    @Test
    public void updatePassengerByID() throws Exception {


        Passenger p = passengerEJB.findPassengerById(3l);
        p.getAddress().setStreet1("vogelzang");
        passengerEJB.updatePassenger(p);
        p = passengerEJB.findPassengerById(3l);

        assertEquals("vogelzang", p.getAddress().getStreet1());
    }



}
