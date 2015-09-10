package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by JVDAX31 on 10/09/2015.
 */
public class TicketPersistenceTest extends DataSetPersistenceTest {


    @Test
    public  void testTicketCanBePerstisted() throws Exception{

        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateformat3.parse("17/07/1989");
        Date now = new Date();
        Address ad = new Address("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);
        CreditCard card2 = new CreditCard("500000", "19/03/2020", 1000, CreditCardType.MASTER);
        List<CreditCard> lst = new ArrayList<CreditCard>();
        lst.add(card);
        lst.add(card2);
        Plane plane = new Plane("a300");
        Passenger p = new Passenger("absc", "Jeroen", "Vdh", 123, date1, now, PassengerType.OCCASIONAL, ad, lst);

        Ticket t = new Ticket(5000.0, Status.PENDING, p);
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(t);
        Flight flight = new Flight("ab100", now, now, tickets, plane);
       // entityManager().persist(p);



        entityManager().persist(flight);
       // entityManager().persist(t);

        assertNotNull(flight.getId());

    }

    /*
    @Test
    public  void passengerCanBeAssignedToTicket(){
        fail("todo");
    }

    */




}
