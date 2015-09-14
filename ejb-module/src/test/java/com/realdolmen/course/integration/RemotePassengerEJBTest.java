package com.realdolmen.course.integration;

import com.realdolmen.course.domain.*;
import com.realdolmen.course.persistence.PassengerEJBRemote;
import com.realdolmen.course.persistence.RemoteBookRepository;
import org.junit.Test;

import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void updatePassengerByID() throws Exception {
        PassengerEJBRemote passengerEJBRemote =  lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");

        Passenger p = passengerEJBRemote.findPassengerById(3l);
        p.getAddress().setStreet1("vogelzang");
        passengerEJBRemote.updatePassenger(p);
        p = passengerEJBRemote.findPassengerById(3l);

        assertEquals("vogelzang", p.getAddress().getStreet1());
    }


    @Test
    public void createPassenger() throws Exception {
        PassengerEJBRemote passengerEJBRemote =  lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.persistence.PassengerEJBRemote");
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateformat3.parse("17/07/1989");
        Date now = new Date();
        Address ad = new Address("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);
        CreditCard card2 = new CreditCard("500000", "19/03/2020", 1000, CreditCardType.MASTER);
        List<CreditCard> lst = new ArrayList<CreditCard>();
        lst.add(card);
        lst.add(card2);
        Passenger p = new Passenger("absc", "Jeroen", "Vdh", 123, date1, now, PassengerType.OCCASIONAL, ad, lst);
        passengerEJBRemote.createPassenger(p);
        p = passengerEJBRemote.findPassengerById(4l);
        assertNotNull(p.getId());
    }


}
