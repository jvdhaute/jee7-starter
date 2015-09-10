package com.realdolmen.course.persistence;


import com.realdolmen.course.domain.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by JVDAX31 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void passengerCanBePersisted() throws Exception {
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
        entityManager().persist(p);

        assertNotNull(p.getId());
    }

    @Test
    public void passengerAgeTested() throws Exception {
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateformat3.parse("17/07/1989");
        Date now = new Date();
        Address ad = new Address("Molleweg", "Belgie", "mol", "Affligem", "1790");
        CreditCard card = new CreditCard("5000", "19/03/2020", 1000, CreditCardType.VISA);
        CreditCard card2 = new CreditCard("500000", "19/03/2020", 1000, CreditCardType.VISA);
        List<CreditCard> lst = new ArrayList<CreditCard>();
        lst.add(card);
        lst.add(card2);
        Passenger p = new Passenger("abssdfc", "Jeroen", "Vdhaute", 123, date1, now, PassengerType.OCCASIONAL, ad, lst);
        entityManager().persist(p);
        assertEquals(26, p.getAge());

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
