package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.persistence.PassengerEJBRemote;
import com.realdolmen.course.persistence.RemoteBookRepository;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by JVDAX31 on 11/09/2015.
 */
public class RemotePassengerEJBTest extends  RemoteIntegrationTest {

    @Test
    public void findAllRetrievesAllPassengersRemotely() throws NamingException {
        PassengerEJBRemote passengerEJBRemote = lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");
        assertEquals(3, passengerEJBRemote.findPassengers().size());
    }


    @Test
    public void findPassengerByID() throws Exception {


        PassengerEJBRemote p =  lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");
        Passenger pas  = p.findPassengerById(3l);

        assertEquals("weg", pas.getAddress().getStreet1());
    }

    @Test
    public void testDeletePassenger() throws Exception {

        PassengerEJBRemote p =  lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");
        Passenger pas  = p.findPassengerById(3l);
        p.deletePassenger(pas);

        assertEquals(2, p.findPassengers().size());

        /*

        PassengerEJBRemote p =  lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");
        Passenger pas  = p.findPassengerById(3l);

        assertEquals("weg", pas.getAddress().getStreet1());

        */
    }


}
